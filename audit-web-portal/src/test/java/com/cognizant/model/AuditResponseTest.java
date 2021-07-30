package com.cognizant.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AuditResponseTest {

	private AuditResponse response;
	
	@Before
	public void setup() {
		response = new AuditResponse(101,"GREEN", "2 Weeks");
	}
	
	@Test
	public void testGetSetAuditId() {
		response.setAuditId(101);
		assertEquals(101, response.getAuditId());
	}
	@Test
	public void testGetSetProjectExecutionStatus() {
		response.setProjectExecutionStatus("RED");
		assertEquals("RED", response.getProjectExecutionStatus());
	}
	@Test
	public void testGetSetRemedialActionDuration() {
		response.setRemedialActionDuration("None");
		assertEquals("None", response.getRemedialActionDuration());
	}
	
	@Test
	public void testoString() {
		String string = response.toString();
		assertEquals(string , response.toString());
	}
}
