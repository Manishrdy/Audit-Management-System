package com.cognizant.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectManagerTest {
	
	ProjectManager projectManager = new ProjectManager();

	@Test
	public void testProjectManagerAllConstructor()
	{
		ProjectManager manager = new ProjectManager("manish", "manish", null);
		assertEquals( "manish" , manager.getUserId());
	}

	@Test
	public void testUserid()
	{
		projectManager.setUserId("manish.rdy");
		assertEquals( "manish.rdy",  projectManager.getUserId());
	}

	@Test
	public void testUserPassword()
	{
		projectManager.setPassword("feDdw$31");
		assertEquals( "feDdw$31" , projectManager.getPassword());
	}

	@Test
	public void testAuthToken()
	{
		projectManager.setAuthToken("asBdx$&12");
		assertEquals("asBdx$&12", projectManager.getAuthToken());
	}

	@Test
	public void testoString() {
		String string = projectManager.toString();
		assertEquals(string , projectManager.toString());
	}
}
