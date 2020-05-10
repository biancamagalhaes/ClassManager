package com.my.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.spring.dao.ClassDAO;
import com.my.spring.service.ClassService;


@Controller
@RequestMapping("/class/*")
public class ClassController {
	
	@Autowired
	@Qualifier("classDao")
	ClassDAO classDao;
	ClassService classService;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected String goToHome(HttpServletRequest request) throws Exception {
		return "home";
	}
	
	@RequestMapping(value = "class/add", method = RequestMethod.GET)
	protected String goToClassAdd(HttpServletRequest request) throws Exception {
		return "register-class";
	}
	
	
	@RequestMapping(value = "/class/register", method = RequestMethod.POST)
	protected String classRegister(HttpServletRequest request) throws Exception {
		return classService.Insert(request);
	}


}