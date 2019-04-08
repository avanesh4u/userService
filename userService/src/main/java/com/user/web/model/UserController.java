package com.user.web.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.web.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/all",produces = "application/json")
	public List<User> fetchUsers(){		
		return userService.getAllUsers();
	}
	
	@GetMapping(path = "/{userName}", produces = "application/json")
	public User findByUserName (@PathVariable String userName) {		
		return userService.getUserByName(userName);
		
	}
	
	@PostMapping(path = "/add", produces = "application/json")
	public User saveUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@PutMapping(path = "/update", produces = "application/json")
	public User updateUser(@RequestBody User user) {
		
		return userService.updateUser(user);
	}
	

	@DeleteMapping(path = "/delete/{userId}", produces = "application/json")
	public void deleteUser(@PathVariable String userId) {
		userService.deleteUser(Long.valueOf(userId));
		
	}

}
