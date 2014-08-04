package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.TestService;

@Controller
public class LoginController {
	
	@Autowired
    protected TestService testService;

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
}
