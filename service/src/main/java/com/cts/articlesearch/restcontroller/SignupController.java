package com.cts.articlesearch.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.articlesearch.bean.Language;
import com.cts.articlesearch.bean.SignupStatus;
import com.cts.articlesearch.bean.User;
import com.cts.articlesearch.service.SignupService;

@RestController
@RequestMapping("/signup")
public class SignupController extends ArticleSearchExceptionController {
	private final static Logger LOGGER = LoggerFactory.getLogger(SignupController.class);

	@Autowired
	private SignupService signupService;
	
	@PostMapping("/user/save")
	public SignupStatus signup(@RequestBody User user){
		LOGGER.info("inside the SignUp Controller");
		LOGGER.debug("User values : {}", user);
		SignupStatus signup = signupService.save(user);
		LOGGER.info("End the SignUp Controller");
		return signup;
	}
	
	@GetMapping("/getlanguages")
	public List<Language> languages(){
		LOGGER.info("inside the list of language in signup controller");
		List<Language> language = signupService.language();
		LOGGER.debug(" list of language in signup controller : {}", language);
		LOGGER.info("end the list of language in signup controller");
		return language;
	}
}
