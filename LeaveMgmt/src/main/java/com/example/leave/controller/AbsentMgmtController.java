package com.example.leave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.leave.model.AbsentMgmt;
import com.example.leave.model.AbsentMgmt.status;
import com.example.leave.service.AbsentMgmtService;

@RestController
@RequestMapping("/api")
public class AbsentMgmtController {
	
	@Autowired
	private AbsentMgmtService absentMgmtService;
	
	@GetMapping("/get")
	public List<AbsentMgmt> getAbsentHistory()
	{
		return absentMgmtService.getAbsentDetails();
	}
	
	@GetMapping("/get/{userId}")
	public AbsentMgmt getUserAbsentDetails(@PathVariable("userId") int userId)
	{
		return absentMgmtService.getLeaveById(userId);
	}
	
	@PostMapping("/post/apply")
	public AbsentMgmt postLeave(@RequestBody AbsentMgmt leaveRequest)
	{
		return absentMgmtService.applyLeave(leaveRequest);
	}
	
	@PutMapping("/put/{userId}/{statusUpdate}")
	public AbsentMgmt putLeaveUpdate(@PathVariable("userId") int userId, @PathVariable("statusUpdate") status statusUpdate)
	{
		return absentMgmtService.updateLeaveById(userId, statusUpdate);
	}
	
	@DeleteMapping("/delete/{userId}")
	public String deleteUserAbsentDetails(@PathVariable("userId") int userId)
	{
		return absentMgmtService.purgeLeaveDetails(userId);
	}

}
