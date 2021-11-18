package com.web.bookmark.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.bookmark.model.BookMarkDTO;
import com.web.bookmark.model.BookMarkService;



@WebServlet("/bookmark")
public class BookMarkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookMarkService service = new BookMarkService();
		
		request.setAttribute("datas", service.getList());
		
		String view = "/WEB-INF/jsp/bookmark/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String nickname = request.getParameter("nickname");
		String url = request.getParameter("url");
		
		if(nickname == "") {
			nickname = url;
		}
		
		BookMarkDTO dto = new BookMarkDTO(nickname,url);
		BookMarkService service = new BookMarkService();
		
		if(service.add(dto)) {
			response.sendRedirect("/bookmark");
		} else {
			request.setAttribute("init", dto);
			request.setAttribute("datas", service.getList());
			String view = "/WEB-INF/jsp/bookmark/index.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);

    		System.out.println("asdasd");
		}
		
	}

}
