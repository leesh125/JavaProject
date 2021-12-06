package com.web.account.model;

import java.util.regex.*;
import java.security.*;

public class AccountService {

    private AccountDTO dto;

    public AccountService(AccountDTO dto) {
        this.dto = dto;
    }

    public boolean join() {
    	if(this.dto == null) {
    		return false;
    	}

    	AccountDAO dao = new AccountDAO();
    	int res = dao.createAccount(this.dto);
    	if(res == 1) {
    		return true;
    	}
    	return false;
    }
    
    public int login() {
    	AccountDAO dao = new AccountDAO();
    	AccountDTO data = null;

    	// 계정 존재 유무 확인
    	if(isExisted()) {
    		if(checkPassword()) {
    			// 로그인 시간 업데이트
    			dao.updateLoginDate(this.dto);

    			// 계정 정보 불러오기
    			data = dao.findAccount(this.dto.getUsername());

    			// 계정 정보를 DTO 에 담기
    			dto.setId(data.getId());
    			dto.setPassword(null);
    			dto.setEmail(data.getEmail());
    			dto.setJoinDate(data.getJoinDate());
    			dto.setLoginDate(data.getLoginDate());

    			dao.commit();
    			dao.close();
    			return 0;
    		}
    		return -2;
    	}
    	return -1;
    }

    private boolean isExisted() {
    	AccountDAO dao = new AccountDAO();
    	int res = dao.countAccount(this.dto);
    	dao.close();

    	return res == 1 ? true : false;
    }

    private boolean checkPassword() {
    	AccountDAO dao = new AccountDAO();
    	AccountDTO data = dao.findAccount(dto.getUsername());
    	dao.close();

    	String dbasePass = data.getPassword();
    	String inputPass = this.dto.getPassword();

    	return dbasePass.equals(inputPass);
    }
    
    // 회원정보 변경
    public boolean change() {

    	return false;
    }
    
    public boolean isValid() {
    	if(this.dto == null) {
    		return false;
    	}

    	if(!usernameValid() || !passwordValid()) {
    		return false;
    	}

    	return true;
    }

    private boolean usernameValid() {
    	String regex = "^[A-Za-z0-9]{4,12}$";
    	boolean res = Pattern.matches(regex, this.dto.getUsername());
        return res;
    }

    private boolean passwordValid() {
    	String regex = "^[A-Za-z0-9]{4,12}$";
    	boolean res = Pattern.matches(regex, this.dto.getPassword());
        return res;
    }
}