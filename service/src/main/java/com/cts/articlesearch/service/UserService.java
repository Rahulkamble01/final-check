package com.cts.articlesearch.service;

import java.util.List;

import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.articlesearch.bean.User;
import com.cts.articlesearch.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transient
	public List<User> allUsers(){
		List<User> users = userRepository.findAll();
		return users;
	}
	

}
