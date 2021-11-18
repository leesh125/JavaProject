package com.web.board.model;

import java.util.Date;

public class BoardDTO {
	private int board_num;
	private String board_writer;
	private String board_title;
	private String board_content;
	private Date date;
	
	
	public BoardDTO() {

	}
	
	public BoardDTO(String board_writer, String board_title, String board_content) {
		this.board_writer = board_writer;
		this.board_title = board_title;
		this.board_content = board_content;
	}
	public BoardDTO(int board_num, String board_writer, String board_title, String board_content) {
		this.board_num = board_num;
		this.board_writer = board_writer;
		this.board_title = board_title;
		this.board_content = board_content;
	}
	
	public BoardDTO(int board_num, String board_writer, String board_title, String board_content, Date date) {
		this.board_num = board_num;
		this.board_writer = board_writer;
		this.board_title = board_title;
		this.board_content = board_content;
		this.date = date;
	}

	public void setNum(String num) {
	  	this.board_num = Integer.parseInt(num);
    }

	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
