package com.example.web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String readerid, String password) {
		// sila, 1234
		return readerid.equalsIgnoreCase("sila")
				&& password.equalsIgnoreCase("1234");
	}

}
