package com.smartSpend.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartSpend.entity.User;
import com.smartSpend.enums.Role;
import com.smartSpend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(Role.USER);
		user.setActive(true);
		
		userRepo.save(user);
	}

	@Override
	public User findByMail(String mail) {
		User user = userRepo.findByEmail(mail).orElse(null);
		return user;
	}
	
}
