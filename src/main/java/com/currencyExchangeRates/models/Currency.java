package com.currencyExchangeRates.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nbpweb")
public class Currency {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="code")
	private String code;
	
	@Column(name="curvalue")
	private double curvalues;
	
	//@Embedded
	//private Rates rates;
	
	public Currency() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return code;
	}

	public void setName(String name) {
		this.code = name;
	}

	public double getValues() {
		return curvalues;
	}

	public void setValues(double values) {
		this.curvalues = values;
	}

	public Currency(String name, double values) {
		this.code = name;
		this.curvalues = values;
	}

	@Override
	public String toString() {
		return "Currency [id=" + id + ", name=" + code + ", values=" + curvalues + "]";
	}

}
