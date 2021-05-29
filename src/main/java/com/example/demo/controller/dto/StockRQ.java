package com.example.demo.controller.dto;

import java.util.List;

public class StockRQ {
	private String id;
	private List<QuoteRQ> quotes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<QuoteRQ> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<QuoteRQ> quotes) {
		this.quotes = quotes;
	}
}
