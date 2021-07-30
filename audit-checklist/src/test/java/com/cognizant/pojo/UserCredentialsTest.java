package com.cognizant.pojo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author POD5
 * @version 1.8
 * @apiNote This class is used to hold the login credentials which will be sent
 *          by the user in the request body for getting the token
 *
 */
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration @Slf4j
public class UserCredentialsTest {

	UserCredentials loginCredential = new UserCredentials();

	@Mock
	Environment env;
	@Test
	public void testUserLoginCredentialAllConstructor() {
		
		UserCredentials credential = new UserCredentials("abc", "abc");
		assertEquals(credential.getUserId(), "abc");
		
	}

	@Test
	public void testGetUid() {
		
		loginCredential.setUserId("abc");
		assertEquals(loginCredential.getUserId(), "abc");
		
	}

	@Test
	public void testUserPassword() {
		
		loginCredential.setPassword("abc");
		assertEquals(loginCredential.getPassword(), "abc");
		
	}

	@Test
	public void testoString() {
		
		String string = loginCredential.toString();
		assertEquals(loginCredential.toString(), string);
	}

}
