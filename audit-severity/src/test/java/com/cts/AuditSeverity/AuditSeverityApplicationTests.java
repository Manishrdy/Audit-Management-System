package com.cts.AuditSeverity;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class AuditSeverityApplicationTests {

	@Mock
	AuditSeverityApplication application;

	@Test
	public void contextLoads() {
		assertNotNull(application);
	}

}