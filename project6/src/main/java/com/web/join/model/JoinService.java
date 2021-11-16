package com.web.join.model;

public class JoinService {
	JoinDTO dto = null;

	public JoinService() {}

	public JoinService(JoinDTO dto) {
		this.dto = dto;
	}

	public int isValid() {
		if(this.dto.getUsername() == null) {
			return -1;
		} else if(this.dto.getPassword() == null) {
			return -2;
		} else if(this.dto.getEmail() == null) {
			return -3;
		}

		return 0;
	}

	public boolean equalPassword(String password_check) {
		return this.dto.getPassword().equals(password_check);
	}

	public boolean isDuplicated() {
		JoinDAO dao = new JoinDAO();
		JoinDTO data = dao.select(this.dto.getUsername());
		dao.close();

		if(data == null) {
			return false;	// 중복 안됨.
		}
		return true;	// 중복 됨.
	}

	public boolean createJoin() {
		JoinDAO dao = new JoinDAO();
		boolean res = dao.insert(this.dto);

		if(res) {
			dao.commit();
		} else {
			dao.rollback();
		}
		dao.close();

		return res;
	}
}