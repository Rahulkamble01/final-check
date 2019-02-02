package com.cts.articlesearch.restcontroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginControllerTest.class);

	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testLoginController() throws Exception {
		
		LOGGER.info("Start: inside LoginControllerTest");
		
		String LOGIN_REQUEST =  "{\"email\":\"rahulkamble130595@gmail.com\"" + " , " + "\"password\" : \"rahulkamble01@\"}";

		mockMvc.perform(post("/login/user").content(LOGIN_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authenticate").value(true));
		
		LOGGER.info("END: LoginControllerTest");

	}
	
	@Test
	public void testLoginControllerFailToLogin() throws Exception {
		
		LOGGER.info("Start: inside LoginControllerTest");
		
		String LOGIN_REQUEST =  "{\"email\":\"rahulkamble130@gmail.com\"" + " , " + "\"password\" : \"rahulkam@\"}";

		mockMvc.perform(post("/login/user").content(LOGIN_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authenticate").value(false));
		
		LOGGER.info("END: LoginControllerTest");

	}
	
	
	
	@Test
	public void emailNull() throws Exception {

		LOGGER.info("Start: inside LoginControllerTest emailNull() check");
		String LOGIN_REQUEST = "{\"password\" : \"rahulkamble01@\"}";
		mockMvc.perform(post("/login/user").content(LOGIN_REQUEST).contentType("application/json;charset=UTF-8"))
		.andExpect(status().isOk()).andExpect(jsonPath("$.authenticate").value(false));
		LOGGER.info("End: LoginControllerTest emailNull() check");;
	}
	
	@Test
	public void passwordNull() throws Exception {

		LOGGER.info("Start: inside LoginControllerTest passwordNull() check");
		String LOGIN_REQUEST = "{\"email\":\"rahulkamble130595@gmail.com\"}";
		mockMvc.perform(post("/login/user").content(LOGIN_REQUEST).contentType("application/json;charset=UTF-8"))
		.andExpect(status().isOk()).andExpect(jsonPath("$.authenticate").value(false));
		LOGGER.info("End: LoginControllerTest passwordNull() check");;
	}
	
	

}
