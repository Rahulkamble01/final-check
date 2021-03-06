package com.cts.articlesearch.restcontroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
public class UserControllerTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerTest.class);
	
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
	public void testUserControllerUserBlock() throws Exception {
		
		LOGGER.info("Start: inside testUserControllerUserBlock");
	
		
		String USER_REQUEST =  "{\"id\": \"3\" "+","+"\"name\":\"RahulKamble\"" + "," + "\"email\":\"rahulkamble@gmail.com\","
				+ "\"password\": \"rahulkamble01@\","
				+ "\"status\": \"inactive\","
				+ "\"role\": "
				+ "{"
				+ " \"id\": 2,"
				+ " \"role\": \"user\""
				+ "}}";


		mockMvc.perform(post("/anaylist/blocked").content(USER_REQUEST).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk());
		LOGGER.info("END: testUserControllerUserBlock");

	}

}
