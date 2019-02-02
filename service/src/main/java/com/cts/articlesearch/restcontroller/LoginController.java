package com.cts.articlesearch.restcontroller;

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
	
	@Autowired
	private LoginService loginService;
	
	
	@PostMapping("/user")
	public ResponseEntity<AuthenticationStatus> login(@RequestBody User user){
		AuthenticationStatus status = loginService.authenticationStatus(user);
		return new ResponseEntity<AuthenticationStatus>(status, HttpStatus.OK);
	}
	
}
