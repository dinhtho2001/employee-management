package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.SalaryBonus;

public interface SalaryBonusRepository extends JpaRepository<SalaryBonus, Long>{
	//SalaryBonus findOneBySalaryId (Long salaryId);
}
