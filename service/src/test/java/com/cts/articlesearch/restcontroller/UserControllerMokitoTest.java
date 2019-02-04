package com.cts.articlesearch.restcontroller;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.articlesearch.bean.BlockingStatus;
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
	
	public void blockUser(){
		LOGGER.info("START : Inside Unit Testing signUpNewUser");
		User user = new User();
		
		user.setEmail("rahulkamble@gmail.com");
		LOGGER.debug("User : {}", user);
		user.setStatus("inactive");
		Role role = new Role();
		role.setRole("user");
		user.setRole(role);
		
		User actualUser = new User();
		actualUser.setEmail("rahulkamble@gmail.com");
		actualUser.setStatus("active");
		
		Role role1 = new Role();
		role1.setRole("user");
		actualUser.setRole(role1);
		
		when(userRepository.findByEmail(user.getEmail())).thenReturn(actualUser);
		//BlockingStatus status = userService.block(user);
		
		
		
		
	}
	
}
