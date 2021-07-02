package kr.ac.kopo.kopo33.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.kopo33.domain.Board;
import kr.ac.kopo.kopo33.domain.BoardItem;

public class BoardDaoImpl implements BoardDao {
	private static String url = "jdbc:mysql://192.168.23.95:3306/kopo33";
	private static String username = "root";
	private static String password = "kopo33";
	
	@Override
	public void create(Board board) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);                  
			PreparedStatement ppst = conn.prepareStatement("insert into boardList (title) values(?);");
			
			ppst.setString(1, board.getTitle());
			
			ppst.executeUpdate();
			
			ppst.close();
			  
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Board selectOne(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Board board = new Board();
			Connection conn = DriverManager.getConnection(url, username, password);   
			Statement stmt = conn.createStatement();
			String queryText = String.format(
								"select * from boardList where id = " + id + ";");
			ResultSet rset = stmt.executeQuery(queryText);
			
			while (rset.next()) {
				board.setId(rset.getInt(1));
				board.setTitle(rset.getString(2));
			}
			rset.close();
			stmt.close();
			conn.close();
			
			return board;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Board> selectAll() {
		try {
			List<Board> board = new ArrayList<Board>();
			Board boards;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);   
			Statement stmt = conn.createStatement();
			String queryText = String.format(
								"select * from boardList;");
			ResultSet rset = stmt.executeQuery(queryText);
			
			while (rset.next()) {
				boards = new Board();
				boards.setId(rset.getInt(1));
				boards.setTitle(rset.getString(2));
				
				board.add(boards);
			}
			rset.close();
			stmt.close();
			conn.close();
			
			return board;
		} catch (Exception e) {
			e.printStackTrace();
		}
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
