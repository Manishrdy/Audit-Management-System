package com.cts.benchmark.pojo;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomErrorResponse {

	
	private LocalDateTime timestamp;
	private HttpStatus status;
	private String reason;
	private String message;
}
