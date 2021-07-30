package com.cognizant.service;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cognizant.exception.FeignProxyException;
import com.cognizant.feignclient.AuthClient;
import com.cognizant.pojo.AuthResponse;
import feign.FeignException;

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
