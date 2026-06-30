package com.smartSpend.service;

import com.smartSpend.entity.User;

public interface UserService {
	void registerUser(User user);
	User findByMail(String mail);
}
