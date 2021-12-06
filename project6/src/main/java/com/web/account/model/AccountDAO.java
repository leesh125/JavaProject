package com.web.account.model;

import com.jspweb.dbconn.*;
import java.sql.*;

public class AccountDAO {
    OracleCloudConnect occ = null;

    public AccountDAO() {
        this.occ = new OracleCloudConnect(true);
    }

    public int createAccount(AccountDTO dto) {
        int res = 0;
    	String q = "INSERT INTO ACCOUNTS VALUES("
        		+ "ACCOUNTS_SEQ.NEXTVAL, ?, ?)";
        PreparedStatement st = occ.getPstat(q);  
        try {
			st.setString(1, dto.getUsername());
			st.setString(2, dto.getPassword());
			res = occ.insert(st);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        return res;
    }

    public AccountDTO findAccount(String username) {
    	AccountDTO res = null;

    	String query = "SELECT * FROM ACCOUNTS"
    			+ " WHERE USERNAME = ?";
    	PreparedStatement st = occ.getPstat(query);
    	try {
    		st.setString(1, username);
    		ResultSet rs = occ.select(st);
			if(rs.next()) {
				res = new AccountDTO();
				res.setId(rs.getInt("ID"));
				res.setUsername(rs.getString("USERNAME"));
				res.setPassword(rs.getString("PASSWORD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

    	return res;
    }
    
    public AccountDTO findAccount(int id) {
    	AccountDTO res = null;

    	String query = "SELECT * FROM ACCOUNTS"
    			+ " WHERE ID = ?";
    	
    	PreparedStatement st = occ.getPstat(query);
    	try {
    		st.setInt(1, id);
    		ResultSet rs = occ.select(st);
			if(rs.next()) {
				res = new AccountDTO();
				res.setId(rs.getInt("ID"));
				res.setUsername(rs.getString("USERNAME"));
				res.setPassword(rs.getString("PASSWORD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

    	return res;
    }
    public int countAccount(AccountDTO dto) {
    	int res = 0;
    	
    	String query = "SELECT COUNT(*) FROM " + DB
    			+ " WHERE USERNAME = " + dto.getUsername();
    	
    	ResultSet rs = occ.select(query);
    	try {
			if(rs.next()) {
				res = rs.getInt(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return res;
    }
    
    // 데이터 수정
    public int updateAccount(AccountDTO dto) {
    	int res = 0;
    	
    	String query = "UPDATE " + DB + " SET"
    			+ " PASSWORD = '" + dto.getPassword() + "',"
    			+ " EMAIL = '" + dto.getEmail() + "',"
    			+ " LOGIN_DATE = TO_DATE('" + dto.getLoginDate() + "', 'YYYY-MM-DD'),"
    			+ " WHERE ID = " + dto.getId();
    	res = occ.update(query);
    	
    	return res;
    }
    
    // 로그인 일자를 현재 일자로 수정
    public int updateLoginDate(AccountDTO dto) {
		int res = 0;
		
		String query = "UPDATE " + DB + " SET"
				+ " LOGIN_DATE = SYSDATE"
				+ " WHERE USERNAME = " + dto.getUsername();
		res = occ.update(query);
		
		return res;
	}
    
    // 데이터 삭제
    public int removeAccount(AccountDTO dto) {
    	String query = "DELETE FROM " + DB
    			+ " WHERE USERNAME = '" + dto.getUsername() + "'"
    			+ " AND ID = " + dto.getId();
    	int res = occ.delete(query);
    	
    	return res;
    }
    public int removeAccount(AccountDTO dto) {
    	int res = 0;

    	String query = "DELETE FROM ACCOUNTS"
    			+ " WHERE USERNAME = '" + dto.getUsername() + "'"
    			+ " AND ID = " + dto.getId();
    	res = occ.delete(query);

    	return res;
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