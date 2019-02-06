package com.cts.articlesearch.restcontroller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.articlesearch.bean.Language;
import com.cts.articlesearch.bean.SignupStatus;
import com.cts.articlesearch.bean.User;
import com.cts.articlesearch.repository.UserRepository;
import com.cts.articlesearch.service.SignupService;

public class SignupControllerMokitoTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SignupControllerMokitoTest.class);
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	SignupService signupService;
	
	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void signUpNewUser() {
		LOGGER.info("START : Inside Unit Testing signUpNewUser");
		User user = new User();
		user.setEmail("rahulkamble12345@gmail.com");
		LOGGER.debug("User Object :  {}", user);
		when(userRepository.findByEmail(user.getEmail())).thenReturn(null);

		SignupStatus status = new SignupStatus(true, "Login to continue....");
		SignupStatus actualStatus = signupService.save(user);
		Assert.assertEquals(true, status.equals(actualStatus));
		LOGGER.debug("status in new signup  Output :  {}", status);
		LOGGER.debug("Actual  Output :  {}", actualStatus);

		verify(userRepository, times(1)).save(Mockito.any(User.class));
		verify(userRepository, times(1)).findByEmail(user.getEmail());

		LOGGER.info("End : Inside Unit Testing signUpNewUser");
	}
	
	@Test
	public void alreadyExistEmail() {
		LOGGER.info("START : Inside Unit Testing alreadyExistEmail");
		User user = new User();
		user.setEmail("rahulkamble@gmail.com");
		LOGGER.debug("User Object :  {}", user);
		when(userRepository.findByEmail(user.getEmail())).thenReturn(null);

		SignupStatus status = new SignupStatus(false, "Email is alredy exists");
		SignupStatus actualStatus = signupService.save(user);
		Assert.assertEquals(false, status.equals(actualStatus));
		LOGGER.debug("status in new signup  Output :  {}", status);
		LOGGER.debug("Actual  Output :  {}", actualStatus);

		verify(userRepository, times(1)).save(Mockito.any(User.class));
		verify(userRepository, times(1)).findByEmail(user.getEmail());

		LOGGER.info("End : Inside Unit Testing alreadyExistEmail");
	}
	
	/*public void languageSelect(){
		User user = new User();
		Language language = new Language();
		language.setName("English");
		language.setLanguageCode("en");
		user.setLanguage(language);
		
		when(userRepository.findByEmail(user.getLanguage().getLanguageCode())).thenReturn(user);
		
		List<Language> lang = (List<Language>) user.getLanguage();
		List<Language> expectedStatus = signupService.language();
		
		LOGGER.debug("lang  Output :  {}", lang);
		LOGGER.debug("expectedStatus  Output :  {}", expectedStatus);
		
		Assert.assertEquals(true, lang.equals(expectedStatus));
		verify(userRepository, times(0)).save(Mockito.any(User.class));
		verify(userRepository, times(1)).findByEmail(user.getLanguage().getLanguageCode());
	}*/
	
	
	
}
