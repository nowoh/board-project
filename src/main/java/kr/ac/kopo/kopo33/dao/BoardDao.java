package kr.ac.kopo.kopo33.dao;
import java.util.List;

import kr.ac.kopo.kopo33.domain.Board;

public interface BoardDao {
	//	C
	void create(Board board); 
	
	//	R
	Board selectOne (int id);
	List<Board> selectAll();
	
	//	U
	void update(Board board);
	
	//	D
	void delete(Board board);
	
	
	
}
