package kr.or.yhs.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.yhs.board.model.BoardVo;
import kr.or.yhs.board.model.PostVo;
import kr.or.yhs.board.model.ReplyVo;

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
		
		//boardVo = new BoardVo("사진게시판", "yes", "brown");
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
	
	@Test
	public void boardListYesTest(){
		/***Given***/
		dao = new BoardDao();
		String yes ="yes";

		/***When***/
		List<BoardVo> boardVo = dao.boardListYes("yes");
		/***Then***/
		logger.debug("boarListVo : {}",boardVo);

	}
	
	@Test
	public void updateBoardTest(){
		/***Given***/
		BoardVo boardVo = null;
		
		dao = new BoardDao();
		boardVo = new BoardVo(1,"자유게시판" ,"no");
		
		logger.debug("boardCnt : {}",boardVo);

		/***When***/
		int boardCnt = dao.updateBoard(boardVo);
		/***Then***/
		assertEquals(1, boardCnt);
	}
	
	@Test
	public void replyListTest(){
		/***Given***/
		dao = new BoardDao();
		
		int postnum = 4;

		/***When***/
		List<ReplyVo> replyList = dao.replyList(postnum);
		/***Then***/
		logger.debug("replyList : {}", replyList);
	}
	
	@Test
	public void insertReplyTest(){
		/***Given***/
		dao = new BoardDao();
		ReplyVo replyVo = new ReplyVo("날아오르라", "cony", 26);

		/***When***/
		int replyCnt = dao.insertReply(replyVo);
		/***Then***/
		logger.debug("replyCnt : {}", replyCnt);

	}
	
}
