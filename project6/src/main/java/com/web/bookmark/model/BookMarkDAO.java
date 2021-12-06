package com.web.bookmark.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.dbconn.OracleCloudConnect;

public class BookMarkDAO {
	private OracleCloudConnect occ;
	
	public BookMarkDAO() {
		this.occ = new OracleCloudConnect(true);
	}
	
	public List<BookMarkDTO> select() {
		List<BookMarkDTO> datas = new ArrayList<BookMarkDTO>();
		
		String query = "SELECT * FROM BOOKMARK ORDER BY B_ID";
		ResultSet res;
		try {
			res = occ.select(query);
			while(res.next()) {
				BookMarkDTO dto = new BookMarkDTO();
				dto.setNickname(res.getString("B_NAME"));
				dto.setUrl(res.getString("B_URL"));
				datas.add(dto);
			}
			res.close();
			occ.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return datas;
	}
	
	public boolean insert(BookMarkDTO dto) {
		String query = "INSERT INTO BOOKMARK VALUES("
				+ "BOOKMARK_SEQ.NEXTVAL, "
				+ "'" + dto.getNickname() + "', "
				+ "'" + dto.getUrl() + "')";
		
		int res = 0;
		res = occ.insert(query);
		occ.close();
		
		return res == 1 ? true : false;
	}
	
	public void commit() {
		occ.commit();
	}
	
	public void rollback() {
		occ.rollback();
	}
	
	public void close() {
		occ.close();
	}
}