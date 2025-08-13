package com.example.ord.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ord.model.UserDetails;

public interface UserRepositoryInterface extends JpaRepository<UserDetails,Integer>{

}
