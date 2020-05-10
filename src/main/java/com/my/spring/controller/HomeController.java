package com.my.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home/*")
public class HomeController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected String goToUserHome(HttpServletRequest request) throws Exception {
		return "home";
	}
	
	@RequestMapping(value = "/home/dashboard", method = RequestMethod.GET)
	protected String goToDashboard(HttpServletRequest request) throws Exception {
		return "home";
	}
}