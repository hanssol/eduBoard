package kr.or.yhs.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.yhs.board.model.BoardVo;
import kr.or.yhs.board.model.PostVo;
import kr.or.yhs.board.service.BoardService;
import kr.or.yhs.board.service.IBoardService;
import kr.or.yhs.paging.model.PageVo;

/**
 * Servlet implementation class BoardFree
 */
@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardnum = request.getParameter("boardnum");
		
		int boardnumStr = Integer.parseInt(boardnum);
//		BoardVo boardVo = boardService.boardInfo(boardnumStr);
		
		
		
		
		String pageString = request.getParameter("page");
		String pageSizeString = request.getParameter("pageSize");
		
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int pageSize =  pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
		
		PageVo pageVo = new PageVo(page,pageSize,boardnumStr);
		
		Map<String, Object> resultMap = boardService.boardPostPagingList(pageVo);
		List<PostVo> postList = (List<PostVo>) resultMap.get("postList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		request.setAttribute("postList", postList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);
		
		request.getRequestDispatcher("/board/boardFree.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
