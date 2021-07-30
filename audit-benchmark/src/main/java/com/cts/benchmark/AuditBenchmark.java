package com.cts.benchmark;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuditBenchmark {

	private String auditType;
	private Integer accNoAnswers;
	
}
