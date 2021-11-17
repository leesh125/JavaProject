package com.web.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.login.model.LoginDTO;
import com.web.login.model.LoginService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/jsp/login/index.jsp";
		RequestDispatcher rp = request.getRequestDispatcher(view);
		rp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDTO dto = new LoginDTO(
				request.getParameter("username"),
				request.getParameter("password"));
		LoginService service = new LoginService(dto);
		
		String view = "/WEB-INF/jsp/login/index.jsp";
		RequestDispatcher rp = request.getRequestDispatcher(view);
		
		
		if(service.isExist()) { // 아이디가 존재할 경우
			if(service.eqaulPass()) { // 패스워드가 일치할 경우
				response.sendRedirect("/");
				System.out.println("아이디 있음!");
			}else { // 패스워드 일치하지 않을 경우
				request.setAttribute("login_error","패스워드를 잘못 입력했습니다.");
				rp.forward(request, response);
			}
		}else { // 아이디가 존재하지 않을 경우
			request.setAttribute("login_error","아이디를 잘못 입력했습니다.");
			rp.forward(request, response);
			System.out.println("아이디 없음!");
		}
				
	}

}
