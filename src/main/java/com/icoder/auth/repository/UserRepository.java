package com.icoder.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icoder.auth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
