package com.cts.AuditSeverity.exception;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.AuditSeverity.fiegnclient.CustomErrorResponse;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class GlobalExceptionHandlerTest {

	@InjectMocks
	GlobalExceptionHandler handler;
	@Mock
	CustomErrorResponse response;
	@Mock
	Environment env;
	
	@Test
	public void contextLoads() {
		assertNotNull(handler);
	}
	
}
