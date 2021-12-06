package com.web.account.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.account.model.*;

@WebServlet("/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String view = "/WEB-INF/jsp/account/join.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher(view).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        AccountDTO dto = new AccountDTO(username, password);
        AccountService service = new AccountService(dto);
        
        boolean isRedirect = false;
        
        if(service.isValid()) {
            if(service.join()) {
                response.sendRedirect("/login");
                isRedirect = true;
            } else {
            	request.setAttribute("error", "가입 처리중 예상치 못한 문제가 발생하였습니다.");
            }
        } else {
        	request.setAttribute("error", "아이디, 패스워드를 다시 확인하세요.");
        }
        
        if(isRedirect) {
        	response.sendRedirect("/login");
        } else {
        	request.setAttribute("account_data", dto);
        	request.getRequestDispatcher(view).forward(request, response);
        }
	}

}