package com.web.board.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardService {

	public List<BoardDTO> getList() {
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> datas = dao.select();
		dao.close();
		return datas;
	}

	public List<BoardCategoryDTO> getCategory() {
		BoardDAO dao = new BoardDAO();
		List<BoardCategoryDTO> datas = dao.selectCategory();
		dao.close();
		return datas;
	}
	
	public List<BoardDTO> getList(BoardDTO dto) {
		BoardDAO dao = new BoardDAO();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(dto.getCid() > 0) {
			paramMap.put("", "");
		}
		if(dto.getTitle() != null) {
			paramMap.put("", "");
		}

		List<BoardDTO> datas = dao.selectCategoryType(dto.getCid());
		dao.close();
		return datas;
	}
}