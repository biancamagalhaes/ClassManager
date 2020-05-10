package com.my.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.spring.dao.DisciplineDAO;
import com.my.spring.pojo.Discipline;


@Controller
@RequestMapping("/discipline/*")
public class DisciplineController {
	
	@Autowired
	@Qualifier("disciplineDao")
	DisciplineDAO disciplineDao;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected String goToHome(HttpServletRequest request) throws Exception {
		return "home";
	}
	
	@RequestMapping(value = "discipline/add", method = RequestMethod.GET)
	protected String goToDisciplineAdd(HttpServletRequest request) throws Exception {
		return "register-discipline";
	}
	
	
	@RequestMapping(value = "/discipline/register", method = RequestMethod.POST)
	protected String disciplineRegister(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();
	
		
		Discipline d = disciplineDao.create(request.getParameter("name"));
		
		
		if(d == null){
			System.out.println("UserName/Password does not exist");
			session.setAttribute("errorMessage", "UserName/Password does not exist");
			return "error";
		}else{
			session.setAttribute("class", d);
			return "home";
		}

	}}