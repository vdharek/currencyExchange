package com.currencyExchangeRates.models;

import java.lang.Double;

public class CurrencyConversion {
	
	private String to;
	private String from;
	private Double value;
	
	public CurrencyConversion() {
		
	}

	public CurrencyConversion(String to, String from, Double value) {
		this.to = to;
		this.from = from;
		this.value = value;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	/*@Override
	public String toString() {
		return "CurrencyConversion [to=" + to + ", from=" + from + ", value=" + value + "]";
	}*/

}
