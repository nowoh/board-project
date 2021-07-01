package kr.ac.kopo.kopo33.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.kopo33.domain.BoardComment;
import kr.ac.kopo.kopo33.domain.BoardItem;

public class BoardCommentDaoImpl implements BoardCommentDao {
	private static String url = "jdbc:mysql://192.168.23.84:3306/kopo33";
	private static String username = "root";
	private static String password = "kopo33";
	
	@Override
	public void create(BoardComment boardComment) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);                  
			PreparedStatement ppst = conn.prepareStatement("insert into boardComment (writer, comment, date, boardNumber) "
					+ "values(?, ?, date(now()), ?);");
			
			ppst.setString(1, boardComment.getWriter());
			ppst.setString(2, boardComment.getComment());
			ppst.setInt(3, boardComment.getBoardNumber());
			
			ppst.executeUpdate();
			
			ppst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BoardComment> selectAll(int boardNumber) {
		try {
			List<BoardComment> boardComment = new ArrayList<BoardComment>();
			BoardComment boardComments;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);   
			Statement stmt = conn.createStatement();
			
			String queryText = String.format(
								"select * from boardComment where boardNumber = " + boardNumber + ";");
			ResultSet rset = stmt.executeQuery(queryText);
			
			while (rset.next()) {
				boardComments = new BoardComment();
				boardComments.setId(rset.getInt(1));
				boardComments.setWriter(rset.getString(2));
				boardComments.setComment(rset.getString(3));
				boardComments.setDate(rset.getDate(4));
				boardComments.setBoardNumber(rset.getInt(5));
				
				boardComment.add(boardComments);
			}
			rset.close();
			stmt.close();
			conn.close();
			
			return boardComment;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(BoardComment boardComment) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);   
			PreparedStatement ppst = conn.prepareStatement(
					"update boardComment set comment = ? where id = ? and boardNumber = ?;");
			
			ppst.setString(1, boardComment.getComment());
			ppst.setInt(2, boardComment.getId());
			ppst.setInt(3, boardComment.getBoardNumber());
			
			ppst.executeUpdate();
			
			ppst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id, int boardNumber) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);   
			PreparedStatement ppst = conn.prepareStatement(
					"delete from boardComment where id = " + id + " and boardNumber = " + boardNumber + ";");
			
			ppst.executeUpdate();
			
			ppst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
