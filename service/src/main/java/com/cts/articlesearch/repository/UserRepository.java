package com.cts.articlesearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.articlesearch.bean.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByEmail (String email);
	

}
