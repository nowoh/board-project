<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="kr.ac.kopo.kopo33.service.*"%>
<%@ page import="kr.ac.kopo.kopo33.dao.*"%>
<%@ page import="kr.ac.kopo.kopo33.domain.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>list</title>
<% 
	BoardService boardService = new BoardServiceImpl();
	Board boards = boardService.selectOne(1);
	String title = boards.getTitle();
	int fk_board_id = boards.getId();
%>

<frameset rows="100, *" frameborder="1" border="2">
	<frame src="board_list.jsp"></frame>
	<frame
		src="gongji_list.jsp?board_title=<%=title%>&fk_board_id=<%=fk_board_id%>"
		name=main></frame>
</frameset>
</head>
<body>

</body>
</html>