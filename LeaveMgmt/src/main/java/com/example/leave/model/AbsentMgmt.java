package com.example.leave.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Absent_Management")
public class AbsentMgmt {
	
	public enum status
	{
	PENDING,APPROVED,REJECTED	
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@NotNull(message = "Username cannot be null")
	private String username;
	
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String reason;
	@Enumerated(EnumType.STRING)
	private status leaveStatus;
	
	public AbsentMgmt() {}

	public AbsentMgmt(int id, String username, LocalDateTime startDate, LocalDateTime endDate, String reason,
			status leaveStatus) {
		super();
		this.id = id;
		this.username = username;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.leaveStatus = leaveStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public status getStatus() {
		return leaveStatus;
	}

	public void setStatus(status leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	
	
	
	
	
	
	

	

}
