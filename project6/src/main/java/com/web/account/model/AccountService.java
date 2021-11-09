package com.web.account.model;

public class AccountService {
	private AccountDTO dto;
	
	public AccountService(AccountDTO dto) {
		this.dto = dto;
	}
	
	public boolean isVaild() {
		if(this.dto == null) {
			return false;
		}
		
		if(!usernameValid() || !passwordValid()) {
			return false;
		}
		return true;
	}
	
	private boolean usernameValid() {
		boolean isUsernameValid = true;
		if(this.dto.getUsername().length() >= 4 
				&& this.dto.getUsername().length() <= 16) {
			for(int i = 0; i < this.dto.getUsername().length(); i++) {
            	System.out.println(isUsernameValid);
                if(this.dto.getUsername().charAt(i) >= 'a' && this.dto.getUsername().charAt(i) <= 'z') {
                	isUsernameValid = true;
                } else if(this.dto.getUsername().charAt(i) >= '0' && this.dto.getUsername().charAt(i) <= '9') {
                	isUsernameValid = true;
                } else if(this.dto.getUsername().charAt(i) == '_') {
                	isUsernameValid = true;
                } else {
                	isUsernameValid = false;
                }
                System.out.println(isUsernameValid + "|" + this.dto.getUsername().charAt(i));
                if(!isUsernameValid) {
                	break;
                }
            }
			return isUsernameValid;
        } 
		return false;
	}
	
	private boolean passwordValid() {
		boolean isPasswordValid = true;
		if(this.dto.getPassword().length() >= 4 
				&& this.dto.getUsername().length() <= 16) {
			for(int i = 0; i < this.dto.getPassword().length(); i++) {
            	System.out.println(isPasswordValid);
                if(this.dto.getPassword().charAt(i) >= 'a' && this.dto.getPassword().charAt(i) <= 'z') {
                	isPasswordValid = true;
                } else if(this.dto.getPassword().charAt(i) >= '0' && this.dto.getPassword().charAt(i) <= '9') {
                	isPasswordValid = true;
                } else if(this.dto.getPassword().charAt(i) == '_') {
                	isPasswordValid = true;
                } else {
                	isPasswordValid = false;
                }
                System.out.println(isPasswordValid + "|" + this.dto.getPassword().charAt(i));
                if(!isPasswordValid) {
                	break;
                }
	        } 
				return isPasswordValid;
	    } 
		return false;
	}
}
