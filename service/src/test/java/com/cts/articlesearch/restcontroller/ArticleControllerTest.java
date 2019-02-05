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
	
	@Test
	public void saveArticleTest() throws Exception {
		LOGGER.info("Start: inside saveArticleTest");
		
		String ARTICLE_SAVE ="{\"source\":{\"id\":\"the-jerusalem-post\","
				+ "\"name\":\"The Jerusalem Post\"},"
				/*+ "\"author\":null,"*/
				+ "\"title\":\"Cradle of 'Arab Spring' in flux as massive protests rock Tunisia\","
				+ "\"description\":\"The IMF has urged the country to freeze public sector wages and reduce the government’s ballooning deficit\","
				/*+ "\"url\":\"https://www.jpost.com/Middle-East/Cradle-of-Arab-Spring-in-flux-as-massive-protests-rock-Tunisia-579711\","
				+ "\"urlToImage\":\"https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/422733\","
				+ "\"publishedAt\":\"2019-02-05T06:17:00Z\",\"content\":\"X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+5431 chars]\","*/
				+ "\"email\":\"kamb@gmail.com\"}";
		
		mockMvc.perform(post("/article/saveArticle").content(ARTICLE_SAVE).contentType("application/json;charset=UTF-8"))
		.andExpect(status().isOk());

LOGGER.info("END: saveArticleTest");

		
	}

}
