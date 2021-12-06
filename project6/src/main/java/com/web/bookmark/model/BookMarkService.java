package com.web.bookmark.model;

import java.sql.SQLException;
import java.util.List;

import com.web.guestbook.model.GuestBookDTO;

public class BookMarkService {
	public boolean add(BookMarkDTO dto) throws SQLException {
		boolean res = false;
		BookMarkDAO dao = new BookMarkDAO();
		res = dao.insert(dto);
		if(res) {
			dao.commit();
			return true;
		} else {
			dao.rollback();
			return false;
		}
	}
	
	public List<BookMarkDTO> getList() throws SQLException {
		BookMarkDAO dao = null;
		List<BookMarkDTO> datas = null;
		dao = new BookMarkDAO();
		datas = dao.select();
		
		return datas;
	}
	
	
}
