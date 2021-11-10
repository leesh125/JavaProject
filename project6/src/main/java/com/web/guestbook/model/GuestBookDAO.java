package com.web.guestbook.model;

import java.sql.SQLException;

import com.jspweb.dbconn.OracleCloudConnect;

public class GuestBookDAO {
	OracleCloudConnect occ = null;
	
	public GuestBookDAO() throws SQLException {
        this.occ = new OracleCloudConnect();
        this.occ.connection();
    }
	
	public boolean insert(GuestBookDTO dto) throws SQLException {
		String query = "INSERT INTO GUESTBOOK VALUES("
				+ "GUESTBOOK_SEQ.NEXTVAL, "
				+ "'" + dto.getIpaddr() + "', "
				+ "'" + dto.getContext() + "', "
				+ "SYSDATE"
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
