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
<title>Update_MVC</title>
<% 
  Integer id = Integer.parseInt(request.getParameter("id")); 
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

    .input {
      border: 1px solid black;
      background-color: transparent;
      font-family: 'Jua', 'Playfair Display', sans-serif, serif;
    }

    .index {
      text-align: center;
    }

    #content {
      overflow-y: scroll;
      resize: none;
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
      font-size: 20px;
      font-family: 'Jua', 'Playfair Display', sans-serif, serif;
      background-color: transparent;
    }

    .btt:hover {
      cursor: pointer;
      background-color: #9cbed4;
    }
  </style>
</head>
<body>
  <% 
    try { 
    	BoardItemService boardItemService = new BoardItemServiceImpl();
    	BoardItem boardItems = boardItemService.selectOne(id);
  %>
  <form method="post" name="form">
  <span class="table">
    <h1>수정하기 <i class="fas fa-tools"></i></h1>
    <table 1px black border=1>					
      <tr>
        <td class="index" width=50>번호</td>
        <td width=500>
          <input type="number" name="number" class="input" maxlength="70" readonly value="<%=id%>" style="width:400px;">
        </td>
      </tr>
      <tr>
        <td class="index">제목</td>
        <td>
          <input type="text" class="input" name="title" class="input" maxlength="70" required value="<%=boardItems.getTitle()%>" style="width:400px;">
        </td>
      </tr>
      <tr>
        <td class="index">일자</td>
        <td><%=boardItems.getDate()%></td>
      </tr>
      <tr>
        <td class="index">작성자</td>
        <td>
          <input type="text" class="input" name="writer" class="input" maxlength="70" readonly value="<%=boardItems.getWriter()%>" style="width:400px;">
        </td>
      </tr>
      <tr>
        <td class="index">내용</td>
        <td><textarea name="content" id="content" class="input" cols="60" rows="15" required><%=boardItems.getContent()%></textarea></td>
      </tr>
    </table>
    <button type=submit class="btt" value="삭제" onclick="javascript: form.action='gongji_delete.jsp';"><i class="far fa-trash-alt"></i></button>
    <button type=submit class="btt" value="쓰기" onclick="javascript: form.action='gongji_write.jsp';"><i class="fas fa-pen"></i></button>
    <button type=button class="btt" value="취소" onclick="location.href='gongji_list.jsp'"><i class="fas fa-times"></i></button>

  </span>
  </form>
  	    		
  <% 
  } catch (Exception e) { 
    out.println(e); 
  }
  %>
</body>
</html>