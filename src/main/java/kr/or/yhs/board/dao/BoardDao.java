package kr.or.yhs.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ch.qos.logback.core.db.dialect.MySQLDialect;
import kr.or.yhs.board.model.BoardVo;
import kr.or.yhs.board.model.PostVo;
import kr.or.yhs.mybatis.MyBatisUtil;
import kr.or.yhs.paging.model.PageVo;

public class BoardDao implements IBoardDao{
	
	@Override
	public int insertPost(PostVo postVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int postCnt = sqlSession.insert("board.insertPost",postVo);
		sqlSession.commit();
		sqlSession.close();
		return postCnt;
	}

	@Override
	public List<PostVo> postList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<PostVo> postList = sqlSession.selectList("board.postList");
		sqlSession.close();
		return postList;
	}

	@Override
	public int insertBoard(BoardVo boardVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int boardCnt = sqlSession.insert("board.inserBoard",boardVo);
		sqlSession.commit();
		sqlSession.close();
		return boardCnt;
	}

	@Override
	public List<BoardVo> boardList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<BoardVo> boardList = sqlSession.selectList("board.boardList");
		sqlSession.close();
		return boardList;
	}

	@Override
	public PostVo postInfo(int postnum) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		PostVo postVo = sqlSession.selectOne("board.postInfo",postnum);
		sqlSession.close();
		return postVo;
	}

	@Override
	public List<PostVo> postPagingList(PageVo pageVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<PostVo> postList = sqlSession.selectList("board.postPagingList",pageVo);
		sqlSession.close();
		return postList;
	}

	@Override
	public int postCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int postCnt = (Integer)sqlSession.selectOne("board.postCnt");
		sqlSession.close();
		return postCnt;
	}

	@Override
	public BoardVo boardInfo(int boardnum) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BoardVo boardInfo = sqlSession.selectOne("board.boardInfo",boardnum);
		sqlSession.close();
		return boardInfo;
	}
	
}
