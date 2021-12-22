package com.web.project7.main.controller;



import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="")
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String mainage(@CookieValue(value="cookie_name") Cookie cookie, HttpServletResponse response) {
		logger.info("메인 페이지 동작 확인!");
		if(cookie != null) {
			System.out.println(cookie.getValue());
			cookie.setValue("create_cookie");			
		} else {
			cookie = new Cookie("new_cookie", "create_cookie");
		}
		
		response.addCookie(cookie);
		return "index";
	}
}
