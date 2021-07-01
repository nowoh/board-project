package kr.ac.kopo.kopo33.domain;

import java.sql.Date;

public class BoardItem {
	private int id;
	private String title;
	private Date date;
	private String content;
	private int viewcount;
	private String writer;
	private int fk_board_id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getFk_board_id() {
		return fk_board_id;
	}
	public void setFk_board_id(int fk_board_id) {
		this.fk_board_id = fk_board_id;
	}
	
}
