package com.cognizant.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;



import org.junit.Before;
import org.junit.Test;

public class AuthResponseTest {

	private AuthResponse auth;
	
	@Before
	public void setup() {
		auth = new AuthResponse();
	}

	@Test
	public void testGetSetUid() {
		auth.setUid("manish.rdy");
		assertEquals("manish.rdy", auth.getUid());
	}

	@Test
	public void testValid() {
		auth.setValid(false);
		assertFalse(auth.isValid());
	}
	
	@Test
	public void testoString() {
		String string = auth.toString();
		assertEquals(string , auth.toString());
	}
	
	@Test
	public void testAuthResponseAllConstructor()
	{
		AuthResponse authResponse=new AuthResponse("manish", true);
		assertEquals( "manish" , authResponse.getUid());
	}
	
}
