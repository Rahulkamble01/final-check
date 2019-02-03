package com.cts.articlesearch.restcontroller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.articlesearch.AuthenticationStatus;
import com.cts.articlesearch.bean.Role;
import com.cts.articlesearch.bean.User;
import com.cts.articlesearch.repository.UserRepository;
import com.cts.articlesearch.service.LoginService;

public class LoginControllerMokitoTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginControllerMokitoTest.class);

	// private UserRepository userRepository;

	@Mock
	private UserRepository userRepository;
	@InjectMocks
	private LoginService loginService;

	@Before
	public void setUp() throws Exception {
		// Create a user object which is to be tested
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void successfullyLogin() {
		LOGGER.info("Start");
		User user = new User();
		user.setEmail("user");
		user.setPassword("123456");
		Role role = new Role();
		role.setRole("user");
		user.setRole(role);
		when(userRepository.findByEmail(user.getEmail())).thenReturn(user);
		AuthenticationStatus status = loginService.authenticationStatus(user);;
		LOGGER.debug("status{}", status);
		assertEquals(true, status.isAuthenticate());
		LOGGER.info("End");

	}

	@Test
	public void testInvalidEmailLogin() {
		LOGGER.info("Start");
		User user = new User();
		user.setPassword("rahulkamble01");
		user.setEmail("Rahul@gmail.com");
		Role role = new Role();
		role.setRole("Admin");
		user.setRole(role);
		
		LOGGER.debug("user for null email check : {} ", user);
		
		AuthenticationStatus status = new AuthenticationStatus();
		status.setAuthenticate(false);
		status.setUser(null);
		
		User actualUser = null;
		//actualUser.setEmail("Rahul1@gmail.com");
		//actualUser.setPassword("rahulkamble01");
		//actualUser.setRole(role);
		
		
		when(userRepository.findByEmail(user.getEmail())).thenReturn(actualUser);
		AuthenticationStatus actualStatus = loginService.authenticationStatus(user);
		
		LOGGER.debug("Expected  Output :  {}", status);
		LOGGER.debug("Actual  Output :  {}", actualStatus);
		
		Assert.assertEquals(true, status.equals(actualStatus));
		
		verify(userRepository, times(1)).findByEmail(user.getEmail());
		LOGGER.info("End");

	}

	
	@Test
	public void testForInvalidPassword(){
		LOGGER.info("start : test login when password is Invalid");
		User user = new User();
		user.setEmail("Rahulkamble@gmail.com");
		user.setPassword("rahul01");
		
		Role role = new Role();
		role.setRole("user");
		user.setRole(role);
		
		AuthenticationStatus status = new AuthenticationStatus();
		status.setAuthenticate(false);
		status.setUser(null);
		
		User actualUser =null;
		
		when(userRepository.findByEmail(user.getEmail())).thenReturn(actualUser);
		AuthenticationStatus actualStatus = loginService.authenticationStatus(user);
		
		LOGGER.debug("status  :  {}", status);
		LOGGER.debug("Actual   {}", actualStatus); 
		Assert.assertEquals(true, status.equals(actualStatus));
		verify(userRepository, times(1)).findByEmail(user.getEmail());
		
		
}


}
