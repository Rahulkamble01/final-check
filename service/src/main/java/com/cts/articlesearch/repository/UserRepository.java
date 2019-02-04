package com.cts.articlesearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.articlesearch.bean.Article;
import com.cts.articlesearch.bean.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByEmail (String email);
	
	//User findByUserEmail (List<Article> Article);
	
	List<User> findByName (String name);
	

}
