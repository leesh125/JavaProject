package com.web.join.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.join.model.*;

@WebServlet("/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/WEB-INF/jsp/join/index.jsp";
		RequestDispatcher rp = request.getRequestDispatcher(view);
		rp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password_check = request.getParameter("password_check");

		JoinDTO dto = new JoinDTO(
				request.getParameter("username"),
				request.getParameter("password"),
				request.getParameter("email"));

		JoinService service = new JoinService(dto);

		request.setAttribute("initData", dto);
		String view = "/WEB-INF/jsp/join/index.jsp";
		RequestDispatcher rp = request.getRequestDispatcher(view);

		if(service.isValid() == 0) { // 유효성 검사에 이상이 없는 경우
			if(service.equalPassword(password_check)) { // 동일한 패스워드를 입력한 경우
				if(service.isDuplicated()) {  // 아이디 중복됨
					rp.forward(request, response);
				} else { // 아이디 중복 안됨
					service.createJoin();
					response.sendRedirect("./login");
				}
			} else { // 동일한 패스워드가 아닌 경우
				rp.forward(request, response);
			}
		} else { // 유효성 검사에 이상이 있는 경우
			rp.forward(request, response);
		}
	}

}