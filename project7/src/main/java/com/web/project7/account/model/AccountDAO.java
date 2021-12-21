package com.web.project7.account.model;

public class AccountDAO {
	private MybatisConnect mc;
	private SqlSession sess;
	
	public AccountDAO() {
		this.ms = new Mybatisconnect();
		this.sess = mc.getSession();
	}
	
	public boolean createAccount(AccountDTO dto) {
		int res = this.sess.insert("마이바티스맵퍼", dto);
		return res == 1 ? true : false;
	}
	
}
