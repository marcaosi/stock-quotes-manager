package com.example.demo.controller.dto;

import java.util.Date;

import com.example.demo.model.Quote;

public class QuoteRS {
	private Long id;
	private double value;
	private Date date;
	private String stock_id;
	

	public String getStock_id() {
		return stock_id;
	}

	public void setStock_id(String stock_id) {
		this.stock_id = stock_id;
	}

	public static QuoteRS converter(Quote q) {
		var quote = new QuoteRS();
		quote.setId(q.getId());
		quote.setValue(q.getValue());
		quote.setDate(q.getDate());
		quote.setStock_id(q.getStock_id());
		
		return quote;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
