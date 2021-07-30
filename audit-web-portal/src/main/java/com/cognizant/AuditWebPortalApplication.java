package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
@SpringBootApplication
@EnableFeignClients
public class AuditWebPortalApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(AuditWebPortalApplication.class, args);
	}

}
