package com.cognizant.pojo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AuditTypeTest {

	
	AuditType auditType = new AuditType();

	@Test
	public void testSetAuditType() {
		auditType.setAuditType("Internal");
		assertEquals("Internal",auditType.getAuditType());
	}

	@Test
	public void testGetAuditType() {
		auditType.setAuditType("SOX");
		assertEquals("SOX",auditType.getAuditType());
	}

	@Test
	public void testAuditTypeConstructor() {
		AuditType auditTypeTest = new AuditType("Sox");
		assertEquals("Sox",auditTypeTest.getAuditType());
	}

	@Test
	public void testAuditTypeToString() {
		String s = new AuditType().toString();
		assertEquals(s,auditType.toString());
				
	}
	
	
}
