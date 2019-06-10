package kr.or.yhs.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.yhs.board.model.PostVo;
import kr.or.yhs.board.model.ReplyVo;
import kr.or.yhs.board.service.BoardService;
import kr.or.yhs.board.service.IBoardService;
import kr.or.yhs.user.service.UserService;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IBoardService boardService;
	
	
   
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postnum = request.getParameter("postnum");
		PostVo postInfo = boardService.postInfo(Integer.parseInt(postnum));
		List<ReplyVo> replyList = boardService.replyList(Integer.parseInt(postnum));
		
		request.setAttribute("postInfo", postInfo);
		request.setAttribute("replyList", replyList);
		
		request.getRequestDispatcher("/post/post.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String r_content = request.getParameter("r_content");
		String userid = request.getParameter("userid2");
		String postNM = request.getParameter("postnum2");
		int postnum = Integer.parseInt(postNM);
		String boardNM = request.getParameter("boardnum");
		int boardnum = Integer.parseInt(boardNM);
		
		ReplyVo replyVo = null;
		replyVo = new ReplyVo(r_content, userid, postnum);
		
		int replyCnt = boardService.insertReply(replyVo);
		
		if(replyCnt == 1){
			response.sendRedirect(request.getContextPath()+"/post?postnum="+postnum+"&boardnum=1"+boardnum);
		}
		
	}

}
