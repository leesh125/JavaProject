package com.web.board.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.web.dbconn.OracleCloudConnect;

public class BoardDAO {

	OracleCloudConnect occ = null;

	public BoardDAO() {
		this.occ = new OracleCloudConnect(true);
	}

	public List<BoardDTO> select() {
		List<BoardDTO> datas = new ArrayList<BoardDTO>();
		String query = "SELECT * FROM BOARDS ORDER BY CREATE_DATE, ID";
		try {
			PreparedStatement st = occ.getPstat(query);
			ResultSet rs = occ.select(st);
			while(rs.next()) {
				BoardDTO data = new BoardDTO();
				data.setResultSet(rs);
				datas.add(data);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return datas;
	}
	
	public List<BoardDTO> selectCategoryType(int type) {
		List<BoardDTO> datas = new ArrayList<BoardDTO>();
		String query = "SELECT * FROM BOARDS"
				+ " WHERE CID = ?"
				+ " ORDER BY CREATE_DATE, ID";
		try {
			PreparedStatement st = occ.getPstat(query);
			st.setInt(1, type);
			ResultSet rs = occ.select(st);
			while(rs.next()) {
				BoardDTO data = new BoardDTO();
				data.setResultSet(rs);
				datas.add(data);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return datas;
	}
	
	public List<BoardCategoryDTO> selectCategory() {
		List<BoardCategoryDTO> datas = null;
		String query = "SELECT * FROM BOARDS_CAT";
		PreparedStatement ps = occ.getPstat(query);
		try {
			ResultSet rs = ps.executeQuery();
			datas = new ArrayList<BoardCategoryDTO>();
			while(rs.next()) {
				BoardCategoryDTO data = new BoardCategoryDTO();
				data.setId(rs.getInt("ID"));
				data.setName(rs.getString("NAME"));
				data.setDisabled(rs.getString("DISABLED").charAt(0));
				datas.add(data);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return datas;
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