package kr.or.yhs.board.dao;

import static org.junit.Assert.*;
import kr.or.yhs.board.model.BoardVo;
import kr.or.yhs.board.model.PostVo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardDaoTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(BoardDaoTest.class);
	
	private IBoardDao dao;

	@Test
	public void intsertPostTest() {
		/***Given***/
		dao = new BoardDao();
		PostVo postVo =null;
		
		postVo = new PostVo(1, "곰세마리", "곰 세마리가 한 집에있어","brown");

		/***When***/
		int insertCnt = dao.insertPost(postVo);
		/***Then***/
		logger.debug("insertCnt : {}",insertCnt);
		assertEquals(1, insertCnt);

	}
	
	@Test
	public void insertBoardTest(){
		/***Given***/
		dao = new BoardDao();
		BoardVo boardVo = null;
		
		boardVo = new BoardVo("사진게시판", "yes", "brown");
		/***When***/
		int insertCnt = dao.insertBoard(boardVo);
		
		/***Then***/
		logger.debug("insertCnt : {}",insertCnt);
		assertEquals(1, insertCnt);

	}
	
	@Test
	public void postInfoTest(){
		/***Given***/
		dao = new BoardDao();
		int postid = 8;
		/***When***/
		PostVo postVo = dao.postInfo(postid);
		/***Then***/
		assertEquals("brown", postVo.getUserid());
		logger.debug("postVo : {}", postVo);

	}

}
