package com.my.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.spring.dao.MatterDAO;
import com.my.spring.pojo.Matter;

@Controller
@RequestMapping("/matter/*")
public class MatterController {

	
	@Autowired
	@Qualifier("matterDao")
	MatterDAO matterDao;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected String goToHome(HttpServletRequest request) throws Exception {
		return "home";
	}
	
	@RequestMapping(value = "matter/add", method = RequestMethod.GET)
	protected String goToMatterAdd(HttpServletRequest request) throws Exception {
		return "register-matter";
	}
	
	
	@RequestMapping(value = "/matter/register", method = RequestMethod.POST)
	protected String matterRegister(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		Matter newM = new Matter(request.getParameter("title"), request.getParameter("subtitle"));
		Matter m = matterDao.create(newM);
		
		if(m == null){
			System.out.println("UserName/Password does not exist");
			session.setAttribute("errorMessage", "UserName/Password does not exist");
			return "error";
		}else{
			session.setAttribute("matter", m);
			return "home";
		}

	}}