package com.web.board.model;

import com.web.board.model.BoardDTO;

import java.util.List;

import com.web.board.model.BoardDAO;

public class BoardService {
	private BoardDAO dao = null;
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean add(BoardDTO dto) {
		boolean res = dao.insertBoard(dto);
        if(res) {
            dao.commit();
        } else {
            dao.rollback();
        }
        dao.close();
        return res;
	}
	public List<BoardDTO> getList() {
		BoardDAO dao = new BoardDAO();
		return dao.selectAll();;
	}
}
