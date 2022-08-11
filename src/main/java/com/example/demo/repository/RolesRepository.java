package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Role;

public interface RolesRepository extends JpaRepository<Role, Long>{

}
