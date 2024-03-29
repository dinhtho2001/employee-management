package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.JobDepartment;

public interface JobDepartmentRepository  extends JpaRepository<JobDepartment, Long> {
	JobDepartment findOneByJobId(Long jobId);
}
