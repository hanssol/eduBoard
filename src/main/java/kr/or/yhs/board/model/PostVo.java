package kr.or.yhs.board.model;

import java.util.Date;

public class PostVo {
	private int postnum;		//	게시글번호
	private Date postdt;		//	작성일시
	private String post_title;	//	제목
	private String p_content;	//	내용
	private int boardnum;		//	게시판번호
	private String userid;		//	작성자
	private String postnum2;	//	부모게시글
	
	
	@Override
	public String toString() {
		return "PostVo [postnum=" + postnum + ", postdt=" + postdt
				+ ", post_title=" + post_title + ", p_content=" + p_content
				+ ", boardnum=" + boardnum + ", userid=" + userid
				+ ", postnum2=" + postnum2 + "]";
	}
	
	public PostVo(){
		
	}
	
	public PostVo(int postnum, String post_title, String p_content,
			String userid) {
		super();
		this.postnum = postnum;
		this.post_title = post_title;
		this.p_content = p_content;
		this.userid = userid;
	}



	public int getPostnum() {
		return postnum;
	}
	public void setPostnum(int postnum) {
		this.postnum = postnum;
	}
	public Date getPostdt() {
		return postdt;
	}
	public void setPostdt(Date postdt) {
		this.postdt = postdt;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public int getBoardnum() {
		return boardnum;
	}
	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPostnum2() {
		return postnum2;
	}
	public void setPostnum2(String postnum2) {
		this.postnum2 = postnum2;
	}
	

	
}
