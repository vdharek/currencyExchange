package com.currencyExchangeRates.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyDTO {

	@JsonProperty("table")
	private String table;
	
	@JsonProperty("no")
	private String num;
	
	@JsonProperty("effectiveDate")
	private String date;
	
	private List<Rates> rates;
	
	public CurrencyDTO() {
		
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Rates> getRates() {
		return rates;
	}

	public void setRates(List<Rates> rates) {
		this.rates = rates;
	}

	public CurrencyDTO(String table, String num, String date, List<Rates> rates) {
		super();
		this.table = table;
		this.num = num;
		this.date = date;
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "CurrencyDTO [table=" + table + ", num=" + num + ", date=" + date + ", rates=" + rates + "]";
	}
	
	

	/*public CurrencyDTO(String table, String num, String date, Rates rates) {
		this.table = table;
		this.num = num;
		this.date = date;
		this.rates = rates;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Rates getRates() {
		return rates;
	}

	public void setRates(Rates rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "CurrencyDTO [table=" + table + ", num=" + num + ", date=" + date + ", rates=" + rates + "]";
	}*/
	
}
