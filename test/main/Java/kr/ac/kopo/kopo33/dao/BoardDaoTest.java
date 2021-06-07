package kr.ac.kopo.kopo33.dao;

import kr.ac.kopo.kopo33.domain.Board;

public class BoardDaoTest {
		public static void main(String[] args) {
			Board board = new Board();
			board.setId(1);
			board.setTitle("abcd");
			
			BoardDao boardDao = new BoardDaoImpl();
			boardDao.create(null);
		}
}
