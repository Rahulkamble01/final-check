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
public class SignupControllerTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SignupControllerTest.class);
	
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
	public void testSignupController() throws Exception {
		
		LOGGER.info("Start: inside testSignupController");
	
		
		String SIGNUP_REQUEST =  "{\"name\":\"Rahul Vishnu Kamble\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
                + "\"role\":{\"id\":\"2\"}" + "," + "\"email\":\"rahukamble1112@gmail.com\"" + "," + "\"password\":\"123456789\"}";


		mockMvc.perform(post("/signup/user/save").content(SIGNUP_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk());
		LOGGER.info("END: testSignupController");

	}
	
	@Test
	public void testSignupforNullEmail() throws Exception {
		
		LOGGER.info("Start: inside testSignupforNullEmail");
	
		
		String SIGNUP_REQUEST =  "{\"name\":\"RahulKamble\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
                + "\"role\":{\"id\":\"2\"}" + ","  + "\"password\":\"123456789\"}";

		mockMvc.perform(post("/signup/user/save").content(SIGNUP_REQUEST).contentType("application/json;charset=UTF-8"))
		.andExpect(status().is4xxClientError())
		.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed: Email cannot be empty"));
		LOGGER.info("END: testSignupforNullEmail");

	}
	
	
	@Test
	public void testSignupforNullPassword() throws Exception {
		
		LOGGER.info("Start: inside testSignupforNullPassword");
	
		
		String SIGNUP_REQUEST =  "{\"name\":\"Ramraj\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
                + "\"role\":{\"id\":\"2\"}" + "," + "\"email\":\"ramraj@gmail.com\"}";


		mockMvc.perform(post("/signup/user/save").content(SIGNUP_REQUEST).contentType("application/json;charset=UTF-8"))
		.andExpect(status().is4xxClientError())
		.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed: Password cannot be empty"));
		LOGGER.info("END: testSignupforNullPassword");
	}
	
	@Test
	public void testSignupforNullName() throws Exception {
		
		LOGGER.info("Start: inside testSignupforNullName");
	
		String SIGNUP_REQUEST =  "{\"language\":{\"id\":\"1\"}" + ","
                + "\"role\":{\"id\":\"2\"}" + "," + "\"email\":\"9999@gmail.com\"" + "," + "\"password\":\"123456789\"}";

		mockMvc.perform(post("/signup/user/save").content(SIGNUP_REQUEST).contentType("application/json;charset=UTF-8"))
		.andExpect(status().is4xxClientError())
		.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed: User Name cannot be empty"));
		LOGGER.info("END: testSignupforNullName");

	}
	
	
	@Test
	public void testSignupforNullObject() throws Exception {
		
		LOGGER.info("Start: inside testSignupforNullObject");
	
		String SIGNUP_REQUEST =  "{}";

		mockMvc.perform(post("/signup/user/save").content(SIGNUP_REQUEST).contentType("application/json;charset=UTF-8"))
		.andExpect(status().is4xxClientError()).andExpect(jsonPath("$.errorMessage").isNotEmpty());
		LOGGER.info("END: testSignupforNullObject");

	}
	
	@Test
	public void testSignupControllerForPreExistingEmailId() throws Exception {
		LOGGER.info("Start: inside testUserControllerForPreExistingEmailId()");
		String SIGNUP_REQUEST = "{\"name\":\"RahulKamble\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
                + "\"role\":{\"id\":\"2\"}" + "," + "\"email\":\"rahukamble@gmail.com\"" + "," + "\"password\":\"123456789\"}";
		mockMvc.perform(post("/signup/user/save").content(SIGNUP_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.message").value("User is already exist...!"));
		LOGGER.info("End: testSignupControllerForPreExistingEmailId()");
	}

	@Test
	public void testSignupControllerForInvalidPatternOfEmailId() throws Exception {
		LOGGER.info("Start: inside testUserControllerForPreExistingEmailId()");
		String SIGNUP_REQUEST = "{\"name\":\"RahulKamble\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
		
                + "\"role\":{\"id\":\"2\"}" + "," + "\"email\":\"rahukamble.com\"" + "," + "\"password\":\"123456789\"}";
		mockMvc.perform(post("/signup/user/save").content(SIGNUP_REQUEST).contentType("application/json;charset=UTF-8"))
		.andExpect(status().is4xxClientError())
		.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed: Email address is invalid"));
		LOGGER.info("End: testSignupControllerForInvalidPatternOfEmailId()");
	}
	
	@Test
	public void testSignupControllerInvalidPasswordFormat() throws Exception {
		LOGGER.info("Start: inside testSignupControllerInvalidPasswordFormat()");
		String SIGNUP_REQUEST = "{\"name\":\"RahulKamble\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
		
                + "\"role\":{\"id\":\"2\"}" + "," + "\"email\":\"rahukamble12@gmail.com\"" + "," + "\"password\":\"123\"}";
		mockMvc.perform(post("/signup/user/save").content(SIGNUP_REQUEST).contentType("application/json;charset=UTF-8"))
		.andExpect(status().is4xxClientError())
		.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed: Password must be 6 to 50 characters"));
		LOGGER.info("End: testSignupControllerInvalidPasswordFormat()");
	}
	
	@Test
	public void testSignupControllerInvalidNameFormat() throws Exception {
		LOGGER.info("Start: inside testSignupControllerInvalidNameFormat()");
		String SIGNUP_REQUEST = "{\"name\":\"RahulRahulRahulRahulRahulRahul"
				+ "RahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulR"
				+ "ahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRah"
				+ "ulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahulRahul\"" + "," + "\"language\":{\"id\":\"1\"}" + ","		
                + "\"role\":{\"id\":\"2\"}" + "," + "\"email\":\"rahukamb12@gmail.com\"" + "," + "\"password\":\"12345678\"}";
		mockMvc.perform(post("/signup/user/save").content(SIGNUP_REQUEST).contentType("application/json;charset=UTF-8"))
		.andExpect(status().is4xxClientError())
		.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed: Name must not exceed 70 characters"));
		LOGGER.info("End: testSignupControllerInvalidNameFormat()");
	}
	
	@Test
	public void testSignupControllerInvalidEmailIdSize() throws Exception {
		LOGGER.info("Start: inside testSignupControllerInvalidPasswordFormat()");
		String SIGNUP_REQUEST = "{\"name\":\"RahulKamble\"" + "," + "\"language\":{\"id\":\"1\"}" + ","		
                + "\"role\":{\"id\":\"2\"}" + "," + "\"email\":\"rahukambRahulKambleRahulKambleRahul"
                		+ "KambleRahulKambleRahulKambleRahulKambleRahulKambleRahulKambleRahulKambleRahul"
                		+ "KambleRahulKambleRahulKambleRahulKambleRahulKambleRahulKambleRahulKambleRahul"
                		+ "KambleRahulKambleRahulKambleRahulKambleRahulKambleRahulKambleRahulKambleRahul"
                		+ "KambleRahulKambleRahulKambleRahulKambleRahulKambleRahulKambleRahulKambleRahul"
                		+ "KambleRahulKambleRahulKambleRahulKambleRahulKambleRahulKambleRahulKambleRahul"
                		+ "KambleRahulKambleRahulKambleRahulKambleRahulKambleRahulKambleRahulKambleRahul"
                		+ "KambleRahulKambleRahulKambleRahulKambleRahulKamblele12@gmail.com\"" + ","
                		+ "\"password\":\"12312345\"}";
		mockMvc.perform(post("/signup/user/save").content(SIGNUP_REQUEST).contentType("application/json;charset=UTF-8"))
		.andExpect(status().is4xxClientError())
		.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed: Email must not exceed 255 characters"));
		LOGGER.info("End: testSignupControllerInvalidPasswordFormat()");
	}
	
	
	
	
	

}
