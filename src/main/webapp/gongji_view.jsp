<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo33.service.*" %>
<%@ page import="kr.ac.kopo.kopo33.domain.*" %>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.util.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>View_MVC</title>
<% 
    Integer id = Integer.parseInt(request.getParameter("id")); 
	//String board_title = request.getParameter("board_title");
%>
<style>
    html {
      background-color: #F0F0F0;
      font-family: 'Jua', 'Playfair Display', sans-serif, serif;
    }

    table,
    tr,
    td {
      border: 1px solid black;
      border-collapse: collapse;
    }

    td {
      padding: 4px;
    }
    
    td#content {
      vertical-align : top;
    }
    
    .comment {
      border: 0px;
      border-top: 1px solid lightgrey;
      border-bottom: 1px solid lightgrey;
      margin: 7px 0px 0px;
      word-break: break-all;
    }
    
    #commentDate {
      color: grey;
    }

    .table {
      position: absolute;
      top: 40%;
      left: 50%;
      transform: translate(-50%, -50%);
    }

    .btt {
      float: right;
      margin: 5px 1px;
      border: 1px solid black;
      font-size: medium;
      font-family: 'Jua', 'Playfair Display', sans-serif, serif;
      background-color: transparent;
    }

    .btt:hover {
      cursor: pointer;
      background-color: #9cbed4;
    }

    .title {
      text-align: center;
      width: 50px;
    }
    
    #comment {
      overflow-y: scroll;
      resize: none;
    }
    
    .input {
      border: 1px solid black;
      background-color: transparent;
      font-size: medium;
      font-family: 'Jua', 'Playfair Display', sans-serif, serif;
    }
    
    .commentBtt {
      font-size: 12px;
    }
    
    
  </style>
</head>
<body>
  <%
    //게시글 하나 보기
  	BoardItemService boardItemService = new BoardItemServiceImpl();
	BoardItem boardItems = boardItemService.selectOne(id);
	boardItemService.updateViewcountPlus(id);
	//작성된 댓글 보기
	BoardCommentService boardCommentService = new BoardCommentServiceImpl();
	List<BoardComment> boardComments = boardCommentService.selectAll(id);
	
	
    try { 
  %>
  <span class="table">
    <span>
      <table 1px black border=1>
        <tr>
          <td class="title">번호</td>
          <td width=500 colspan="3"><%=id%></td>
        </tr>
        <tr>
          <td class="title">제목</td>
          <td colspan="3"><%=boardItems.getTitle()%></td>
        </tr>
        <tr>
          <td class="title">일자</td>
          <td><%=boardItems.getDate()%></td>
          <td class="title">조회수</td>
          <td width=100><%=boardItems.getViewcount()%></td>
        </tr>
        <tr>
          <td class="title">작성자</td>
          <td colspan="3"><%=boardItems.getWriter()%></td>
        </tr>
        <tr>
          <td class="title" height="230px">내용</td>
          <td id="content" colspan="3"><%=boardItems.getContent()%></td>
        </tr>
      </table>     
      <button type=button class="btt" value="수정" onclick="location.href='gongji_update.jsp?id=<%=id%>'">수정 <i class="fas fa-tools"></i></button>
      <button type=button class="btt" value="목록" onclick="location.href='gongji_list.jsp'">홈 <i class="fas fa-home"></i></button>
    </span>
      <form method="post" name="form" action="comment_write.jsp?id=<%=id%>">
    	<table 1px black border=1>
    	  <tr>
    	    <td class="title">작성자</td>
			<td width=500>
			  <input type="text" class="input" name="writer" maxlength="10" value="" style="width:430px;" required>
			</td>
    	  </tr>
    	  <tr>
    	    <td class="title">댓글</td>
    		<td>
    		  <textarea class="input" id="comment" name="comment" rows="3" cols="60" required></textarea>
    		</td>
          </tr>
    	</table>
    	<button class="btt" value="등록">댓글 작성 <i class="fas fa-pen"></i></button>
  	  </form><br>
<%
	  for (BoardComment boardComment : boardComments) {
%>
	<table class="comment">
	  <tr class="comment">
	    <td class="comment" width=50><b><%=boardComment.getWriter() %></b></td>
	    <td class="comment" width=410><%=boardComment.getComment() %></td>
	    <td class="comment" id="commentDate"><%=boardComment.getDate() %></td>
	  </tr>
	</table>
	<div>
	  <button class="btt commentBtt" value="수정" onclick="location.href='comment_update.jsp?id=<%=boardComment.getId()%>&boardNumber=<%=boardComment.getBoardNumber()%>'">
	    <i class="fas fa-tools"></i>
	  </button>
	  <button class="btt commentBtt" value="삭제" onclick="location.href='comment_delete.jsp?id=<%=boardComment.getId()%>&boardNumber=<%=boardComment.getBoardNumber()%>'">
	    <i class="fas fa-eraser"></i>
	  </button>
	</div>
	<br>
<%
	  }
%>
  </span>
<%
    } catch (Exception e) { 
      out.println(e); 
    } 
%>
<script>
  function modify(id, boardNumber, comment) {
    commentPrompt = prompt("내용 수정", comment);
    if (commentPrompt == true) {
    	alert("게시물이 수정되었습니다.");
    	document.location.href='gongji_view.jsp?id=${comment}';
    }
  }
</script>
</body>
</html>