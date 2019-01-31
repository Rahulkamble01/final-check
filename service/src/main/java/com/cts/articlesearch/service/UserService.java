package com.cts.articlesearch.service;

import java.util.List;

import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.articlesearch.bean.User;
import com.cts.articlesearch.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User allUsers(String email){
		return userRepository.findByEmail(email);
	}
	
	public void block(User user){
		
		userRepository.findByEmail(user.getStatus());
		user.setStatus("inactive");
		userRepository.save(user);
		
	}
	
}
