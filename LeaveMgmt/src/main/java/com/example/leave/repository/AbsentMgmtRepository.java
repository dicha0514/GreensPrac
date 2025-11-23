package com.example.leave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.leave.model.AbsentMgmt;

public interface AbsentMgmtRepository extends JpaRepository<AbsentMgmt, Integer>
{

}
