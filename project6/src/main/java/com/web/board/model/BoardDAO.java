package com.web.board.model;

import java.sql.SQLException;

import com.jspweb.dbconn.OracleCloudConnect;
import com.web.guestbook.model.GuestBookDTO;

public class BoardDAO {
	OracleCloudConnect occ = null;
	public boolean insertBoard(BoardDTO dto) {
		String query = "INSERT INTO GUESTBOOK VALUES("
				+ "'" + dto.getBoard_num() + "', "
				+ "'" + dto.getBoard_writer()+ "', "
				+ "'" + dto.getBoard_title() + "', "
				+ "'" + dto.getBoard_content() + "', "
				+ "SYSDATE"
				+ ")";
		
		int res = 0;        
		try {
			res = occ.insertQuery(query);
			occ.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res == 1 ? true : false;
    }
	public void commit() {
        try {
			occ.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	 public void close() {
	    	try {
				occ.connectionClose();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }

    public void rollback() {
        try {
			occ.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
