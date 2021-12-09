package com.web.account.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.web.account.model.AccountDTO;
import com.web.account.model.AccountService;

@WebServlet("/account/ajax/join")
public class JoinAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");

		AccountDTO dto = new AccountDTO(username, null);
		AccountService service = new AccountService(dto);

		JSONObject json = new JSONObject();
		if(service.isExisted()) {
			response.setStatus(400);
		} else {
			json.put("msg", "사용 가능한 아이디 입니다.");
			response.setStatus(200);
		}

		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(json.toJSONString());
		out.flush();
	}

}