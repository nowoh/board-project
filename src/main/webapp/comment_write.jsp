<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo33.service.*" %>
<%@ page import="kr.ac.kopo.kopo33.domain.*" %>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.util.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Comment Write</title>
</head>
<body>
<%
//	String number = request.getParameter("")
	String writer = request.getParameter("writer");
	String comment = request.getParameter("comment");
	int boardNumber = Integer.parseInt(request.getParameter("id"));
	BoardCommentService boardCommentService = new BoardCommentServiceImpl();
	
	BoardComment boardComments = new BoardComment();
	boardComments.setWriter(writer);
	boardComments.setComment(comment);
	boardComments.setBoardNumber(boardNumber);
	boardCommentService.create(boardComments);
%>	
  <script>
    $(function() {
      alert("게시글이 등록되었습니다.");
      document.location.href="gongji_view.jsp?id=<%=boardNumber%>";
    });
  </script>
</body>
</html>