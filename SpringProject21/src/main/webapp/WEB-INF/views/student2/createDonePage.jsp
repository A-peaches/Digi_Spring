<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>createDonePage</title>
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
	<h3>❤️ 학생 정보 결과</h3>
	<hr>
	<p>이름 : ${student.name}</p>
	<p>아이디 : ${student.id}</p>
	</div>
</body>
</html>