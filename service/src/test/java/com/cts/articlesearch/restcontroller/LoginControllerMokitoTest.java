package com.cts.articlesearch.restcontroller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
	public void unsuccessfullyLoginForNullEmail() {
		LOGGER.info("Start");
		User user = new User();
		user.setPassword("123456");
		/*//when(loginService.authenticationStatus(user.getEmail())).thenReturn(null);
		AuthenticationStatus status = loginController.login(user).getBody();
		LOGGER.debug("status{}", status);
		assertEquals(true, status.isAuthenticate() == false);
		*/LOGGER.info("End");

	}

//	@Test
//	public void unsuccessfullyLoginForNullPassword() {
//		LOGGER.info("Start");
//		User user = new User();
//		user.setEmail("user");
//		User actualUser = new User();
//		actualUser.setEmail("vishal");
//		actualUser.setPassword("password");
//		when(loginService.authenticationStatus(user.getEmail())).thenReturn(actualUser);
//		AuthenticationStatus status = loginController.login(user).getBody();
//		LOGGER.debug("status{}", status);
//		;
//		assertEquals(true, status.isAuthenticate() == false);
//		LOGGER.info("End");
//
//	}


}
