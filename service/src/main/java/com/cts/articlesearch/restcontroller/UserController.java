package com.cts.articlesearch.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.articlesearch.bean.User;
import com.cts.articlesearch.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAnaylist/{email}")
	private User users(@PathVariable String email){
		return userService.allUsers(email);
	}
	
	@PostMapping("anaylist/blocked")
	private void blockedAnyalist(@RequestBody User user){
		userService.block(user);
	}
}
