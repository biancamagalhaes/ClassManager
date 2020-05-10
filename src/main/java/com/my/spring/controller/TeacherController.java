package com.my.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.spring.dao.TeacherDAO;
import com.my.spring.exception.UserException;
import com.my.spring.pojo.Teacher;

@Controller
@RequestMapping("/teacher/*")
public class TeacherController {

	
	@Autowired
	@Qualifier("teacherDao")
	TeacherDAO teacherDao;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected String goToUserHome(HttpServletRequest request) throws Exception {
		return "home";
	}
	
	@RequestMapping(value = "/teacher/add", method = RequestMethod.GET)
	protected String goToStudent(HttpServletRequest request) throws Exception {
		return "register-teacher";
	}
	
	
	@RequestMapping(value = "/teacher/register", method = RequestMethod.POST)
	protected String loginUser(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();
		
		try {

			Teacher t = teacherDao.register(request.getParameter("username"));
			
			
			if(t == null){
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return "error";
			}else{
				System.out.print("teste");
				session.setAttribute("user", t);
				return "home";
			}
			
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while login");
			return "error";
		}

	}
	
//	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
//	protected ModelAndView registerUser() throws Exception {
//		System.out.print("registerUser");
//
//		ModelAndView mav = new ModelAndView("register-user");
//		Map<String,String> usertype = new LinkedHashMap<String,String>();
//		usertype.put("Buyer", "Buyer");
//		usertype.put("Seller", "Seller");
//		
//		mav.addObject("usertype", usertype);
//        mav.addObject("user", new User());
//        return mav;
//		//return new ModelAndView("", "user", new User());
//	}
	
//	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
//	protected ModelAndView registerNewUser(HttpServletRequest request,  @ModelAttribute("user") User user, BindingResult result) throws Exception {
//
//		if (result.hasErrors()) {
//			ModelAndView mav = new ModelAndView("register-user");
//			Map<String,String> usertype = new LinkedHashMap<String,String>();
//			usertype.put("Buyer", "Buyer");
//			usertype.put("Seller", "Seller");
//			
//			mav.addObject("usertype", usertype);
//	        mav.addObject("user", user);
//	        return mav;
//			//return new ModelAndView("register-user", "user", user);
//		}
//
//		try {
//
//			System.out.print("registerNewUser");
//
//			User u = userDao.register(user);
//			
//			request.getSession().setAttribute("user", u);
//			Email email= new SimpleEmail();
//	           email.setHostName("smtp.googlemail.com");
//	           email.setSmtpPort(465);
//	           email.setAuthentication("puthranmitesh@gmail.com", "9892098500");
//	           email.setSSLOnConnect(true);
//	           email.setFrom(user.getEmail().getEmailAddress());
//	           email.setSubject("Sign Up Successful");
//	           email.setMsg("Welcome to the NEU Store\n\n Your account has been successfully created.");
//	           email.addTo(user.getEmail().getEmailAddress());
//	           email.send();
//			
//			return new ModelAndView("account-success", "user", u);
//
//		} catch (UserException e) {
//			System.out.println("Exception: " + e.getMessage());
//			return new ModelAndView("error", "errorMessage", "error while login");
//		}
//	}
//
//		protected Map referenceData(HttpServletRequest request) throws Exception {
//
//		Map referenceData = new HashMap();
//
//		Map<String,String> usertype = new LinkedHashMap<String,String>();
//		usertype.put("Buyer", "Buyer");
//		usertype.put("Seller", "Seller");
//		referenceData.put("usertype", usertype);
//		
//		return referenceData;
//	}
}
