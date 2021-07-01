<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo33.service.*" %>
<%@ page import="kr.ac.kopo.kopo33.domain.*" %>
<%@ page import="java.sql.*, javax.sql.*, java.io.*, java.util.* " %>
<% request.setCharacterEncoding("UTF-8"); %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert</title>
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
      font-size: medium;
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
      font-size: medium;
      font-family: 'Jua', 'Playfair Display', sans-serif, serif;
      background-color: transparent;
    }

    .btt:hover {
      cursor: pointer;
      background-color: #9cbed4;
    }

    
  </style>
</head>
  <form method="post" name="form">
  <span class="table">
    <h1>신규 글 등록</h1>
    <table 1px black border=1>
      <tr>
        <td class="index" width=50>번호</td>
        <td width=500>신규(insert)</td>
      </tr>
      <tr>
        <td class="index">제목</td>
        <td>
          <input type="text" class="input" name="title" maxlength="70" value="" required style="width:400px;">
        </td>
      </tr>
      
      <tr>
        <td class="index">일자</td>
        <td id="dateprint"></td>
      </tr>
      <tr>
        <td class="index">작성자</td>
        <td>
          <input type="text" class="input" name="writer" maxlength="70" value="" required style="width:400px;">
        </td>
      </tr>
      <tr>
        <td class="index">내용</td>
        <td><textarea name="content" class="input" id="content" cols="60" rows="15" required></textarea></td>
      </tr>
    </table>
    <button type="submit" class="btt" onclick="javascript: form.action='gongji_write.jsp';">글쓰기 <i class="fas fa-pen"></i></button>
    <button type="button" class="btt" onclick="location.href='gongji_list.jsp'">취소 <i class="fas fa-times"></i></button>
  </span>
  </form>


  <script>
    function getToday() {
      var date = new Date();
      var year = date.getFullYear();
      var month = ("0" + (1 + date.getMonth())).slice(-2);
      var day = ("0" + date.getDate()).slice(-2);

      return year + "-" + month + "-" + day;
    }

    let today = getToday();
    document.getElementById("dateprint").innerHTML = today;
  </script>
</body>
</html>