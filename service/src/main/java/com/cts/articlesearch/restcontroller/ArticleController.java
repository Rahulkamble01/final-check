package com.cts.articlesearch.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.articlesearch.bean.Article;
import com.cts.articlesearch.service.ArticleService;

@RestController
@RequestMapping("/rest/article")
public class ArticleController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	private ArticleService articleService;
	
	@PostMapping("/saveArticle")
	public Article save(@RequestBody Article article){
		LOGGER.info("start the article controller");
		LOGGER.debug("article : {}", article);
		LOGGER.info("end the article controller");
		return articleService.saveArticle(article);
		
	}

}
