package com.cts.articlesearch.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.articlesearch.bean.User;
import com.cts.articlesearch.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUsers")
	private List<User> users(){
		List<User> users = userService.allUsers();
		return users;
	} 
}
