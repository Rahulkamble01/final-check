package com.cts.articlesearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.articlesearch.bean.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{
	
}
