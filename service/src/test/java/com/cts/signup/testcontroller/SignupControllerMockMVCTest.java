package com.cts.signup.testcontroller;

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
public class SignupControllerMockMVCTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SignupControllerMockMVCTest.class);

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();


	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	/*@Test
	public void signup() throws Exception {
		LOGGER.info("START : Inside addUser() method of SignupController");

		String SIGNUP_DATA = "{\"name\":\"Rajesh Kumar\"," + "\"email\":\"rajesh01@gmail.com\","
				+ "\"password\":\"1234567\"," + "\"status\":\"active\"," + "\"language\":{\"id\":\"1\"},"
				+ "\"role\":{\"id\":2}}";
		
		LOGGER.debug("JSON Object :  {}", SIGNUP_DATA);

		mockMvc.perform(post("/signup/user/save").content(SIGNUP_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.signedUp").value("true"));
		
		LOGGER.info("START : Inside Spring Boot addUser() method of UserController");


	}*/
	
	@Test
	public void testSignupController() throws Exception {

		String SIGNUP_REQUEST = "{\"name\":\"Rajesh Kumar\"," + "\"email\":\"rajesh01@gmail.com\","
				+ "\"password\":\"1234567\"," + "\"status\":\"active\"," + "\"language\":{\"id\":\"1\"},"
				+ "\"role\":{\"id\":2}}";

		mockMvc.perform(post("/signup/user/save").content(SIGNUP_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.status").value("true"));

	}
	
	@Test
	public void incorrectEmailFormat() throws Exception {
		LOGGER.info("START : Inside Spring Boot incorrectEmailFormat() method of SignupControllerTest");

		String SIGNUP_REQUEST = "{\"name\":\"Rahul Kamble\"," + "\"email\":\"rahulkamblcom\"," + "\"password\":\"123456789\","
				+ "\"status\":\"active\"," + "\"language\":{\"id\":\"1\"}," + "\"role\":{\"id\":1}}";
		LOGGER.debug("SIGNUP_REQUEST data :  {}", SIGNUP_REQUEST);

		mockMvc.perform(post("/signup/user/save").content(SIGNUP_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Email address is invalid"));
		LOGGER.info("END the invalid emain check in SignupControllerTest");
	}
}
