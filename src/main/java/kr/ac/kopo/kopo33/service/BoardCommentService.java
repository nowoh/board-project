package kr.ac.kopo.kopo33.service;

import java.util.List;

import kr.ac.kopo.kopo33.domain.BoardComment;

public interface BoardCommentService {
	// C
	void create (BoardComment boardComment);
	
	// R
	List<BoardComment> selectAll (int boardNumber);
	
	// U
	void update (BoardComment boardComment);
	
	// D
	void delete (int id, int boardNumber);
}
