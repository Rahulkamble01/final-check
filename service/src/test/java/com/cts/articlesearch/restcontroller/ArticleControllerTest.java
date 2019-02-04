package com.cts.articlesearch.restcontroller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
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
public class ArticleControllerTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleControllerTest.class);
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	private void saveArticleTest() throws Exception {
		LOGGER.info("Start: inside LoginControllerTest");
		
		String ARTICLE_SAVE ="{\"title\": \"The battle for Venezuela’s future\"," 
		+ "\"description\": \"The world’s democracies are right to seek change in Latin America’s worst-governed country\","
        + "\"content\": \"IF PROTESTS ALONE could oust a president, Nicolás Maduro would already be on a plane to Cuba. On January 23rd at least 1m Venezuelans from across the country took to the streets demanding Mr Maduro step down. They were answering the call of Juan Guaidó, who l… [+6496 chars]\","
        + "\"author\": \"The Economist\","
        \"url\": \"http://www.economist.com/leaders/2019/02/02/the-battle-for-venezuelas-future\",
        \"urlToImage\": \"https://cdn.static-economist.com/sites/default/files/images/print-edition/20190202_LDD001_0.jpg\",
        \"publishedAt\": \"2019-02-02T00:00:00Z\",
        \"email\": null"}" ;
		
		mockMvc.perform(post("/login/user").content(ARTICLE_SAVE).contentType("application/json;charset=UTF-8"))
		.andExpect(status().isOk());

LOGGER.info("END: LoginControllerTest");

		
	}

}
