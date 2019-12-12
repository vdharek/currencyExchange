package com.currencyExchangeRates.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.currencyExchangeRates.models.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, String> {

	@Override
	List<Currency> findAll();
	
}
