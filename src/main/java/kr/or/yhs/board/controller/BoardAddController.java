package kr.or.yhs.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.yhs.board.model.BoardVo;
import kr.or.yhs.board.service.BoardService;
import kr.or.yhs.board.service.IBoardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class BoardAddController
 */
@WebServlet("/boardAdd")
public class BoardAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory
			.getLogger(BoardManageController.class);
	
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String boardAddname = request.getParameter("boardAddname");
		String useYNAdd = "yes";
		String userId = request.getParameter("userId");
		
		BoardVo boardAdd = null;
		boardAdd = new BoardVo(boardAddname, useYNAdd, userId);
		
		int boardAddCnt = boardService.insertBoard(boardAdd);
		
		if(boardAddCnt == 1){
			response.sendRedirect(request.getContextPath()+"/boardManagement");
		}
		
		String use_yn1 = "yes";
		List<BoardVo> boardListY = boardService.boardListYes(use_yn1);
		ServletContext sc = request.getServletContext();
		sc.setAttribute("boardListY", boardListY);
		
	}

}
