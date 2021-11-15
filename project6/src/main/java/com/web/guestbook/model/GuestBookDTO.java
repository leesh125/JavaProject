package com.web.guestbook.model;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public void setId(String id) {
    	this.id = Integer.parseInt(id);
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
	
	public void setResultSet(ResultSet res) throws SQLException {
    	this.id = res.getInt("G_ID");
    	this.context = res.getString("G_CONTEXT");
    	this.ipaddr = res.getString("G_IPADDR");
    	this.date = res.getDate("G_DATE");
    }
}
