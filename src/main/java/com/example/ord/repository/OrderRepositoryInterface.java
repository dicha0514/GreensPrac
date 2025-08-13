package com.example.ord.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ord.model.OrderDetails;

public interface OrderRepositoryInterface extends JpaRepository<OrderDetails, Integer> {
	
	

}
