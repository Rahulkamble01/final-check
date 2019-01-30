package com.cts.articlesearch.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.articlesearch.bean.Language;
import com.cts.articlesearch.bean.Role;
import com.cts.articlesearch.bean.SignupStatus;
import com.cts.articlesearch.bean.User;
import com.cts.articlesearch.repository.LangauageRepository;
import com.cts.articlesearch.repository.UserRepository;
import com.cts.articlesearch.restcontroller.SignupController;

@Service
public class SignupService {
	private final static Logger LOGGER = LoggerFactory.getLogger(SignupController.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LangauageRepository langauageRepository;
	
	@Transactional
	public SignupStatus save(User user){
		LOGGER.info("inside the signup Service");
		LOGGER.info("user values in signup : {}", user);
		String actualUser = user.getEmail();
		LOGGER.debug("actualuser values in signup : {}", actualUser);
		User existingUser = userRepository.findByEmail(user.getEmail());
		LOGGER.debug("exisingUser values in signup : {}", existingUser);
		SignupStatus status = new SignupStatus();
		if(existingUser != null){
			status.setStauts(false);
			status.setMessage("User is already exist...!");
		} else {
			Role role = new Role();
			role.setId(2);
			user.setRole(role);
			status.setStauts(true);
			userRepository.save(user);
			status.setMessage("Please Login to Continue...");	
		}
		return status;
	}
	
	@Transactional
	public List<Language> language(){
		LOGGER.info("inside the list of language in signup Service");
		List<Language> languages = langauageRepository.findAll();
		LOGGER.debug("language in signup Service : {}", languages);
		LOGGER.info("end the list of language in signup Service");
		return languages;
	}
}
