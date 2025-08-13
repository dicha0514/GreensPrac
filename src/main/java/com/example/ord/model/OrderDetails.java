package com.example.ord.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Order_Details")
public class OrderDetails {
	
	public enum PaymentStatus {
		PENDING, PAID, FAILED, REFUNDED
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int orderId;
	private Double totalAmount;
	private String orderStatus;
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	private String paymentType;
	private int userId;
	private LocalDateTime createdTimestamp;
	private LocalDateTime updatedTimestamp;
	
	public OrderDetails() {}
	
	

	public OrderDetails(int orderId, double totalAmount, String orderStatus, PaymentStatus paymentStatus,
			String paymentType, int userId, LocalDateTime createdTimestamp, LocalDateTime updatedTimestamp) {
		super();
		this.orderId = orderId;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.paymentStatus = paymentStatus;
		this.paymentType = paymentType;
		this.userId = userId;
		this.createdTimestamp = createdTimestamp;
		this.updatedTimestamp = updatedTimestamp;
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDateTime getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public LocalDateTime getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(LocalDateTime updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}
	
	
	
}
