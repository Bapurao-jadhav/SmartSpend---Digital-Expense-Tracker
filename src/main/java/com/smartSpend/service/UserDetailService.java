package com.smartSpend.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.smartSpend.entity.User;

public interface UserDetailService {
	UserDetails loadUserByUsernameDetails(String email);
}
