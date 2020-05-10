package com.my.spring.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.spring.dao.EventDAO;
import com.my.spring.pojo.Event;

@Controller
@RequestMapping("/event/*")
public class EventController {

	
	@Autowired
	@Qualifier("eventDao")
	EventDAO eventDao;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected String goToHome(HttpServletRequest request) throws Exception {
		return "home";
	}
	
	@RequestMapping(value = "event/add", method = RequestMethod.GET)
	protected String goToEventAdd(HttpServletRequest request) throws Exception {
		return "register-event";
	}
	
	
	@RequestMapping(value = "/event/register", method = RequestMethod.POST)
	protected String eventRegister(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
	    Date parsedDateStart = dateFormat.parse(request.getParameter("timeStart"));
	    Date parsedDateEnd = dateFormat.parse(request.getParameter("timeEnd"));
	    Timestamp timestampStart = new java.sql.Timestamp(parsedDateStart.getTime());

	    Timestamp timestampEnd = new java.sql.Timestamp(parsedDateEnd.getTime());
		
		Event newE = new Event(timestampStart, timestampEnd, request.getParameter("description"), request.getParameter("name"), request.getParameter("type"));
		Event e = eventDao.insert(newE);
		
		
		if(e == null){
			System.out.println("UserName/Password does not exist");
			session.setAttribute("errorMessage", "UserName/Password does not exist");
			return "error";
		}else{
			session.setAttribute("event", e);
			return "home";
		}

	}}