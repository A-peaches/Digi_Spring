<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>createPage</title>
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
	<h3>❤️ 학생 정보 입력</h3>
	<hr>
	<form action="result" method="post">
	<p>이름 : <input type="text" name="name" id="name" value="${student.name}"/></p>
	<p>아이디 : <input type="text" name="id" id="id" value="${student.id}"/></p>
	<input type="submit" value="입력"/>
	</form>
	</div>
</body>
</html>