package com.cts.articlesearch.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.articlesearch.bean.Article;
import com.cts.articlesearch.bean.User;
import com.cts.articlesearch.repository.ArticleRepository;
import com.cts.articlesearch.repository.UserRepository;

@Service
public class ArticleService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public void saveArticle(Article article){
		LOGGER.info("start the article service");
		LOGGER.debug("article in service : {}", article);
		Article save = articleRepository.save(article);
		LOGGER.debug("save in article : {}", save);
		User user = userRepository.findByEmail(article.getEmail());
		LOGGER.debug("user value in article : {}", user);
		user.getArticle().add(save);
		userRepository.save(user);
		LOGGER.info("end the article service");
	}
}
