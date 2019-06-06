package kr.or.yhs.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.yhs.board.model.BoardVo;
import kr.or.yhs.board.service.BoardService;
import kr.or.yhs.board.service.IBoardService;

/**
 * Servlet implementation class LeftListController
 */
public class LeftListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	IBoardService boardService;
	
	
   
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
