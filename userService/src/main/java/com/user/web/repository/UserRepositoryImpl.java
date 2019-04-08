package com.user.web.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.user.web.model.User;


public class UserRepositoryImpl implements UserRepository {

	private static List<User> userList = new ArrayList<>();
	
	static {
		User u1 = new User();
		u1.setId(new Long(100));
		u1.setUserName("admin");
		u1.setPassword("admin");
		u1.setFirstName("Avanesh");
		u1.setLastName("Sharma");
		u1.setDateOfbirth("10-March-2014");
		userList.add(u1);
		User u2 = new User();
		u2.setId(new Long(101));
		u2.setUserName("admin1");
		u2.setPassword("admin1");
		u2.setFirstName("Avanesh");
		u2.setLastName("Sharma");
		u2.setDateOfbirth("16-Feb-2000");
		userList.add(u2);
		User u3 = new User();
		u3.setId(new Long(102));
		u3.setUserName("admin2");
		u3.setPassword("admin2");
		u3.setFirstName("Avanesh");
		u3.setLastName("Sharma");
		u3.setDateOfbirth("06-Aug-2005");
		userList.add(u3);
		
	}
	
	

	@Override
	public List<User> findAllUsers() {

		return userList;
	}

	@Override
	public User findUserByName(String name) {		
		return userList.stream().filter(u -> u.getUserName().equals(name)).collect(Collectors.toList()).get(0);
	}

	@Override
	public User getUserById(Long userId) {		
		return userList.stream().filter(u -> u.getId() == userId).collect(Collectors.toList()).get(0);
	}

	@Override
	public boolean addUser(User user) {
		userList.add(user);
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		
		if(userList.removeIf(u -> u.getId()== user.getId())) {
			userList.add(user);
		}		
		return true;
	}

	@Override
	public boolean deleteUser(Long userId) {
		// TODO Auto-generated method stub
		return userList.removeIf(u -> u.getId()== userId);
	}
	
}
	
