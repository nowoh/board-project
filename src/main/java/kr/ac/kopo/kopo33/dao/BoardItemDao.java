package kr.ac.kopo.kopo33.dao;
import java.util.List;

import kr.ac.kopo.kopo33.domain.BoardItem;

public interface BoardItemDao {
	//	C
	void create(BoardItem boardItem); 
	
	//	R
	BoardItem selectOne (int id);
	List<BoardItem> selectAll(int startLimit);
	List<BoardItem> searchView (String search, String select, int startLimit);
	List<Integer> pageCal(String pages);
	List<Integer> searchPageCal(String search, String select, String pages);
	
	//	U
	void update(BoardItem boardItem);
	void updateViewcountPlus(int id);
	void updateViewcountMinus(int id);
	
	//	D
	void delete(int id);
	
	
	
}
