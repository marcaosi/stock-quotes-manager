package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.example.demo")
@EntityScan(basePackages = "com.example.demo.model")
public class StockQuoteManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockQuoteManagerApplication.class, args);
	}

}
