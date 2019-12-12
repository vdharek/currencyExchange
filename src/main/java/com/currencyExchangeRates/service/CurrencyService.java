package com.currencyExchangeRates.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.currencyExchangeRates.models.Currency;
import com.currencyExchangeRates.models.CurrencyConversion;
import com.currencyExchangeRates.repository.CurrencyRepository;

@Service
public class CurrencyService {
	
	private CurrencyRepository currencyRepository;
	
	public CurrencyService(CurrencyRepository currencyRepository) {
		this.currencyRepository = currencyRepository;
	}
	
	public List<Currency> getAllCurrencies(){
		
		List<Currency> currencyList = this.currencyRepository.findAll();
		currencyList.sort(Comparator.comparing(Currency::getName));
		
		return currencyList;
	}	
	
	public Optional<Double> convert(CurrencyConversion currencyConversion) {
		
		Optional<Currency> toOptional = 
				this.currencyRepository.findById(currencyConversion.getTo().toUpperCase());
		Optional<Currency> fromOptional = 
				this.currencyRepository.findById(currencyConversion.getFrom().toUpperCase());
		
		if(toOptional.isPresent() && fromOptional.isPresent()) {
			if(currencyConversion.getValue() < 0) {
				return Optional.empty();
			}
			
			Currency to = toOptional.get();
			Currency from = fromOptional.get();
			Double toValue = to.getValues();
			Double fromValue = from.getValues();
			
			Double result = toValue * currencyConversion.getValue() / fromValue;
			
			return Optional.of(result);
			
		}
		
		return Optional.empty();
	}
}
