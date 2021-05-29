package com.example.demo.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dto.QuoteRQ;
import com.example.demo.controller.dto.QuoteRS;
import com.example.demo.controller.dto.StockRQ;
import com.example.demo.controller.dto.StockRS;
import com.example.demo.model.Quote;
import com.example.demo.model.Stock;
import com.example.demo.repository.QuoteRepository;
import com.example.demo.repository.StockRepository;

@RestController
@RequestMapping(value = "/stock")
public class StockController {
	
	private final StockRepository stockRepository;
	private final QuoteRepository quoteRepository;
	
	public StockController(StockRepository stockRepository, QuoteRepository quoteRepository) {
		this.stockRepository = stockRepository;
		this.quoteRepository = quoteRepository;
	}
	
	
	@GetMapping("/")
	public List<StockRS> findAll(){
		var stocks = stockRepository.findAll();
		var quotes = quoteRepository.findAll();
		
		var allStocks = stocks.stream().map(StockRS::converter).collect(Collectors.toList());
		var allQuotes = quotes.stream().map(QuoteRS::converter).collect(Collectors.toList());
		
		for (StockRS s : allStocks) {
			var findedQuotes = allQuotes.stream().filter(q -> q.getStock_id().equals(s.getId())).collect(Collectors.toList());
			
			s.setQuotes(findedQuotes);
		}
		
		return allStocks;
	}
	
	@GetMapping("/{id}")
	public StockRS findById(@PathVariable("id") String id){
		var stock = stockRepository.getOne(id);
		var quotes = quoteRepository.findAll();
		
		var s = StockRS.converter(stock);
		var allQuotes = quotes.stream().map(QuoteRS::converter).collect(Collectors.toList());
		var findedQuotes = allQuotes.stream().filter(q -> q.getStock_id().equals(s.getId())).collect(Collectors.toList());
		
		s.setQuotes(findedQuotes);
		
		return s;
	}
	
	@PostMapping("/")
	public void save(@RequestBody StockRQ stock) {
		var s = new Stock();
		
		s.setId(stock.getId());
		stockRepository.save(s);
		
		for (QuoteRQ quoteRQ : stock.getQuotes()) {
			quoteRQ.setStock_id(s.getId());
			var q = new Quote();
			q.setDate(quoteRQ.getDate());
			q.setStock_id(quoteRQ.getStock_id());
			q.setValue(quoteRQ.getValue());
			quoteRepository.save(q);
		}
	}
}
