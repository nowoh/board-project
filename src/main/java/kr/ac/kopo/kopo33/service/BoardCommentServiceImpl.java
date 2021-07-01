package kr.ac.kopo.kopo33.service;

import java.util.List;

import kr.ac.kopo.kopo33.dao.BoardCommentDao;
import kr.ac.kopo.kopo33.dao.BoardCommentDaoImpl;
import kr.ac.kopo.kopo33.domain.BoardComment;

public class BoardCommentServiceImpl implements BoardCommentService {

	private BoardCommentDao boardCommentDao = new BoardCommentDaoImpl();
	
	@Override
	public void create(BoardComment boardComment) {
		boardCommentDao.create(boardComment);
		
	}

	@Override
	public List<BoardComment> selectAll(int boardNumber) {
		return boardCommentDao.selectAll(boardNumber);
	}

	@Override
	public void update(BoardComment boardComment) {
		boardCommentDao.update(boardComment);
		
	}

	@Override
	public void delete(int id, int boardNumber) {
		boardCommentDao.delete(id, boardNumber);
		
	}

}
