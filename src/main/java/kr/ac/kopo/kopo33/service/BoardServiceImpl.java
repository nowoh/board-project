package kr.ac.kopo.kopo33.service;

import java.util.List;

import kr.ac.kopo.kopo33.dao.BoardDao;
import kr.ac.kopo.kopo33.dao.BoardDaoImpl;
import kr.ac.kopo.kopo33.domain.Board;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao boardDao = new BoardDaoImpl();

	@Override
	public void create(Board board) {
		boardDao.create(board);
		
	}

	@Override
	public Board selectOne(int id) {
		return boardDao.selectOne(id);
	}

	@Override
	public List<Board> selectAll() {
		return boardDao.selectAll();
	}

	@Override
	public void update(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Board board) {
		// TODO Auto-generated method stub
		
	}

}
