package com.cognizant.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration
public class UserTest {

	User loginCredential = new User();

	@Mock
	Environment env;
	@Test
	public void testUserLoginCredentialAllConstructor() {
		User credential = new User("manish.rdy", "feDdw$31");
		assertEquals(credential.getUserId(), "manish.rdy");
	}

	@Test
	public void testGetUid() {
		loginCredential.setUserId("manish.rdy");
		assertEquals(loginCredential.getUserId(), "manish.rdy");
	}

	@Test
	public void testUserPassword() {
		loginCredential.setPassword("feDdw$31");
		assertEquals(loginCredential.getPassword(), "feDdw$31");
	}

	@Test
	public void testoString() {
		String string = loginCredential.toString();
		assertEquals(loginCredential.toString(), string);
	}

}
