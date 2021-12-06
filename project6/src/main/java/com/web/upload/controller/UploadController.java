package com.web.upload.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload")
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/WEB-INF/jsp/upload/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			MultipartRequest multi = new MultipartRequest(request,
					request.getServletContext().getRealPath("/upload"),
					1024 * 10,
					"utf-8",
					new DefaultFileRenamePolicy());
			String title = multi.getParameter("title");
			String fileName = multi.getFilesystemName("uploadFile");
			
			System.out.println("RealPath : " + request.getServletContext().getRealPath("/upload"));
			System.out.println("일반 텍스트 데이터 : " + title);
			System.out.println("업로드 된 파일의 이름 : " + fileName);
		} catch (IOException e) {
			String view = "/WEB-INF/jsp/upload/index.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			request.setAttribute("error", "제한 용량 초과(10k)");
			rd.forward(request, response);
		}		
		
	}

}