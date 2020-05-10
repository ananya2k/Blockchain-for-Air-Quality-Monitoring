package com.icoder.auth.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icoder.auth.model.AirData;
import com.icoder.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	List<Role> findAll();
}
