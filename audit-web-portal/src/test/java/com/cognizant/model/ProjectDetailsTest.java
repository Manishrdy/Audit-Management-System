package com.cognizant.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectDetailsTest {

	ProjectDetails projectDetails = new ProjectDetails();

	@Test
	public void testProjectDetailsAllConstructor()
	{
		ProjectDetails project = new ProjectDetails("audit-management", "Manish","Reddy");
		assertEquals( "audit-management" , project.getProjectName());
	}

	@Test
	public void testProjectName()
	{
		projectDetails.setProjectName("audit-management");;
		assertEquals( "audit-management",  projectDetails.getProjectName());
	}

	@Test
	public void testProjectManagerName()
	{
		projectDetails.setProjectManagerName("Manish");;
		assertEquals( "Manish" , projectDetails.getProjectManagerName());
	}

	@Test
	public void testApplicationOwnerName()
	{
		projectDetails.setApplicationOwnerName("Reddy");
		assertEquals("Reddy", projectDetails.getApplicationOwnerName());
	}
}
