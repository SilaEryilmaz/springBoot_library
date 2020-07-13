package com.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.web.service.LoginService;


@Controller
@SessionAttributes("reader")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String getLoginPage(ModelMap model){
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String getHomePage(ModelMap model, @RequestParam String reader, @RequestParam String password){
		
		boolean isValidUser = service.validateUser(reader, password);
		
		if (!isValidUser) {
			model.put("errorMessage", "Invalid Access");
			return "login";
		}
		
		model.put("reader", reader);
		model.put("password", password);
		
		return "home";
	}

}