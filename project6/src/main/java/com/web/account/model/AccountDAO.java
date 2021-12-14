package com.web.account.model;

import java.sql.*;

import org.apache.ibatis.session.SqlSession;

import com.web.dbconn.*;

public class AccountDAO {
//    private OracleCloudConnect occ = null;
    private MybatisConnect mc = null;
    private SqlSession sess = null;
    private final String Mapper = "AccountMapper";
    
    public AccountDAO() {
//        this.occ = new OracleCloudConnect(true);
        this.mc = new MybatisConnect();
        this.sess = mc.getSession();
    }
    
    // 테이블에 데이터 추가
    public int createAccount(AccountDTO dto) {
    	int res = this.sess.insert(Mapper + ".insertAccount", dto);
        return res;
//    	int res = 0;
//    	String q = "INSERT INTO ACCOUNTS VALUES("
//    			+ "ACCOUNTS_SEQ.NEXTVAL, ?, ?)";
//    	PreparedStatement st = occ.getPstat(q);
//    	try {
//			st.setString(1, dto.getUsername());
//			st.setString(2, dto.getPassword());
//			res = occ.insert(st);
//			st.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//        return res;
    }
    
    // 테이블에서 데이터 검색(계정명으로)
    public AccountDTO findAccount(String username) {
    	AccountDTO res = this.sess.selectOne(
    			Mapper + ".selectAccountUsername", username);
    	return res;
//    	AccountDTO res = null;
//    	
//    	String query = "SELECT * FROM ACCOUNTS"
//    			+ " WHERE USERNAME = ?";
//    	
//    	PreparedStatement st = occ.getPstat(query);
//    	try {
//			st.setString(1, username);
//			ResultSet rs = occ.select(st);
//			if(rs.next()) {
//				res = new AccountDTO();
//				res.setId(rs.getInt("ID"));
//				res.setUsername(rs.getString("USERNAME"));
//				res.setPassword(rs.getString("PASSWORD"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//    	
//    	return res;
    }
    
    // 테이블에서 데이터 검색(식별값으로)
    public AccountDTO findAccount(int id) {
    	AccountDTO data = this.sess.selectOne(
    			          Mapper + ".selectAccount", id);
    	return data;
    
		/*
		 * AccountDTO res = null;
		 * 
		 * String query = "SELECT * FROM ACCOUNTS" + " WHERE ID = ?";
		 * 
		 * PreparedStatement st = occ.getPstat(query); try { st.setInt(1, id); ResultSet
		 * rs = occ.select(st); if(rs.next()) { res = new AccountDTO();
		 * res.setId(rs.getInt("ID")); res.setUsername(rs.getString("USERNAME"));
		 * res.setPassword(rs.getString("PASSWORD")); } } catch (SQLException e) {
		 * e.printStackTrace(); }
		 * 
		 * return res;
		 */
    }
    
    public int countAccount(AccountDTO dto) {
    	int res = this.sess.selectOne(
    			Mapper + ".selectAccountCount", dto.getUsername());    	
    	return res;
//    	int res = 0;
//    	
//    	String query = "SELECT COUNT(*) FROM " + DB
//    			+ " WHERE USERNAME = ?";
//    	PreparedStatement st = occ.getPstat(query);
//    	try {
//			st.setString(1, dto.getUsername());
//			ResultSet rs = occ.select(st);
//			if(rs.next()) {
//				res = rs.getInt(1);
//			}
//			rs.close();
//			st.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//    	
//    	return res;
    }
    
    // 데이터 수정
    public int updateAccount(AccountDTO dto) {
    	int res = this.sess.update(Mapper + ".updateAccount", dto);
    	return res;
//    	int res = 0;
//    	
//    	String query = "UPDATE " + DB + " SET"
//    			+ " PASSWORD = '" + dto.getPassword() + "',"
//    			+ " EMAIL = '" + dto.getEmail() + "',"
//    			+ " LOGIN_DATE = TO_DATE('" + dto.getLoginDate() + "', 'YYYY-MM-DD'),"
//    			+ " WHERE ID = " + dto.getId();
//    	res = occ.update(query);
//    	
//    	return res;
    }
    
    // 로그인 일자를 현재 일자로 수정
    public int updateLoginDate(AccountDTO dto) {
    	int res = this.sess.update(Mapper + ".updateLoginDate", dto);
		return res;
//		int res = 0;
//		
//		String query = "UPDATE " + DB + " SET"
//				+ " LOGIN_DATE = SYSDATE"
//				+ " WHERE USERNAME = " + dto.getUsername();
//		res = occ.update(query);
//		
//		return res;
	}
    
    // 데이터 삭제
    public int removeAccount(AccountDTO dto) {
    	int res = this.sess.delete(Mapper + ".deleteAccount", dto);
    	return res;
//    	String query = "DELETE FROM " + DB
//    			+ " WHERE USERNAME = '" + dto.getUsername() + "'"
//    			+ " AND ID = " + dto.getId();
//    	int res = occ.delete(query);
//    	
//    	return res;
    }
    
    public void commit() {
//    	occ.commit();
    	mc.commit();
    }
    
    public void rollback() {
    	mc.rollback();
    }
    
    public void close() {
    	mc.close();
    }

}