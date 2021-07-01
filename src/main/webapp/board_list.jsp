<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo33.service.*"%>
<%@ page import="kr.ac.kopo.kopo33.domain.*"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.util.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Board_List_MVC</title>
<style>
html {
	background-color: #F0F0F0;
	font-family: 'Jua', 'Playfair Display', sans-serif, serif;
}

#boardList {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	font-size: 35px;
	width: 1500px;
	text-align: center;
}

a:link {
	color: black;
	text-decoration: none;
}

a:hover {
	color: black;
	text-decoration: underline;
}

a:visited {
	color: black;
	text-decoration: none;
}

span {
	padding: 0px 10px;
}
</style>
</head>
<body>
	<div id="boardList">
		<%
	BoardService boardService = new BoardServiceImpl();
	List<Board> boards = boardService.selectAll();
	for (Board board : boards) {
%>
		<span> <a
			href="gongji_list.jsp?fk_board_id=<%=board.getId()%>&board_title=<%=board.getTitle() %>"
			target="main"><%=board.getTitle()%></a>
		</span>

		<%
	}
%>
	</div>

</body>
</html>