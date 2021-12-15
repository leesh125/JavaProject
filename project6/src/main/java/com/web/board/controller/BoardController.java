package com.web.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.board.model.BoardDTO;
import com.web.board.model.BoardService;
import com.web.board.model.BoardCategoryDTO;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String view = "/WEB-INF/jsp/board/index.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		String search = request.getParameter("search");
		
		BoardDTO dto = new BoardDTO();
		dto.setCid(type);
		dto.setTitle(search);
		
		BoardService service = new BoardService();
		
		List<BoardDTO> datas = service.search(dto);

		List<BoardCategoryDTO> category = service.getCategory();

		request.setAttribute("datas", datas);
		request.setAttribute("category", category);
		
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}