<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="styleSheet" type="text/css" href="resources/CSS.css">
<style>
 tr, td {
 	text-align : center;
 }
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<title>list</title>
</head>
<body>
<h3 class="text-center my-3">❤️ 게시판 정보 ❤️</h3>
	<hr/>
	<div class="d-flex justify-content-center">
		<table class="w-75 table table-striped table-hover table-bordered">
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>제목</td>
				<td>날짜</td>
				<td>히트</td>
			</tr>
			<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.bId}</td>
				<td>${dto.bName}</td>
				<td>
					<c:forEach begin="1" end="${dto.bIndent}"> ㄴ Re : </c:forEach>
					<a href="content_view?bId=${dto.bId}">${dto.bTitle}</a>
				</td>
				<td>
    			<fmt:formatDate value="${dto.bDate}" pattern="yyyy-MM-dd HH:mm:ss" />
    			</td>
				<td>${dto.bHit}</td>
			</tr>
			</c:forEach>
			<tr class="text-center">
				<td colspan="5"><a href="write_view" class="btn btn-warning">글작성</a></td>
			</tr>
			
			</table>
	</div>
</body>
</html>