package com.db.conn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

public class OracleCloudConnect {
	private final String DB_URL = "jdbc:oracle:thin:@mydb_medium?TNS_ADMIN=C:/Program Files/Wallet_myDB";
	private final String USERNAME = "user1";
	private final String PASSWORD = "KHpass1234567890";
	private Properties info = new Properties();
	private OracleDataSource ods = null;
	private OracleConnection conn = null;
	private Statement stat = null;
	
	public OracleCloudConnect() throws SQLException {
		/* JDBC 사용하여 Oracle Database 연결 하기위한 과정
		 * 	1. 데이터베이스 연결 구성정보 생성
		 * 	2. 연결 구성 정보로 데이터베이스 연결
		 * 	3. Statement 생성
		 *  4. Query 전송
		 *  5. 결과 받기
		 *  6. 모든 자원 반납 -> close()
		 */
		// OracleDatabase에 접속하기 위한 설정
		this.info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, USERNAME);
		this.info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, PASSWORD);
		this.ods = new OracleDataSource();
		this.ods.setURL(DB_URL);
		this.ods.setConnectionProperties(this.info);
	}
	
	public void connection() throws SQLException {
		// OracleDatabase에 접속
		this.conn = (OracleConnection)ods.getConnection();
	}
	
	public ResultSet sendQuery(String query) throws SQLException {
		// OracleDatabase에 접속 후 Query 전송
		this.stat = this.conn.createStatement();
		return this.stat.executeQuery(query); // 실행 결과로 ResultSet을 받아온다.
	}
	
	public void close() throws SQLException {
		// 모든 작업을 완료 후에는 자원을 반납 하기위해 close();
		this.conn.close();
	}
	
	public void connectionClose() throws SQLException {
		// 모든 작업을 완료한 후에는 연결을 끊기 위해 close();
		this.conn.close();
	}
	
	public static void main(String[] args) {
		
		try {
			OracleCloudConnect occ = new OracleCloudConnect();
			
			occ.connection();
			
			ResultSet res = occ.sendQuery(
					"SELECT EMPLOYEE_ID, FIRST_NAME FROM EMPLOYEES");
			while(res.next()) {
				System.out.println(res.getInt(1) + " | " + res.getString(2));
			}
			res.close();
			occ.close();
			occ.connectionClose();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
