package com.my.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.spring.dao.StudentDAO;
import com.my.spring.exception.UserException;
import com.my.spring.pojo.Student;

@Controller
@RequestMapping("/student/*")
public class StudentController {

	
	@Autowired
	@Qualifier("studentDao")
	StudentDAO studentDao;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected String goToUserHome(HttpServletRequest request) throws Exception {
		return "home";
	}
	
	@RequestMapping(value = "student/add", method = RequestMethod.GET)
	protected String goToStudent(HttpServletRequest request) throws Exception {
		return "register-student";
	}
	
	
	@RequestMapping(value = "/student/register", method = RequestMethod.POST)
	protected String loginUser(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();
		
		try {

			Student u = studentDao.register(request.getParameter("username"));
			
			System.out.print(u);
			
			if(u == null){
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return "error";
			}else{
				System.out.print("teste");
				session.setAttribute("user", u);
				return "home";
			}
			
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while login");
			return "error";
		}

	}}