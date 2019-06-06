package kr.or.yhs.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.yhs.board.model.PostVo;
import kr.or.yhs.board.service.BoardService;
import kr.or.yhs.board.service.IBoardService;
import kr.or.yhs.paging.model.PageVo;

/**
 * Servlet implementation class BoardFree
 */
@WebServlet("/boardFree")
public class BoardFreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private IBoardService boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageString = request.getParameter("page");
		String pageSizeString = request.getParameter("pageSize");
		
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int pageSize =  pageSizeString == null ? 5 : Integer.parseInt(pageSizeString);
		
		PageVo pageVo = new PageVo(page,pageSize);
		// 사용자 페이징 리스트 조회
		Map<String, Object> resultMap = boardService.userPagingList(pageVo);
		List<PostVo> userList = (List<PostVo>) resultMap.get("postList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		// userList객체를 userList.jsp에서 참고할 수 있도록 request객체에 속성을 넣어준다
		request.setAttribute("boardFreeList", boardService.postList());
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);
		
		// userList객체를 이용하여 사용자 화면을 생성하는 jsp
		request.getRequestDispatcher("/board/boardFree.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
