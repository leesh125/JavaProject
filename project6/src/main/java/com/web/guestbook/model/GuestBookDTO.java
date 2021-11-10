package com.web.guestbook.model;

import java.util.Date;

public class GuestBookDTO {
	private int id;
	private String ipaddr;
	private String context="";
	private Date date;
	
	public GuestBookDTO() {

	}

	public GuestBookDTO(String ipaddr, String context) {
		this.ipaddr = ipaddr;
		this.context = context;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getIpaddr() {
		return ipaddr;
	}
	
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	
	public String getContext() {
		return context;
	}
	
	public void setContext(String context) {
		this.context = context;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
}
