package com.web.project7.account.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountService {

	@Autowired
	AccountDAO dao;
	
	public boolean join(AccountDTO dto) {
		boolean result = dao.createAccount(dto);
		return result;
	}
	
	public boolean login(AccountDTO dto) {
		AccountDTO data = dao.selectAccount(dto.getUsername());
		if(data != null) {
			dto.setId(data.getId());
			dto.setPassword("");
			dto.setEmail(data.getEmail());
			dto.setLoginDate(data.getLoginDate());
			dto.setJoinDate(data.getJoinDate());
			return true;
		}
		return false;
	}

}