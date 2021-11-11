package com.web.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.guestbook.model.GuestBookDTO;
import com.web.guestbook.model.GuestBookService;

@WebServlet("/guest")
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestBookService service = new GuestBookService();
		
		request.setAttribute("datas", service.getList());
		
		String view = "/WEB-INF/jsp/guestbook/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String context = request.getParameter("context");
		String ipaddr = request.getRemoteAddr();
		
		GuestBookDTO dto = new GuestBookDTO(ipaddr,context);
		GuestBookService service = new GuestBookService();
		if(service.add(dto)) {
			// 저장 완료
			response.sendRedirect("/guest");
		} else {
			// 저장 실패	
			System.out.println("!@#$@#@");
			request.setAttribute("init", dto);
			request.setAttribute("datas", service.getList());
			String view = "/WEB-INF/jsp/guestbook/index.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
		
	}

}
