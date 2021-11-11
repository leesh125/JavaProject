package com.web.bookmark.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspweb.dbconn.OracleCloudConnect;

public class BookMarkDAO {
	OracleCloudConnect occ = null;
	
	public BookMarkDAO() throws SQLException {
        this.occ = new OracleCloudConnect();
        this.occ.connection();
    }
	
	public List<BookMarkDTO> select() throws SQLException {
		List<BookMarkDTO> datas = new ArrayList<BookMarkDTO>();
		String query = "SELECT * FROM BOOKMARK";
		ResultSet res = occ.sendQuery(query);
		while(res.next()) {
			BookMarkDTO dto = new BookMarkDTO();
			dto.setNickname(res.getString("b_nickname"));
			dto.setUrl(res.getString("b_url"));
			datas.add(dto);
		}
		
		res.close();
		occ.close();
		
		return datas;
	}
	
	public boolean insert(BookMarkDTO dto) throws SQLException {
		String query = "INSERT INTO BOOKMARK VALUES("
				+ "'" + dto.getNickname() + "', "
				+ "'" + dto.getUrl() + "'"
				+ ")";
		int res = occ.insertQuery(query);
		if(res == 1) {
			return true;
		}
		return false;
		
	}
	
	public void commit() throws SQLException {
    	occ.commit();
    }

    public void rollback() throws SQLException {
    	occ.rollback();
    }
}
