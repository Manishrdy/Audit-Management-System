package com.cts.AuditSeverity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cts.AuditSeverity.exception.FeignProxyException;
import com.cts.AuditSeverity.fiegnclient.AuthClient;
import com.cts.AuditSeverity.pojo.AuthResponse;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Service
public class TokenServiceImpl implements TokenService {

	@Autowired
	private AuthClient authClient;
	@Autowired
	Environment env;

	public Boolean checkTokenValidity(String token)  {
		try {
			AuthResponse authResponse = authClient.getValidity(token).getBody();
			if(authResponse==null) throw new FeignProxyException();

			return authResponse.isValid();
		} catch (FeignProxyException fe) {
			
			return false;
		}catch(FeignException e) {

			return false;
		}
		
	}

}
