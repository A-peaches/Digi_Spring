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
	<div style="text-align: center">
		<form action="student/studentView" name="student"  method="post">
		<h3>❤️join data Practice (join)</h3>
		<hr>
		<p> student ID : <input type="text" id="id" name="id"/> </p>
		<input type="submit" value="send"/>
		</form>
	</div>
</body>
</html>