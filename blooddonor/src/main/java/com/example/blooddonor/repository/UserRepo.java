package com.example.blooddonor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blooddonor.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}