package com.gcu.business;

import org.springframework.stereotype.Service;

@Service
public class SecurityBusinessServer {
	public boolean authenticate(String username, String password) {
		System.out.println("Hello from the SecurityBusinessService");	
		return true;
	}
}
