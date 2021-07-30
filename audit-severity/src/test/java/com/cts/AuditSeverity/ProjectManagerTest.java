package com.cts.AuditSeverity;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration 
public class ProjectManagerTest {
	
	ProjectManager projectManager = new ProjectManager();

	@Test
	public void testProjectManagerAllConstructor()
	{
		ProjectManager manager=new ProjectManager("ab", "ab", null);
		assertEquals( "ab" , manager.getUserId());
	}

	@Test
	public void testUserid()
	{
		projectManager.setUserId("abc");
		assertEquals( "abc",  projectManager.getUserId());
	}

	@Test
	public void testUserPassword()
	{
		projectManager.setPassword("abc");
		assertEquals( "abc" , projectManager.getPassword());
	}

	@Test
	public void testAuthToken()
	{
		projectManager.setAuthToken("abc");
		assertEquals("abc", projectManager.getAuthToken());
	}

	@Test
	public void testoString() {
		String string = projectManager.toString();
		assertEquals(string , projectManager.toString());
	}

}
