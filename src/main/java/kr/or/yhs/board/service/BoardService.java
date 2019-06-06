package kr.or.yhs.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.yhs.board.dao.BoardDao;
import kr.or.yhs.board.dao.IBoardDao;
import kr.or.yhs.board.model.BoardVo;
import kr.or.yhs.board.model.PostVo;
import kr.or.yhs.paging.model.PageVo;

public class BoardService implements IBoardService{
	IBoardDao dao;
	
	public BoardService() {
		dao = new BoardDao();
	}
	/**
	 * 
	 * Method : inserPost
	 * 작성자 : yang1
	 * 변경이력 : 
	 * @param postVo
	 * @return
	 * Method 설명 :
	 */
	@Override
	public int insertPost(PostVo postVo) {
		
		return dao.insertPost(postVo);
	}

	@Override
	public List<PostVo> postList() {
		
		return dao.postList();
	}
	@Override
	public int insertBoard(BoardVo boardVo) {
		
		return dao.insertBoard(boardVo);
	}
	@Override
	public PostVo postInfo(int postnum) {
		return dao.postInfo(postnum);
	}
	@Override
	public Map<String, Object> userPagingList(PageVo pageVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("postList", dao.postPagingList(pageVo));
		
		int postCnt = dao.postCnt();
		
		int paginationSize = (int) Math.ceil((double)postCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}
	@Override
	public List<BoardVo> boardList() {
		return dao.boardList();
	}
	
}
