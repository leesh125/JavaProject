package com.web.dbconn;

import java.io.*;
import java.sql.*;
import java.util.Properties;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;

public class OracleCloudConnect {
	private final String DB_URL = "jdbc:oracle:thin:@mydb_medium?TNS_ADMIN=C:/Program Files/Wallet_myDB";
	private String url = "";
	private Properties info = new Properties();
	private OracleConnection conn = null;
	private PreparedStatement pstat = null;

	public OracleCloudConnect() {
		this(false);
	}
	
	public OracleCloudConnect(boolean wallet) {
		String userHome = System.getProperty("user.home");
		
		try {
			info.load(new FileReader(userHome + "/oracle_connection.prop"));
		} catch (FileNotFoundException e) {
			System.err.println("oracle_connection.prop 파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(wallet) {
			url = "jdbc:oracle:thin:@mydb_medium?TNS_ADMIN=C:/Program Files/Wallet_myDB";
			this.walletConnect();
		} else {
			url = "jdbc:oracle:thic:@localhost:1521:xe";
			this.connect();
		}
	}
	
	private void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.conn = (OracleConnection) DriverManager.getConnection(
					this.url,
					this.info.getProperty("user"),
					this.info.getProperty("password"));
			this.connectSetting();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void walletConnect() {
		try {
			OracleDataSource ods = new OracleDataSource();
			ods.setURL(this.url);
			ods.setConnectionProperties(this.info);
			this.conn = (OracleConnection) ods.getConnection();
			this.connectSetting();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void connectSetting() {
		try {
			this.conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet select(String query) {
		ResultSet rs = null;
		try {
			Statement stat = this.conn.createStatement();
			rs = stat.executeQuery(query);
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet select(PreparedStatement ps) {
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public PreparedStatement getPstat(String query) {
		try {
			this.pstat = this.conn.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.pstat;
	}
	
	public int insert(String query) {
		int rs = 0;
		try {
			Statement stat = this.conn.createStatement();
			rs = stat.executeUpdate(query);
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int insert(PreparedStatement ps) {
		int rs = 0;
		try {
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int update(PreparedStatement ps) {
		return this.update(ps);
	}
	
	public int update(String query) {
		return this.insert(query);
	}
	
	public int delete(String query) {
		return this.insert(query);
	}
	
	public int delete(PreparedStatement ps) {
		return this.delete(ps);
	}
	
	public void commit() {
		try {
			this.conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void rollback() {
		try {
			this.conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if(this.pstat != null) {
				this.pstat.close();
			}
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}