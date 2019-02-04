package com.cts.articlesearch.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.articlesearch.bean.User;
import com.cts.articlesearch.repository.UserRepository;

@Service
public class UserService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User allUsers(String email){
		LOGGER.info("inside the user service");
		LOGGER.debug("User values : {}", email);
		LOGGER.info("inside the user service");
		return userRepository.findByEmail(email);
	}
	
	@Transactional
	public List<User> allUser(String name){
		LOGGER.info("inside the user service");
		LOGGER.debug("User name : {}", name);
		LOGGER.info("inside the user service");
		return userRepository.findByName(name);
	}
	
	public void block(User user){
		LOGGER.info("inside the user service");
		LOGGER.debug("User values : {}", user);			
		userRepository.findByEmail(user.getStatus());
		user.setStatus("inactive");
		userRepository.save(user);
		LOGGER.info("inside the user service");	
		
	}
	
	/*public void delete(User user){
		LOGGER.info("inside the delete in user service");
		LOGGER.debug("user value : {}", user);
		User article = userRepository.findByUserEmail(user.getArticle());
		LOGGER.debug("articel in user service : {}", article);
		
		
	}*/
	
}
