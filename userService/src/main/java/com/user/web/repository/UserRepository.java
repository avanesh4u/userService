package com.user.web.repository;

import java.util.List;

import com.user.web.model.User;

public interface UserRepository {

	public	List<User> findAllUsers();		
	public User findUserByName(String name);
	public User getUserById(Long userId);
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(Long userId);
}
