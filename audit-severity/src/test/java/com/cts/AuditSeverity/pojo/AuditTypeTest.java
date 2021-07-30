package com.cts.AuditSeverity.pojo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.AuditSeverity.pojo.AuditType;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration 
public class AuditTypeTest {

	AuditType auditType = new AuditType();
	
	@Mock
	Environment env;

	@Test
	public void testAuditTypeAllConstructor() {
		AuditType type = new AuditType("abc");
		assertEquals(type.getAuditType(), "abc");
	}

	@Test
	public void testGetAuditType() {
		auditType.setAuditType("abc");
		assertEquals(auditType.getAuditType(), "abc");
	}
	
	@Test
	public void testoString() {
		String string = auditType.toString();
		assertEquals(auditType.toString(), string);
	}

}
