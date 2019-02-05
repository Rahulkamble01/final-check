package com.cts.articlesearch.restcontroller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.articlesearch.bean.Role;
import com.cts.articlesearch.bean.User;
import com.cts.articlesearch.repository.UserRepository;
import com.cts.articlesearch.service.UserService;

public class UserControllerMokitoTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SignupControllerMokitoTest.class);
	
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserService userService;
	
	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void blockUser(){
		LOGGER.info("START : Inside Unit Testing signUpNewUser");
		User user = new User();
		
		user.setEmail("rahulkamble@gmail.com");
		LOGGER.debug("User : {}", user);
		user.setStatus("active");
		Role role = new Role();
		role.setRole("user");
		user.setRole(role);
		
		
		//when(userRepository.findByEmail(user.getEmail())).thenReturn(actualUser);
		//BlockingStatus status = userService.block(user);
		userService.block(user);
	//	verify(userRepository, times(1)).findByEmail(user.getEmail());
		verify(userRepository, times(1)).save(user);
		
		
		
	}
	
}
