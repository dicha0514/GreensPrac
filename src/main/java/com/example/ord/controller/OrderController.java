package com.example.ord.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ord.model.OrderDetails;
import com.example.ord.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/get/{userId}")
	public List<OrderDetails> getOrder(@PathVariable int userId)
	{
		return orderService.getOrderDetails(userId);
	}
	
	@PostMapping("/post")
	public OrderDetails postOrder(@RequestBody OrderDetails orderDetails)
	{
		return orderService.insertOrderDetails(orderDetails);
	}
	
	@PutMapping("/put")
	public OrderDetails updateOrder(@RequestBody OrderDetails orderDetails)
	{
		return orderService.updateOrderDetails(orderDetails);
	}
	
	@PatchMapping("/patch")
	public OrderDetails partialUpdateOrder(@RequestBody OrderDetails orderDetails)
	{
		return orderService.partialUpdateOrderDetails(orderDetails);
	}
	
	@DeleteMapping("/delete")
	public List<OrderDetails> deleteOrder(@RequestBody OrderDetails orderDetails)
	{
		return orderService.deleteOrderDetails(orderDetails);
	}
}
