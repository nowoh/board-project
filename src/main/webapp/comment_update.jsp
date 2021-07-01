<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo33.service.*"%>
<%@ page import="kr.ac.kopo.kopo33.domain.*"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.util.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap"	rel="stylesheet">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Comment Update</title>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
	BoardCommentService boardCommentService = new BoardCommentServiceImpl();
	BoardComment boardComment = boardCommentService.selectOne(id, boardNumber);
%>
  <script>
    beforeComment = "<%=boardComment.getComment()%>";
    var comment = prompt("내용 수정", beforeComment);
    if (comment == true) {
      alert("게시글이 수정되었습니다.");
	  document.location.href="gongji_view.jsp?id=<%=boardNumber%>";
    } else {
      document.location.href="gongji_view.jsp?id=<%=boardNumber%>";
    }
  </script>
</head>
<body>
<%
	boardComment.setComment(${comment});
	boardCommentService.update(boardComment);
%>
  <script>
	document.write(beforeComment);
  </script>
</body>
</html>