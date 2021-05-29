package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Quote;

public interface QuoteRepository extends JpaRepository<Quote, String> {
	
	@Query("select quote0_.id as id1_0_, quote0_.date as date2_0_, quote0_.stock_id as stock_id3_0_, quote0_.value as value4_0_ from Quote quote0_ where quote0_.stock_id = ?1")
	List<Quote> findByStockId(String stock_id);
}
