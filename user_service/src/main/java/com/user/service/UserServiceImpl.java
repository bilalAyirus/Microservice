package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.User;

@Service
public class UserServiceImpl implements UserService{

	
	List<User> list = List.of( 
			new User(1311L,"Bilal Suriya","1234567892"),
			new User(1312L,"Faiz Suriya","1234567890"),
			new User(1314L,"Asif Suriya","1234567891")
			);
	
	
	@Override
	public User getUser(Long id) {
		return this.list.stream().filter(user->user.getUserId().equals(id)).findAny().orElse(null);
	}
	
}
