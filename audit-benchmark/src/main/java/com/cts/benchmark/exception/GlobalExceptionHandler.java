package com.cts.benchmark.exception;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cts.benchmark.pojo.CustomErrorResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	Environment env;
	@ExceptionHandler(FeignProxyException.class)
	public ResponseEntity<CustomErrorResponse> handelFeignProxyException(FeignProxyException ex) {
		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setReason(env.getProperty("feign.null"));
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.NOT_FOUND);
	}

}
