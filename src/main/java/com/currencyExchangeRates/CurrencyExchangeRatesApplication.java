package com.currencyExchangeRates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CurrencyExchangeRatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeRatesApplication.class, args);
	}

}
