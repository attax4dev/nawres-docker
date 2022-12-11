package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.example.demo.service.UserService;
import com.example.demo.dao.IUserDao;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	IUserDao userDao;

	public User save(User user) {
		return userDao.saveAndFlush(user);
	}

	public User update(User user) {
		return userDao.save(user);
	}

	public User find(String username) {
		System.out.println("************ test DAO **************** ");
		
		if(null == userDao.findByUsername(username)) {
			System.out.println("************ user NULL **************** ");
		}
		System.out.println("************ test DAO success 1 **************** " + userDao.findByUsername(username).getNom());
		
		return userDao.findByUsername(username);
	}

	@Override
	public User find(Long id) {
		return null;
	}

	@Override
	public List<User> findAll() {
		return null;
	}


}
