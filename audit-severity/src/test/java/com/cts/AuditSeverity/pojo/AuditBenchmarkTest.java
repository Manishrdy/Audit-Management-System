package com.cts.AuditSeverity.pojo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cts.AuditSeverity.pojo.AuditBenchmark;

public class AuditBenchmarkTest {

	private AuditBenchmark benchmark;
	
	@Before
	public void setup() {
		benchmark = new AuditBenchmark();
	}

	@Test
	public void testGetSetAuditType() {
		benchmark.setAuditType("Internal");
		assertEquals("Internal", benchmark.getAuditType());
	}

	@Test
	public void testGetSetAccNoAnswers() {
		benchmark.setAccNoAnswers(12);
		assertEquals(12, benchmark.getAccNoAnswers());
	}
}
