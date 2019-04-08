package com.user.web.service;

import java.util.List;

import com.user.web.model.User;

public interface UserService {

	public List<User> getAllUsers();
	public User getUserByName(String userName);
	public User getUserById(Long userId);
	public User addUser(User user);
	public User updateUser(User user);
	public User deleteUser(Long userId);
	
}
