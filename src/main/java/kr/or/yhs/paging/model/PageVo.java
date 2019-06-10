package kr.or.yhs.paging.model;

public class PageVo {
	private int page;		// 페이지 번호
	private int pageSize;	// 페이지당 건수
	
	private int boardnum;	// 게시판 번호

	
	public PageVo(int page, int pageSize, int boardnum) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.boardnum = boardnum;
	}

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public PageVo(int page, int pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}

	public PageVo(){
		
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
