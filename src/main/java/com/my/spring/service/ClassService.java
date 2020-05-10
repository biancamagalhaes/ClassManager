package com.my.spring.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.my.spring.dao.ClassDAO;
import com.my.spring.exception.UserException;
import com.my.spring.pojo.Class;

public class ClassService {

	ClassDAO classDao;
	public String Insert( HttpServletRequest request){
		
		HttpSession session = (HttpSession) request.getSession();

		
		Class newC = new Class(request.getParameter("place"));
		Class c;
		try {
			c = classDao.register(newC);
			if(c == null){
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return "error";
			}else{
				session.setAttribute("class", c);
				return "home";
			}

		} catch (UserException e) {
			e.printStackTrace();
			return "error";
		}
		
		
		
	}

	
}
