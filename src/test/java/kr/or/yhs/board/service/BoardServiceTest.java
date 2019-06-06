package kr.or.yhs.board.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.yhs.board.model.BoardVo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardServiceTest {
	private IBoardService boardService;
	
	private static final Logger logger = LoggerFactory
			.getLogger(BoardServiceTest.class);
	
	@Test
	public void boardListTest() {
		/***Given***/
		boardService = new BoardService();

		/***When***/
		List<BoardVo> boardList = boardService.boardList();
		/***Then***/
		logger.debug("boardList : {}", boardList);
	}

}
