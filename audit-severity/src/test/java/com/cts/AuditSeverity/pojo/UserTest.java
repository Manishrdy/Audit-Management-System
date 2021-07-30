package com.cts.AuditSeverity.pojo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.AuditSeverity.pojo.User;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class UserTest {

	User loginCredential = new User();

	@Mock
	Environment env;
	@Test
	public void testUserLoginCredentialAllConstructor() {
		User credential = new User("abc", "abc");
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
