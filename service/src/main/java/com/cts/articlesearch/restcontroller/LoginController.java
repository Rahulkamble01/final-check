package com.cts.articlesearch.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.articlesearch.AuthenticationStatus;
import com.cts.articlesearch.bean.User;
import com.cts.articlesearch.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController extends ArticleSearchExceptionController{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	
	@PostMapping("/user")
	public AuthenticationStatus login(@RequestBody User user){
		LOGGER.info("inside the LoginController");
		AuthenticationStatus status = loginService.authenticationStatus(user);
		LOGGER.debug("status : {}", status);
		LOGGER.info("inside the LoginController");
		return status;
	}
	
}
