package com.cts.articlesearch.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.articlesearch.AuthenticationStatus;
import com.cts.articlesearch.bean.User;
import com.cts.articlesearch.repository.UserRepository;
import com.cts.articlesearch.restcontroller.SignupController;

@Service
public class LoginService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(SignupController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public AuthenticationStatus authenticationStatus(User user){
		
		LOGGER.info("inside the LoginService");
		LOGGER.debug("user values in LoginService : {}", user);
		
		String actualUser = user.getEmail();  // front end user data
		LOGGER.debug("actualUser : {}", actualUser);
		
		User existingUser = userRepository.findByEmail(user.getEmail()); // backend user data
		LOGGER.debug("existingUser : {}", existingUser);
		
		String actualEmail = user.getEmail();
		LOGGER.debug("actualEmail : {}", actualEmail);		
		
		String actualPassword = user.getPassword();
		LOGGER.debug("actualPassword : {}", actualPassword);
		
		String existingPassword ="";
		
		AuthenticationStatus status = new AuthenticationStatus();
		status.setAuthenticate(false);
		status.setAdmin(false);
		
		if(existingUser != null){
			existingPassword = existingUser.getPassword();
			
			if("Admin".equals(existingUser.getRole().getRole()) && existingPassword.equals(actualPassword)){
				status.setAdmin(true);
				status.setUser(existingUser);
				status.setAuthenticate(true);
			} else {
				if("user".equals(existingUser.getRole().getRole()) && existingPassword.equals(actualPassword)){
				String existingEmail = existingUser.getEmail();
				LOGGER.debug("existingEmail in login service : {}", existingEmail);
				status.setUser(existingUser);
				status.setAuthenticate(true);
				status.setAdmin(false);
			}
		}
		}
		return status;
	}
}
