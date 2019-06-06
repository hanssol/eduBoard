package kr.or.yhs.board.service;

import java.util.List;
import java.util.Map;

import kr.or.yhs.board.model.BoardVo;
import kr.or.yhs.board.model.PostVo;
import kr.or.yhs.paging.model.PageVo;

public interface IBoardService {
	int insertPost(PostVo postVo);
	
	List<PostVo> postList();
	
	int insertBoard(BoardVo boardVo);
	
	PostVo postInfo(int postnum);
	
	Map<String, Object> userPagingList(PageVo pageVo);
	
	List<BoardVo> boardList();
}
