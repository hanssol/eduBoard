package kr.or.yhs.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.logging.LogException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.yhs.board.model.BoardVo;
import kr.or.yhs.board.service.BoardService;
import kr.or.yhs.board.service.IBoardService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/boardManagement")
public class BoardManageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(BoardManageController.class);
	
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// userList객체를 userList.jsp에서 참고할 수 있도록 request객체에 속성을 넣어준다
		List<BoardVo> boardList = boardService.boardList();
		ServletContext sc1 = request.getServletContext();
		sc1.setAttribute("boardList", boardList);
		
		// userList객체를 이용하여 사용자 화면을 생성하는 jsp
		request.getRequestDispatcher("/board/boardManage.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		// 게시판 수정
		String boardname = request.getParameter("boardname1");
		String use_yn = request.getParameter("use_yn1");
		
		String boardnum = request.getParameter("boardnum1");
		int boardNM = Integer.parseInt(boardnum);
		
		
		BoardVo boardYN = null;
		boardYN = new BoardVo(boardNM, boardname,use_yn);
		
		int boardCnt = boardService.updateBoard(boardYN);
		
		if(boardCnt == 1){
			response.sendRedirect(request.getContextPath()+"/boardManagement");
		}
		
		String use_yn1 = "yes";
		List<BoardVo> boardListY = boardService.boardListYes(use_yn1);
		ServletContext sc = request.getServletContext();
		sc.setAttribute("boardListY", boardListY);
	}

}
