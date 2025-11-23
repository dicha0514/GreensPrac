package com.example.leave.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.leave.model.AbsentMgmt;
import com.example.leave.repository.AbsentMgmtRepository;

@Service
public class AbsentMgmtService {
	
	@Autowired
	private AbsentMgmtRepository absentMgmtRepository;
	
	public List<AbsentMgmt> getAbsentDetails()
	{
		return absentMgmtRepository.findAll();
	}
	
	public AbsentMgmt getLeaveById(int userId)
	{

		return absentMgmtRepository.findById(userId).orElseThrow(() -> new RuntimeException("Invalid Userid " + userId));
	}
	
	public AbsentMgmt applyLeave(AbsentMgmt leaveRequest)
	{
		leaveRequest.setStatus(AbsentMgmt.status.PENDING);
		
		if(leaveRequest.getEndDate().toLocalDate() .isBefore(leaveRequest.getStartDate().toLocalDate()))
		{
			throw new RuntimeException("Enddate must be after the start date");
		}
		return absentMgmtRepository.save(leaveRequest);	
	}
	
	public AbsentMgmt updateLeaveById(int userId, AbsentMgmt.status statusUpdate)
	{
		AbsentMgmt member = absentMgmtRepository.findById(userId).orElseThrow(() -> new RuntimeException("Invalid Userid " + userId));
		
		member.setStatus(statusUpdate);
		
		return absentMgmtRepository.save(member);
		
	}
	
	public String purgeLeaveDetails(int userId)
	{
		AbsentMgmt member = absentMgmtRepository.findById(userId).orElseThrow(() -> new RuntimeException("Invalid Userid " + userId));
		
		LocalDate startDate = member.getStartDate().toLocalDate();
		
		if(startDate .isBefore(LocalDate.now() .minusDays(1)))
		{
			absentMgmtRepository.delete(member);
			return "Requested leave details purged " + userId;
		}
		
		return "Requested leave details not purged " + userId;
		
	}
	
	
}
