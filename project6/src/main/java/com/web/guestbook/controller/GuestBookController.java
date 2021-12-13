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

	private GuestBookService service = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service = new GuestBookService();
		request.setAttribute("datas", service.getList());
		
		String view = "/WEB-INF/jsp/guestbook/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        String context = request.getParameter("context");
        String ipaddr = request.getRemoteAddr();

        if(id == null) {
	        GuestBookDTO dto = new GuestBookDTO(ipaddr, context);
	        service = new GuestBookService();

	        if(service.add(dto)) {
	            response.sendRedirect("/guest");
	        } else {
	        	request.setAttribute("init", dto);
	        	request.setAttribute("datas", service.getList());
	            String view = "/WEB-INF/jsp/guestbook/index.jsp";
	            RequestDispatcher rd = request.getRequestDispatcher(view);
	            rd.forward(request, response);
	        }
        } else {
        	GuestBookDTO dto = new GuestBookDTO();
        	service = new GuestBookService();

        	dto.setId(id);
        	dto.setContext(context);
        	if(service.modify(dto)) {
        		response.sendRedirect("/guest");
        	} else {
        		response.sendRedirect("/guest");
        	}
        }
    }
}