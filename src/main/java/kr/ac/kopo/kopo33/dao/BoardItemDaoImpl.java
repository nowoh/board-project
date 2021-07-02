package kr.ac.kopo.kopo33.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.kopo33.domain.BoardItem;

public class BoardItemDaoImpl implements BoardItemDao {
	private static String url = "jdbc:mysql://192.168.23.95:3306/kopo33";
	private static String username = "root";
	private static String password = "kopo33";
	
	
	@Override
	public void create(BoardItem boardItem) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);                  
			PreparedStatement ppst = conn.prepareStatement("insert into gongji (title, date, content, writer) "
					+ "values(?, date(now()), ?, ?);");
			
			ppst.setString(1, boardItem.getTitle());
			ppst.setString(2, boardItem.getContent());
			ppst.setString(3, boardItem.getWriter());
			
			ppst.executeUpdate();
			
			ppst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public BoardItem selectOne(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			BoardItem boardItem = new BoardItem();
			Connection conn = DriverManager.getConnection(url, username, password);   
			Statement stmt = conn.createStatement();
			String queryText = String.format(
								"select * from gongji where id = " + id + ";");
			ResultSet rset = stmt.executeQuery(queryText);
			
			while (rset.next()) {
				boardItem.setId(rset.getInt(1));
				boardItem.setTitle(rset.getString(2));
				boardItem.setDate(rset.getDate(3));
				boardItem.setViewcount(rset.getInt(5));
				boardItem.setContent(rset.getString(4));
				boardItem.setWriter(rset.getString(6));
			}
			rset.close();
			stmt.close();
			conn.close();
			
			return boardItem;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<BoardItem> searchView(String search, String select, int startLimit) {
		try {
			List<BoardItem> boardItem = new ArrayList<BoardItem>();
			BoardItem boardItems;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);   
			Statement stmt = conn.createStatement();
			ResultSet rset = null;
			if ("제목".equals(select)) {
				rset = stmt.executeQuery("select * from gongji where title like '%" + search + "%' order by id desc limit " + startLimit + ", 10;");
			} else if ("내용".equals(select)) {
				rset = stmt.executeQuery("select * from gongji where content like '%" + search + "%' order by id desc limit " + startLimit + ", 10;");
			} else if ("작성자".equals(select)) {
				rset = stmt.executeQuery("select * from gongji where writer like '%" + search + "%' order by id desc limit " + startLimit + ", 10;");
			}
			
			
			while (rset.next()) {
				boardItems = new BoardItem();
				boardItems.setId(rset.getInt(1));
				boardItems.setTitle(rset.getString(2));
				boardItems.setDate(rset.getDate(3));
				boardItems.setViewcount(rset.getInt(5));
				boardItems.setContent(rset.getString(4));
				boardItems.setWriter(rset.getString(6));
				
				boardItem.add(boardItems);
			}
			rset.close();
			stmt.close();
			conn.close();
			
			return boardItem;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<BoardItem> selectAll(int startLimit) {
		try {
			List<BoardItem> boardItem = new ArrayList<BoardItem>();
			BoardItem boardItems;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);   
			Statement stmt = conn.createStatement();
			String queryText = String.format(
								"select * from gongji order by id desc limit " + startLimit + ", 10;");
			ResultSet rset = stmt.executeQuery(queryText);
			
			while (rset.next()) {
				boardItems = new BoardItem();
				boardItems.setId(rset.getInt(1));
				boardItems.setTitle(rset.getString(2));
				boardItems.setDate(rset.getDate(3));
				boardItems.setViewcount(rset.getInt(5));
				boardItems.setContent(rset.getString(4));
				boardItems.setWriter(rset.getString(6));
				
				boardItem.add(boardItems);
			}
			rset.close();
			stmt.close();
			conn.close();
			
			return boardItem;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(BoardItem boardItem) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);   
			PreparedStatement ppst = conn.prepareStatement(
					"update gongji set "
					+ "title = ?, content = ?"
					+ " where id = ?;");
			
			ppst.setString(1, boardItem.getTitle());
			ppst.setString(2, boardItem.getContent());
			ppst.setInt(3, boardItem.getId());
			
			ppst.executeUpdate();
			
			ppst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);   
			PreparedStatement ppst = conn.prepareStatement(
					"delete from gongji where id = " + id + ";");
			
			ppst.executeUpdate();
			
			ppst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateViewcountPlus(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);   
			Statement stmt = conn.createStatement();
			stmt.execute("update gongji set viewcount = viewcount +1 where id = " + id + ";");
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
  public void updateViewcountMinus(int id) {
	  try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection(url, username, password);   
      Statement stmt = conn.createStatement();
      stmt.execute("update gongji set viewcount = viewcount -1 where id = " + id + ";");
      stmt.close();
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

	@Override
	public List<Integer> pageCal(String pages) {
		int totalCount = 0; 	//0. 총 게시글 수
	    int totalPage = 0;  	//1. 총 페이지
	    int perPage = 10;   	//2. 페이지당 게시글 수
	    int pageCount = 10; 	//3. 한 화면에 나타낼 페이지 수
	    int Page = 1;           //4. 페이지 초기화, 페이지 시작
        int startLimit = 0;     //5. limit문 시작 번호
        int endPage = 0;        //6. 끝 페이지
        int startPage = 0;      //7. 시작 페이지
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);   
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery("select count(*) from gongji;");
			List<Integer> pagesCal = new ArrayList<Integer>();
			if (rset.next() ) {
				if (pages == null || pages.equals("")) {
					pages = "1";
				}
				Page = Integer.parseInt(pages);
				totalCount = Integer.parseInt(rset.getString(1));
				totalPage = totalCount / perPage;
				
				if (totalCount % perPage > 0) {
					totalPage++;
				}
				
				if (totalPage < Page) {
					Page = totalPage;
				}
				
				startPage = ((Page-1) / 10) * 10 + 1;
				endPage = startPage + pageCount - 1;
				
				if (endPage > totalPage) {
					endPage = totalPage;
				}
				
				startLimit = 0 + ((Page-1) * 10);
				
				pagesCal.add(totalCount);	//0
				pagesCal.add(totalPage);	//1
				pagesCal.add(perPage);		//2
				pagesCal.add(pageCount);	//3
				pagesCal.add(Page);			//4
				pagesCal.add(startLimit);	//5
				pagesCal.add(endPage);		//6
				pagesCal.add(startPage);	//7
			}
			rset.close();
			stmt.close();
			conn.close();
			return pagesCal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Integer> searchPageCal(String search, String select, String pages) {
		int totalCount = 0; 	//0. 총 게시글 수
	    int totalPage = 0;  	//1. 총 페이지
	    int perPage = 10;   	//2. 페이지당 게시글 수
	    int pageCount = 10; 	//3. 한 화면에 나타낼 페이지 수
	    int Page = 1;           //4. 페이지 초기화, 페이지 시작
      int startLimit = 0;     //5. limit문 시작 번호
      int endPage = 0;        //6. 끝 페이지
      int startPage = 0;      //7. 시작 페이지
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);   
			Statement stmt = conn.createStatement();
			List<Integer> pagesCal = new ArrayList<Integer>();
			ResultSet rset  = null;
			if ("제목".equals(select)) {
				rset = stmt.executeQuery("select count(*) from gongji where title like '%" + search + "%';");
			} else if ("내용".equals(select)) {
				rset = stmt.executeQuery("select count(*) from gongji where content like '%" + search + "%';");
			} else if ("작성자".equals(select)) {
				rset = stmt.executeQuery("select count(*) from gongji where writer like '%" + search + "%';");
			}
			
			
			if (rset.next() ) {
				if (pages == null || pages.equals("")) {
					pages = "1";
				}
				Page = Integer.parseInt(pages);
				totalCount = Integer.parseInt(rset.getString(1));
				totalPage = totalCount / perPage;
				
				if (totalCount % perPage > 0) {
					totalPage++;
				}
				
				if (totalPage < Page) {
					Page = totalPage;
				}
				
				startPage = ((Page-1) / 10) * 10 + 1;
				endPage = startPage + pageCount - 1;
				
				if (endPage > totalPage) {
					endPage = totalPage;
				}
				
				startLimit = 0 + ((Page-1) * 10);
				
				pagesCal.add(totalCount);	//0
				pagesCal.add(totalPage);	//1
				pagesCal.add(perPage);		//2
				pagesCal.add(pageCount);	//3
				pagesCal.add(Page);			//4
				pagesCal.add(startLimit);	//5
				pagesCal.add(endPage);		//6
				pagesCal.add(startPage);	//7
			}
			rset.close();
			stmt.close();
			conn.close();
			return pagesCal;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

  
}
