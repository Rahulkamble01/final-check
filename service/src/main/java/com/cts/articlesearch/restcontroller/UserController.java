package com.cts.articlesearch.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAnaylist/{email}")
	private User users(@PathVariable String email){
		LOGGER.info("inside the UserController");
		LOGGER.debug("User values : {}", email);
		LOGGER.info("inside the UserController");
		return userService.allUsers(email);
	}
	
	
	@GetMapping("/getUsers/{name}")
	private List<User> user(@PathVariable String name){
		LOGGER.info("inside the UserController");
		LOGGER.debug("User values : {}", name);
		LOGGER.info("inside the UserController");
		return userService.allUser(name);
	}
	
	@PostMapping("/anaylist/blocked")
	private void blockedAnyalist(@RequestBody User user){
		LOGGER.info("inside the UserController");
		LOGGER.debug("User values : {}", user);
		LOGGER.info("inside the UserController");
		userService.block(user);
	}
	
	
}
