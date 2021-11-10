package com.web.guestbook.model;

import java.sql.SQLException;
import java.util.List;

public class GuestBookService {
	public boolean add(GuestBookDTO dto) {
		boolean res = false;
		try {
			GuestBookDAO dao = new GuestBookDAO();
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
	
	public List<GuestBookDTO> getList() {
		return null;
	}
}
