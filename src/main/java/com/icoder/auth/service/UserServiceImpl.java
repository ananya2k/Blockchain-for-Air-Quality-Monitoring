package com.icoder.auth.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.icoder.auth.model.Role;
import com.icoder.auth.model.User;
import com.icoder.auth.repository.RoleRepository;
import com.icoder.auth.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        Set<Role> roles=new HashSet<>();
        Role role=roleRepository.findAll().get(1);
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public List getUserRoles(String name){
    	User user=findByUsername(name);
    	List<String> userRoles=user.getRoles().stream().map(val->val.getName()).collect(Collectors.toList());
    	return userRoles;
    }  
    public boolean isAdmin(String name){
    	List<String> userRoles=getUserRoles(name);
    	
    	if(userRoles.contains("admin")){
    		return true;
    	}
		return false;
	}
    
}
