package com.cognizant.Controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.feignclient.AuthClient;
import com.cognizant.model.QuestionsEntity;
import com.cognizant.pojo.AuditType;
import com.cognizant.service.QuestionsService;
import com.cognizant.service.TokenService;

import lombok.extern.slf4j.Slf4j;

@RestController 
public class AuditCheckListController {

	private TokenService tokenService;
	private Environment env;
	private QuestionsService questionsService;

	public AuditCheckListController(AuthClient authClient, TokenService tokenService, Environment env,
			QuestionsService questionsService) {
		super();
		
		this.tokenService = tokenService;
		this.env = env;
		this.questionsService = questionsService;
	}

	@PostMapping(path="/getChecklist")
	public ResponseEntity<?> getChecklist(@RequestHeader(name = "Authorization",required = true)String token,@RequestBody AuditType auditType){
		List<QuestionsEntity> questionsList = new ArrayList<>();
		ResponseEntity<?> responseEntity;
		if(tokenService.checkTokenValidity(token)) {
			System.out.println("In checklist" + auditType.getAuditType());
			try {
			questionsList = questionsService.getQuestions(auditType.getAuditType());
			}catch(IndexOutOfBoundsException e) {
				
				responseEntity= new ResponseEntity<String>(env.getProperty("string.null"),HttpStatus.INTERNAL_SERVER_ERROR);
				return responseEntity;
			}
			responseEntity = new ResponseEntity<List<QuestionsEntity>>(questionsList,HttpStatus.OK);
		
			return responseEntity;
			
		}
		else {
			
			responseEntity= new ResponseEntity<String>(env.getProperty("string.token.exp"),HttpStatus.FORBIDDEN);
			return responseEntity;
		}
		
	}

	@PostMapping("/saveResponses")
	public ResponseEntity<?> saveResponses(@RequestHeader(name = "Authorization",required = true)String token,@RequestBody List<QuestionsEntity> questionsResponse){
		List<QuestionsEntity> questionsList = new ArrayList<>();
		ResponseEntity<?> responseEntity;
		if(tokenService.checkTokenValidity(token)) {
			questionsList = questionsService.saveResponses(questionsResponse);
			responseEntity = new ResponseEntity<List<QuestionsEntity>>(questionsList,HttpStatus.OK);
			
			return responseEntity;
		}
		else {
			
			responseEntity= new ResponseEntity<String>(env.getProperty("string.token.exp"),HttpStatus.FORBIDDEN);
			return responseEntity;
		}
	}
	
		
}
