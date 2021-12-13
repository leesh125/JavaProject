package com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*@WebFilter(urlPatterns = {"/board/*", "/comment/*"})*/
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		boolean logined = false;
		if(session.getAttribute("logined") != null) {
			logined = (boolean)session.getAttribute("logined");
		}
		
		if(logined) {
			chain.doFilter(request, response);			
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

}
