package com.cognizant.auditportal.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.AuditWebPortalApplication;
import com.cognizant.feignclients.AuditCheckListProxy;
import com.cognizant.feignclients.AuditSeverityProxy;
import com.cognizant.feignclients.AuthClient;
import com.cognizant.model.AuditDetails;
import com.cognizant.model.AuditRequest;
import com.cognizant.model.AuditResponse;
import com.cognizant.model.AuditType;
import com.cognizant.model.ProjectDetails;
import com.cognizant.model.ProjectManager;
import com.cognizant.model.Questions;
import com.cognizant.model.QuestionsEntity;
import com.cognizant.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class AuditPortalController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuditPortalController.class);

	AuthClient authClient;
	AuditCheckListProxy auditCheckListProxy;
	AuditRequest auditRequest;
	AuditSeverityProxy auditSeverityProxy;
	Environment env;
	
	public AuditPortalController(AuthClient authClient, AuditCheckListProxy auditCheckListProxy,
			AuditRequest auditRequest, AuditSeverityProxy auditSeverityProxy, Environment env) {
		super();
		this.authClient = authClient;
		this.auditCheckListProxy = auditCheckListProxy;
		this.auditRequest = auditRequest;
		this.auditSeverityProxy = auditSeverityProxy;
		this.env = env;
	}

	@GetMapping("/loginPage")
	public String loginPage(@ModelAttribute User user){
		LOGGER.info("%%%%% Fetching the login page %%%%%");
		LOGGER.debug("User Id -> "+user.getUserId());
		return "login";
	}
	
	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/loginPage";
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String rediretHome()
	{
		return "home";
	}

	
	@RequestMapping(value="/home",method=RequestMethod.POST)
	public String getHome(@ModelAttribute("user") User userCredentials,HttpServletRequest request,ModelMap map) {
		LOGGER.info("User Credentials -> "+userCredentials.toString());
		ResponseEntity<ProjectManager> token = null;
		ProjectManager projectManager = null;
		map.addAttribute("auditType", new AuditType());
		map.addAttribute("projectDetails",new ProjectDetails());
		try {
			token = (ResponseEntity<ProjectManager>) authClient.login(userCredentials);
			LOGGER.info("Get Token of user "+userCredentials.getUserId()+" : "+token.toString());
			 projectManager = token.getBody();
			 request.getSession().setAttribute("token", "Bearer " + projectManager.getAuthToken());
			return "home";
		} catch (Exception e) {
			LOGGER.debug(e.getMessage());
			map.put("errorMessage", env.getProperty("string.invalid.cred"));
			return "login";
		}
	}
	
	@PostMapping("/AuditCheckListQuestions")
	public String getResponses(@ModelAttribute("projectDetails") ProjectDetails projectDetails,
			@ModelAttribute("auditType") AuditType auditType,RedirectAttributes redirectAttributes,HttpSession request,ModelMap map){
				List<QuestionsEntity> questions = new ArrayList<>();
				auditRequest.setProjectName(projectDetails.getProjectName());
				auditRequest.setProjectManagerName(projectDetails.getProjectManagerName());
				auditRequest.setApplicationOwnerName(projectDetails.getApplicationOwnerName());
				try {
					questions =  auditCheckListProxy.getCheckList(request.getAttribute("token").toString(), auditType).getBody();
					
				}catch(IndexOutOfBoundsException e) {
					LOGGER.debug(e.getMessage());
					if (e.getMessage().contains(env.getProperty("string.null"))) {
						return "internalServerError";
					}
				}
				catch(Exception e) {
					LOGGER.debug(e.getMessage());
					if(e.getMessage().contains(env.getProperty("string.token.exp")))
						return "forbidden";
				}
				for(QuestionsEntity question:questions) {
					if(question.getResponse()!=null) {
						question.setResponse(null);
					}
					
				}
				Questions questionslist = new Questions();
				questionslist.setQuestionsEntity(questions);
				redirectAttributes.addFlashAttribute("questions",questionslist);
				redirectAttributes.addFlashAttribute("auditType",auditType);
				return "redirect:/questions";		
	}

	@GetMapping("/questions")
	public String getQuestions(@ModelAttribute("questions") Questions
	questions,@ModelAttribute("auditType") AuditType auditType,HttpSession session,ModelMap map) {
		ResponseEntity<?> authResponse=null;
		try {
			authResponse = authClient.getValidity(session.getAttribute("token").toString());
		}
		catch(Exception e) {
			if(e.getMessage().contains(env.getProperty("token.expired")))
				return "tokenExpiredPage";
			if(e.getMessage().contains(env.getProperty("auth.failed")))
				return "authFailed";
			
			return "redirect:/logout";
		}
		if(authResponse==null) {
			return "tokenExpiredPage";
		}
		return "questions";
		
	}

	@PostMapping("/questions")
	public String getResponses(@ModelAttribute("questions") Questions
	questions,HttpSession session ) {
		ResponseEntity<?> authResponse = null;
		List<QuestionsEntity> responseEntity = null;
		List<QuestionsEntity> questionsEntity = questions.getQuestionsEntity();
		try {
			authResponse = authClient.getValidity(session.getAttribute("token").toString());
			responseEntity = auditCheckListProxy.saveResponses(session.getAttribute("token").toString(), questionsEntity).getBody();
		}
		catch(Exception e) {
			if(e.getMessage().contains(env.getProperty("token.expired")))
				return "tokenExpiredPage";
			if(e.getMessage().contains(env.getProperty("auth.failed")))
				return "authFailed";
			return "redirect:/logout";
		}
		if(authResponse==null || responseEntity==null) {
			return "tokenExpiredPage";
		}
		AuditDetails auditDetails = new AuditDetails(questions.getQuestionsEntity().get(0).getAuditType(),new Date());
		auditRequest.setAuditDetails(auditDetails);
		return "redirect:/status";
	}

	@GetMapping("/status")
	public String getProjectExecutionStatus(HttpSession request,ModelMap map) {
		AuditResponse auditResponse = null;
		LOGGER.info("Project Name -> "+auditRequest.getProjectName()+" | Project Manager -> "+auditRequest.getProjectManagerName()+" |"
				+ " Application Owner -> "+auditRequest.getApplicationOwnerName());
		try {
			auditResponse = auditSeverityProxy.auditSeverity(request.getAttribute("token").toString(),auditRequest).getBody();
		}
		catch(Exception e) {
			LOGGER.debug(e.getMessage());
			if(e.getMessage().contains(env.getProperty("string.token.exp")))
				return "tokenExpiredPage";

			return "tokenExpiredPage";
		}
		map.addAttribute("auditResponse",auditResponse);
		return "status";
	}	
}
