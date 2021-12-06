package com.web.board.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.board.model.BoardDTO;
import com.web.board.model.BoardService;

@WebServlet("/board/write")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = new BoardService();
		List<BoardDTO> datas = service.getList();
		
		String view = "/WEB-INF/jsp/board/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		request.setCharacterEncoding("UTF-8");
		
        String num = request.getParameter("board_num");
        String writer= request.getParameter("board_writer");
        String title = request.getParameter("board_title");
        String content = request.getParameter("board_content");
        
        
        
        BoardDTO dto = new BoardDTO(writer, title, content);
        dto.setNum(num);
        BoardService service = new BoardService();
        
        String view = "/WEB-INF/jsp/board/write.jsp";
		RequestDispatcher rp = request.getRequestDispatcher(view);
		
		
		if(service.isValid()) { // 아이디가 존재할 경우
			response.sendRedirect("/board");
		}else { // 아이디가 존재하지 않을 경우
			rp.forward(request, response);
		}
	}

}
