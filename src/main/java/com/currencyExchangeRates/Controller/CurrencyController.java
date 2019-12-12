package com.currencyExchangeRates.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.currencyExchangeRates.models.Currency;
import com.currencyExchangeRates.models.CurrencyConversion;
import com.currencyExchangeRates.service.CurrencyService;

@RestController
@RequestMapping("/api")
public class CurrencyController {
	
	CurrencyService currencyService;
	
	public CurrencyController(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}
	
	@GetMapping("/currency")
	public List<Currency> findAll(){
		return currencyService.getAllCurrencies();
	}
	
	@RequestMapping(value = "/convert/from{from}/to{to}/value{value}", produces = { "application/json" }, method = RequestMethod.POST)
	//@PostMapping("/convert/from{from}/to{to}/value{value}")
	public ResponseEntity<Double> convertCurrencies(CurrencyConversion currencyConversion){
		Optional<Double> resultOptional = this.currencyService.convert(currencyConversion);
		if(resultOptional.isPresent()) {
			return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
