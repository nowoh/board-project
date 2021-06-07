package kr.ac.kopo.kopo33.dao;
import java.util.List;

import kr.ac.kopo.kopo33.domain.BoardItem;

public interface BoardItemDao {
	//	C
	void create(BoardItem boardItem); 
	
	//	R
	BoardItem selectOne (int id);
	List<BoardItem> selectAll();
	
	//	U
	void update(BoardItem boardItem);
	
	//	D
	void delete(BoardItem boardItem);
	
	
	
}
