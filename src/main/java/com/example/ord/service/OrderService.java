package com.example.ord.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ord.model.OrderDetails;
import com.example.ord.repository.OrderRepositoryInterface;
import com.example.ord.repository.UserRepositoryInterface;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepositoryInterface orderRepositoryInterface;
	
	@Autowired
	private UserRepositoryInterface userRepositoryInterface;
	
	public List<OrderDetails> getOrderDetails(int userId){
		
		if(!userRepositoryInterface.existsById(userId))
		{
			throw new RuntimeException("Invalid User ID: " + userId);
		}
		
		return orderRepositoryInterface.findAll();
		
	}
	
	public OrderDetails insertOrderDetails(OrderDetails orderdetails) {
		
		orderdetails.setCreatedTimestamp(LocalDateTime.now());
		orderdetails.setUpdatedTimestamp(LocalDateTime.now());
		
		if(!userRepositoryInterface.existsById(orderdetails.getUserId()))
		{
			throw new RuntimeException("Invalid User ID: " + orderdetails.getUserId());
		}
		
		return orderRepositoryInterface.save(orderdetails);
		
	}
	
	public OrderDetails updateOrderDetails(OrderDetails orderdetails) {
		
		if(!userRepositoryInterface.existsById(orderdetails.getUserId()))
		{
			throw new RuntimeException("Invalid User ID: " + orderdetails.getUserId());
		}
		
		Optional<OrderDetails> existingOrder = orderRepositoryInterface.findById(orderdetails.getOrderId());
		
		if(existingOrder.isPresent() && "Active".equalsIgnoreCase(existingOrder.get().getOrderStatus()))
		{
			OrderDetails existing = existingOrder.get();
			existing.setOrderStatus(orderdetails.getOrderStatus());
			existing.setPaymentStatus(orderdetails.getPaymentStatus());
			existing.setPaymentType(orderdetails.getPaymentType());
			existing.setUpdatedTimestamp(LocalDateTime.now());
			
			return orderRepositoryInterface.save(existing);		
		}
		else
		{
			throw new RuntimeException("Invalid order #" + orderdetails.getOrderId() + " or might not be an active order");
		}
		
		
	}
	
	
	public OrderDetails partialUpdateOrderDetails(OrderDetails orderdetails) {
		
		if(!userRepositoryInterface.existsById(orderdetails.getUserId()))
		{
			throw new RuntimeException("Invalid User ID: " + orderdetails.getUserId());
		}
		
		Optional<OrderDetails> existingOrder = orderRepositoryInterface.findById(orderdetails.getOrderId());
		
		if(existingOrder.isPresent() && "Active".equalsIgnoreCase(existingOrder.get().getOrderStatus()))
		{
			OrderDetails existing = existingOrder.get();
			
			if(orderdetails.getPaymentStatus() != null)
			{
				existing.setPaymentStatus(orderdetails.getPaymentStatus());
			}
			
			if(orderdetails.getPaymentType() != null)
			{
				existing.setPaymentType(orderdetails.getPaymentType());
			}
			
			if(orderdetails.getTotalAmount() != null)
			{
				existing.setTotalAmount(orderdetails.getTotalAmount());
			}
			
			existing.setUpdatedTimestamp(LocalDateTime.now());
			
			return orderRepositoryInterface.save(existing);		
		}
		else
		{
			throw new RuntimeException("Invalid order #" + orderdetails.getOrderId() + " or might not be an active order");
		}
			
	}
	
	
	public List<OrderDetails> deleteOrderDetails(OrderDetails orderdetails) {
		
		if(!userRepositoryInterface.existsById(orderdetails.getUserId()))
		{
			throw new RuntimeException("Invalid User ID: " + orderdetails.getUserId());
		}
		
		Optional<OrderDetails> existingOrder = orderRepositoryInterface.findById(orderdetails.getOrderId());
		
		if(existingOrder.isPresent())
		{
			OrderDetails existing = existingOrder.get();
			
			orderRepositoryInterface.delete(existing);	
			
			return orderRepositoryInterface.findAll();
		}
		else
		{
			throw new RuntimeException("Invalid order #" + orderdetails.getOrderId());
		}	
	}
	
	

}
