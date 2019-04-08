package com.user.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.user.web.model.User;

@Service
public class UserServiceImpl implements UserService {
	
private static Map<Long, User> userMap = new HashMap<Long, User>();
	
	static {
		User u1 = new User();
			u1.setId(new Long(100));
			u1.setUserName("admin");
			u1.setPassword("admin");
			u1.setFirstName("Avanesh");
			u1.setLastName("Sharma");
			u1.setDateOfbirth("10-March-2014");
		//userList.add(u1);
		userMap.put(u1.getId(), u1);
		
		User u2 = new User();
			u2.setId(new Long(101));
			u2.setUserName("user");
			u2.setPassword("user");
			u2.setFirstName("First name");
			u2.setLastName("last Name");
			u2.setDateOfbirth("16-Feb-2000");		;
		userMap.put(u2.getId(), u2);
		
		User u3 = new User();
			u3.setId(new Long(102));
			u3.setUserName("dummy");
			u3.setPassword("dummy");
			u3.setFirstName("First name dummy");
			u3.setLastName("last name dummy");
			u3.setDateOfbirth("06-Aug-2005");
		userMap.put(u3.getId(), u3);
		
	}
	
	@Override
	public List<User> getAllUsers() {
		
		return userMap.entrySet().stream().map(Map.Entry :: getValue).collect(Collectors.toList());
	}

	@Override
	public User getUserByName(String userName) {	
		List<User> userList = userMap.entrySet().stream().map(Map.Entry :: getValue).collect(Collectors.toList());		
		return userList.stream().filter(u -> u.getUserName().equals(userName)).collect(Collectors.toList()).get(0);
	}

	@Override
	public User getUserById(Long userId) {			
		return  userMap.get(userId);
	}

	@Override
	public User addUser(User user) {
		userMap.put(user.getId(), user);
		return user;
	}

	@Override
	public User updateUser(User user) {		
		userMap.put(user.getId(), user);	
		return user;
	}

	@Override
	public User deleteUser(Long userId) {		
		return  userMap.remove(userId);
	}


}
