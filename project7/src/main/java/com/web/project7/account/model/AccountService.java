package com.web.project7.account.model;

public class AccountService {
	
	public boolean join(AccountDTO dto) {
		AccountDAO dao = new AccountDAO();
		boolean result = dao.createAccount(dto);
		if(result) {
			dao.commit();
		} else {
			dao.rollback();
		}
		dao.close();
		
		return result;
	}
	
}
