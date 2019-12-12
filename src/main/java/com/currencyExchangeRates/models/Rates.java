package com.currencyExchangeRates.models;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Rates {
	
	public Rates() {
		
	}
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("mid")
	private Double rate;
	
	//private Map<String, Double> price;
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Rates(String currency, String code, Double rate) {
		this.currency = currency;
		this.code = code;
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Rates [currency=" + currency + ", code=" + code + ", rate=" + rate + "]";
	}
	
	
	
	/*public Map<String, Double> getPrice() {
		return price;
	}
	public void setPrice(Map<String, Double> price) {
		this.price = price;
	}
	
	public Rates(String currency, Map<String, Double> price) {
		super();
		this.currency = currency;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Rates [currency=" + currency + ", price=" + price + "]";
	}*/
	
}
