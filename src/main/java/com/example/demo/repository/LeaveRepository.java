package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Leave;

public interface LeaveRepository  extends JpaRepository<Leave, Long> {
	Leave findOneByLeaveId(Long leaveId);
}
