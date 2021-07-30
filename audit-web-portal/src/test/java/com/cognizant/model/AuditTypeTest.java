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
public class AuditTypeTest {

	AuditType auditType = new AuditType();
	
	@Mock
	Environment env;

	@Test
	public void testAuditTypeAllConstructor() {
		AuditType type = new AuditType("XYZ");
		assertEquals(type.getAuditType(), "XYZ");
	}

	@Test
	public void testGetAuditType() {
		auditType.setAuditType("Internal");
		assertEquals(auditType.getAuditType(), "Internal");
	}
	
	@Test
	public void testoString() {
		String string = auditType.toString();
		assertEquals(auditType.toString(), string);
	}

}
