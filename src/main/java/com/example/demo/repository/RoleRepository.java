package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Role;
import com.example.demo.model.enums.ERoles;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {

	Optional<Role> findByName(String name);
}
