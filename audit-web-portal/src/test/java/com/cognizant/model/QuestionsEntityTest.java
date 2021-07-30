package com.cognizant.model;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration
public class QuestionsEntityTest {

	QuestionsEntity questions = new QuestionsEntity();

	@Test
	public void testQuestionsEntityConstructor() {
		assertNotNull(questions);
	}

	@Test
	public void testQuestionsEntityParameterizedConstructor() {
		QuestionsEntity parameterizedQuestions = new QuestionsEntity(1,"Internal","Is data deleted with permission of user?","Yes");
		assertEquals("Internal",parameterizedQuestions.getAuditType());
	}

	@Test
	public void testSetQUestionId() {
		questions.setQuestionId(2);
		assertEquals(2,questions.getQuestionId().intValue());
	}

	@Test
	public void testAuditType() {
		questions.setAuditType("SOX");
		assertEquals("SOX",questions.getAuditType());
	}

	@Test
	public void testQuestion() {
		questions.setQuestion("What is status ?");
		assertEquals("What is status ?",questions.getQuestion());
	}

	@Test
	public void testResponse() {
		questions.setResponse("No");
		assertEquals("No",questions.getResponse());
	}
	
	
}
