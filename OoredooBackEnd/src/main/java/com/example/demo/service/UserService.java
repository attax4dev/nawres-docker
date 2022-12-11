package com.example.demo.service;


import com.example.demo.entities.User;

import java.util.List;

public interface UserService {

	public User save(User user);

	public User update(User user);

	public User find(String userName);

	public User find(Long id);
	
	public List<User> findAll();
		
}
