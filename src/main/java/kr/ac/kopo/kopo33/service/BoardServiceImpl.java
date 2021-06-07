package kr.ac.kopo.kopo33.service;

import java.util.List;

import kr.ac.kopo.kopo33.dao.BoardDao;
import kr.ac.kopo.kopo33.dao.BoardDaoImpl;
import kr.ac.kopo.kopo33.domain.Board;

public class BoardServiceImpl implements BoardService {
	
	private BoardDao boardDao = new BoardDaoImpl();

	@Override
	public void create(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Board selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> selectAll() {
		// TODO Auto-generated method stub
		return null;
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
