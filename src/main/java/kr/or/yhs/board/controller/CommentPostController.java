package kr.or.yhs.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.yhs.board.model.PostVo;
import kr.or.yhs.board.service.BoardService;
import kr.or.yhs.board.service.IBoardService;

@WebServlet("/postCommentForm")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class CommentPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    IBoardService boardService;
    
    
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String postnum2 = request.getParameter("postnum2");
		String boardnum = request.getParameter("boardnum");
		
		PostVo postInfo = boardService.postInfo(Integer.parseInt(postnum2));
		
		request.setAttribute("postInfo", postInfo);
//		PostVo postInfo = boardService.postInfo(Integer.parseInt(postnum));
//		
		request.setAttribute("boardnum", boardnum);
		request.setAttribute("postnum2", postnum2);
		request.setAttribute("postInfo", postInfo);
		request.getRequestDispatcher("/post/postCommentForm.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String postNM2 = request.getParameter("postnum2"); // 부모글
		int postnum2 = Integer.parseInt(postNM2);
		String groupNM = request.getParameter("groupnum"); // 그룹번호
		int group_num = Integer.parseInt(groupNM);
		
		String post_comment = request.getParameter("smarteditor");
		String post_title = request.getParameter("post_title");
		String userId = request.getParameter("userid");
		String boarNM = request.getParameter("boardnum");
		int boardnum = Integer.parseInt(boarNM);
		
		PostVo postVo = null;
		
		postVo = new PostVo(boardnum, post_title, post_comment, userId);
		postVo.setPostnum2(postnum2);
		postVo.setGroup_num(group_num);
		
		
		int postCnt = boardService.insertPost(postVo);
		
		if(postCnt == 1){
			response.sendRedirect(request.getContextPath()+"/board?boardnum="+boardnum);
		}
	
	}

}
