package com.web.bookmark.model;

import java.sql.SQLException;
import java.util.List;

import com.web.guestbook.model.GuestBookDTO;

public class BookMarkService {
	public boolean add(BookMarkDTO dto) {
		boolean res = false;
		try {
			BookMarkDAO dao = new BookMarkDAO();
			res = dao.insert(dto);
			if(res) {
				dao.commit();
				return true;
			} else {
				dao.rollback();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<BookMarkDTO> getList() {
		BookMarkDAO dao = null;
		List<BookMarkDTO> datas = null;
		try {
			dao = new BookMarkDAO();
			datas = dao.select();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return datas;
	}
	
	
}
