package com.example.demo.controller.dto;

import java.util.List;
import com.example.demo.model.Stock;

public class StockRS {
	private String id;
	private List<QuoteRS> quotes;
	
	public List<QuoteRS> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<QuoteRS> quotes) {
		this.quotes = quotes;
	}

	public static StockRS converter(Stock s) {
		var stock = new StockRS();
		stock.setId(s.getId());
		
		return stock;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
