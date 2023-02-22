package com.gyojincompany.home.dto;

import java.sql.Timestamp;

public class BoardDto {
	
	private int bid;//게시판 번호
	private String btitle;//게시판 글 제목
	private String bcontent;//게시판 글 내용	
	private String bmid;//글쓴사람 아이디
	private String bmname;//글쓴사람 이름
	private Timestamp bdate;//글쓴 일시
	
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BoardDto(int bid, String btitle, String bcontent, String bmid, String bmname, Timestamp bdate) {
		super();
		this.bid = bid;
		this.btitle = btitle;
		this.bcontent = bcontent;		
		this.bmid = bmid;
		this.bmname = bmname;
		this.bdate = bdate;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	
	public String getBmid() {
		return bmid;
	}
	public void setBmid(String bmid) {
		this.bmid = bmid;
	}
	public String getBmname() {
		return bmname;
	}
	public void setBmname(String bmname) {
		this.bmname = bmname;
	}
	public Timestamp getBdate() {
		return bdate;
	}
	public void setBdate(Timestamp bdate) {
		this.bdate = bdate;
	}
	
	

}
