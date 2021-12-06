package com.web.guestbook.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.dbconn.OracleCloudConnect;

public class GuestBookDAO {
	OracleCloudConnect occ = null;
	
	public GuestBookDAO() {
		this.occ = new OracleCloudConnect(true);
    }
	
	public List<GuestBookDTO> select() {
		List<GuestBookDTO> datas = new ArrayList<GuestBookDTO>();
		String query = "SELECT * FROM GUESTBOOK ORDER BY G_DATE DESC";
		ResultSet res;
		try {
			res = occ.select(query);
			while(res.next()) {
				GuestBookDTO dto = new GuestBookDTO();
				dto.setId(res.getString("g_id"));
				dto.setIpaddr(res.getString("g_ipaddr"));
				dto.setContext(res.getString("g_context"));
				dto.setDate(res.getDate("g_date"));
				datas.add(dto);
			}

			res.close();
			occ.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return datas;
	}
	
	public GuestBookDTO select(int id) {
    	GuestBookDTO dto = new GuestBookDTO();
    	String query = "SELECT * FROM GUESTBOOK"
    			+ " WHERE G_ID = " + id;

    	try {
			ResultSet res = occ.select(query);
			res.next();
			dto.setResultSet(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}

    	return dto;
    }
	
	public boolean insert(GuestBookDTO dto) {
		String query = "INSERT INTO GUESTBOOK VALUES("
				+ "GUESTBOOK_SEQ.NEXTVAL, "
				+ "'" + dto.getIpaddr() + "', "
				+ "'" + dto.getContext() + "', "
				+ "SYSDATE"
				+ ")";
		int res = 0;        
		res = occ.insert(query);
		occ.close();
		return res == 1 ? true : false;
    }
	
	
	public boolean update(GuestBookDTO dto) {
    	String query = "UPDATE GUESTBOOK"
    			+ "  SET"
    			+ "    G_CONTEXT = '" + dto.getContext() + "'"
    			+ "  WHERE G_ID = " + dto.getId() + "";
    	
    	int res = 0;
    	res = occ.update(query);
		occ.close();
    	return res == 1 ? true : false;
    }

    	public boolean delete(GuestBookDTO dto) {
    	String query = "DELETE FROM GUESTBOOK"
    			+ " WHERE G_ID = " + dto.getId() + "";

    	int res = 0;
    	res = occ.delete(query);
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
