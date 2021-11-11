package com.web.bookmark.model;

public class BookMarkDTO {
	private String nickname;
	private String url;
	
	public BookMarkDTO() {
	
	}
	public BookMarkDTO(String nickname, String url) {
		this.nickname = nickname;
		this.url = url;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
