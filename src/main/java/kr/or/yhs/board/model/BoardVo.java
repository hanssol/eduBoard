package kr.or.yhs.board.model;

import java.util.Date;

public class BoardVo {
	private int boardnum;		// 게시판 번호
	private String boardname;	// 게시판 이름
	private String use_yn;		// 게시판 사용여부
	private Date reg_dt;		// 게시판 생성일
	private String userid;		// 게시판 생성자
	
	
	
	@Override
	public String toString() {
		return "BoardVo [boardnum=" + boardnum + ", boardname=" + boardname
				+ ", use_yn=" + use_yn + ", reg_dt=" + reg_dt + ", userid="
				+ userid + "]";
	}

	public BoardVo(){
		
	}
	
	public BoardVo(String boardname, String use_yn, String userid) {
		super();
		this.boardname = boardname;
		this.use_yn = use_yn;
		this.userid = userid;
	}



	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public String getBoardname() {
		return boardname;
	}
	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
}
