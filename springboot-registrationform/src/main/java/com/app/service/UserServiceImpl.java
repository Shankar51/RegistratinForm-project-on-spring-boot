package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.repo.UserRepo;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo repo;
	
	@Override
	public void registerUser(User user) {
		
		repo.save(user);
	}

}
