<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join</title>
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
	<%
		String context = request.getContextPath();
	%>

	<div style="text-align: center">
		<form action="<%=context %>/student/studentView" name="student"  method="post">
		<h3>❤️send data Practice(studentInsert)</h3>
		<hr>
		<p> Name : <input type="text" id="stuName" name="stuName"/> </p>
		<p> Age : <input type="text" id="stuAge" name="stuAge"/> </p>
		<p> Grade : <input type="text" id="stuGrade" name="stuGrade"/> </p>
		<p> Class : <input type="text" id="stuClass" name="stuClass"/> </p>
		<input type="submit" value="send"/>
		</form>
	</div>
</body>
</html>