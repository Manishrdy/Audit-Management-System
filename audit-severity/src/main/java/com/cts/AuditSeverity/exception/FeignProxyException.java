package com.cts.AuditSeverity.exception;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;

public class FeignProxyException extends Exception{

	private static final long serialVersionUID = 1L;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
	    return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Autowired
	private Environment env;
	
	
	public FeignProxyException() {

	}

}
