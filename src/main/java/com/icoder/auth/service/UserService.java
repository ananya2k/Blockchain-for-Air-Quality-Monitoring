package com.icoder.auth.service;

import com.icoder.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

	boolean isAdmin(String principal);
}
