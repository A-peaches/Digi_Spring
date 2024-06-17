<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Result</title>
<style>
@font-face {
	font-family: 'MangoDdobak-B';
	src:
		url('https://fastly.jsdelivr.net/gh/projectnoonnu/2405-3@1.1/MangoDdobak-B.woff2')
		format('woff2');
	font-weight: 700;
	font-style: normal;
}

* {
	font-family: 'MangoDdobak-B';
}
</style>
</head>
<body>
  <br><h2 align='center'> 회원 가입 정보 확인 </h2><br>
  <hr><br>
  <h3>ID : ${joinData.id}</h3>
  <h3>PW : ${joinData.pw}</h3>
  <h3>email : ${joinData.email}</h3>
  <h3>name : ${joinData.name}</h3>
  <h3>idNo : ${joinData.idNo}</h3>
  <h3>birth : ${joinData.year}년
  			  ${joinData.month}월
  			  ${joinData.day}일
  </h3>
  <h3>habit :  ${joinData.habit}  
<%--   <%
    String[] habits = joinbean.getHabit();
    if (habits != null) {
        for (String habit : habits) {
            out.println("<li>" + habit + "</li>");
        }
    } else {
        out.println("<li>선택된 취미가 없습니다.</li>");
    }
    %> --%>
   </h3>
  <h3>myInfo : ${joinData.myInfo}</h3>
	
</body>
</html>