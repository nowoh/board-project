package kr.ac.kopo.kopo33.service;

import java.util.List;

import kr.ac.kopo.kopo33.dao.BoardItemDao;
import kr.ac.kopo.kopo33.dao.BoardItemDaoImpl;
import kr.ac.kopo.kopo33.domain.BoardItem;

public class BoardItemServiceImpl implements BoardItemService{

	private BoardItemDao boardItemDao = new BoardItemDaoImpl();
	
	@Override
	public void create(BoardItem boardItem) {
		boardItemDao.create(boardItem);
	}

	@Override
	public BoardItem selectOne(int id) {
		return boardItemDao.selectOne(id);
	}

	@Override
	public List<BoardItem> selectAll(int startLimit) {
		return boardItemDao.selectAll(startLimit);
	}

	@Override
	public void update(BoardItem boardItem) {
		boardItemDao.update(boardItem);
	}

	@Override
	public void delete(int id) {
		boardItemDao.delete(id);
	}

	@Override
	public List<BoardItem> searchView(String search, String select, int startLimit) {
		return boardItemDao.searchView(search, select, startLimit);
	}

	@Override
	public void updateViewcountPlus(int id) {
		boardItemDao.updateViewcountPlus(id);
	}
	
	@Override
  public void updateViewcountMinus(int id) {
	  boardItemDao.updateViewcountMinus(id);
  }

	@Override
	public List<Integer> pageCal(String pages) {
		return boardItemDao.pageCal(pages);
	}

	@Override
	public List<Integer> searchPageCal(String search, String select, String pages) {
		return boardItemDao.searchPageCal(search, select, pages);
	}

  

}
