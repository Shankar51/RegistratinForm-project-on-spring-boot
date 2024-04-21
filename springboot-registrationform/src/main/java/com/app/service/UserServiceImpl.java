package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.User;
import com.app.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepo repo;
	
	@Autowired
	public UserServiceImpl(UserRepo repo) {
		this.repo = repo;
	}
    @Override
    public void registerUser(User user) {
    	repo.save(user);

    }
    
	/*
	 * @Override public List<User> getAllUser() { Iterable<User> allUser =
	 * repo.findAll(); List<User> listOfPatient = new ArrayList<User>();
	 * allUser.forEach(listOfPatient::add);
	 * 
	 * return listOfPatient; }
	 * 
	 * @Override public void createUser(User user) { repo.save(user); }
	 */



}
