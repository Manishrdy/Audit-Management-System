package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.AuthResponse;
import com.cognizant.model.ProjectManager;
import com.cognizant.model.UserCredentials;
import com.cognizant.service.JwtUtil;
import com.cognizant.service.ManagerDetailsService;
import com.cognizant.exception.LoginFailedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class AuthController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private JwtUtil jwtutil;

	@Autowired
	private ManagerDetailsService managerDetailsService;

	@Autowired
	Environment env;

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody UserCredentials userLoginCredentials) throws Exception{		
		final UserDetails userdetails = managerDetailsService.loadUserByUsername(userLoginCredentials.getUserId());

		if (userdetails.getPassword().equals(userLoginCredentials.getPassword())) {
			String token = jwtutil.generateToken(userdetails);
			ProjectManager projectManager = new ProjectManager(userLoginCredentials.getUserId(), userLoginCredentials.getPassword(), token);
			managerDetailsService.saveUser(projectManager);
			return new ResponseEntity<>(
					projectManager,HttpStatus.OK);
		} else {

			throw new LoginFailedException(env.getProperty("string.reason.loginfail"));

		}
	}

	@GetMapping(value = "/validate")
	public ResponseEntity<?> getValidity(@RequestHeader("Authorization") String token)  {
		token = token.substring(7);
		AuthResponse res = new AuthResponse();
		ResponseEntity<?> response=null;
		try {
				if(jwtutil.validateToken(token)) {
				res.setUid(jwtutil.extractUsername(token));
				res.setValid(true);

			}
		}
		catch(Exception e) {
			res.setValid(false);
			if(e.getMessage().contains(env.getProperty("token.expired")))
				response =  new ResponseEntity<String>(env.getProperty("token.expired"),HttpStatus.FORBIDDEN);
			if(e.getMessage().contains(env.getProperty("auth.failed")))
				response = new ResponseEntity<String>(env.getProperty("auth.failed"),HttpStatus.FORBIDDEN);
			response = new ResponseEntity<>(res,HttpStatus.FORBIDDEN);
			return response;
		}
		response = new ResponseEntity<AuthResponse>(res,HttpStatus.OK);
		return response;
	}
	
	
}
