package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entities.Qualification;

public interface QualificationRepository extends JpaRepository<Qualification, Long>{

}
