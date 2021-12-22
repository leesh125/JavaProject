package com.web.project7.account.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Repository   // 스프링 컨테이너에 해당 클래스를 빈으로 등록해주는 어노테이션
public class AccountDAO {

	@Autowired
	SqlSession sess;

	public boolean createAccount(AccountDTO dto) {
		int res = this.sess.insert("AccountMapper.insertAccount", dto);
		return res == 1 ? true : false;
	}

	public AccountDTO selectAccount(String username) {
		AccountDTO data = this.sess.selectOne("AccountMapper.selectAccount", username);
		return data;
	}
}