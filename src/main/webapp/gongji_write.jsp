<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo33.service.*"%>
<%@ page import="kr.ac.kopo.kopo33.domain.*"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.util.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Write_MVC</title>
<% 
	String number = request.getParameter("number");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
    BoardItemService boardItemService = new BoardItemServiceImpl();
    BoardItem boardItems;
    
%>
</head>
<body>
	<%
  try {
  	if (number == null || number == "") {
  		boardItems = new BoardItem();
  		boardItems.setTitle(title);
  	    boardItems.setContent(content);
  	    boardItems.setWriter(request.getParameter("writer"));
  		boardItemService.create(boardItems);
  	} else {
  		boardItems = boardItemService.selectOne(Integer.parseInt(number));
  		boardItems.setTitle(title);
  	    boardItems.setContent(content);
  		boardItemService.update(boardItems);
  	}
  } catch (Exception e) {
  	out.println(e);
  }
  %>
	<script>
    $(function() {
      alert("게시글이 등록되었습니다.");
      document.location.href="gongji_list.jsp";
    });
  </script>
</body>
</html>