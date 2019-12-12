package com.currencyExchangeRates.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.currencyExchangeRates.models.Currency;
import com.currencyExchangeRates.models.CurrencyDTO;
import com.currencyExchangeRates.models.Rates;
import com.currencyExchangeRates.repository.CurrencyRepository;

@Component
public class CurrencyProcess {

	@Autowired
	private CurrencyRepository currencyRepository;
	
	@Scheduled(fixedRate = 5 * 1000 * 60 * 60)
	private void getUpdatedRates() {
		
		try {
			RestTemplate restTemplate = new RestTemplate();
			
			/*ResponseEntity responseEntity = restTemplate.getForEntity("http://api.nbp.pl/api/exchangerates/tables/a/", 
					CurrencyDTO[].class).getBody();*/
			
			CurrencyDTO[] forObject = 
					restTemplate.getForEntity("http://api.nbp.pl/api/exchangerates/tables/a/", 
							CurrencyDTO[].class).getBody();
			
			currencyRepository.deleteAll();
			
			for (CurrencyDTO currencyDTO1 : forObject) {
                for (Rates rate : currencyDTO1.getRates()) {
                    Currency currency = new Currency(rate.getCode(), rate.getRate());
                    
                    this.currencyRepository.save(currency);
                }
			}
		}catch (RestClientException ex) {
			System.out.println(ex.getMessage());
		}		
	}
}

/*forObject.getRates().forEach((key, value) -> {
Currency currency = new Currency(rate.getCode(), rate.getRate());
this.currencyRepository.save(currency);	*/

/*
ResponseEntity<CurrencyDTO> responseEntity = 
	restTemplate.getForEntity("http://api.nbp.pl/api/exchangerates/tables/a/", CurrencyDTO.class);
CurrencyDTO currencyDTO = responseEntity.getBody();
MediaType contentType = responseEntity.getHeaders().getContentType();
HttpStatus statusCode = responseEntity.getStatusCode();

currencyDTO.getRates().forEach((key, value) -> {
Currency currency = new Currency(key, value);
this.currencyRepository.save(currency);*/
