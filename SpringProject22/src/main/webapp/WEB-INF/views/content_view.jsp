<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>content_view</title>
</head>
<body>
	<h3 class="text-center my-3">❤️ 게시글 상세 조회 ❤️</h3>
	<div class="d-flex justify-content-center">
	<table class="w-75 table table-hover table-bordered">
		<form action="modify" method="post">
			<input type="hidden" name="bId" value="${content.bId}">
			<tr>
				<td> 번호 </td>
				<td> ${content.bId} </td>
			</tr>
			<tr>
				<td> 히트 </td>
				<td> ${content.bHit} </td>
			</tr>
			<tr>
				<td> 이름 </td>
				<td> <input class='form-control w-100' type="text" name="bName" value="${content.bName}" ></td>
			</tr>
			<tr>
				<td> 제목 </td>
				<td> <input class='form-control w-100' type="text" name="bTitle" value="${content.bTitle}" ></td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> <textarea class='form-control w-100' rows="10" name="bContent">${content.bContent}</textarea></td>
			</tr>
			<tr >
				<td colspan="2" > 
				<input type="submit" class='btn btn-warning' value="수정"/> &nbsp;&nbsp; 
				<a href="list"  class='btn btn-secondary'>목록보기</a> &nbsp;&nbsp; 
				<a href="delete?bId=${content.bId}" class='btn btn-danger'>삭제</a> &nbsp;&nbsp;
				 <a href="reply_view?bId=${content.bId}" class='btn btn-primary'>답변</a>
				 </td>
			</tr>
		</form>
	</table>
	</div>
</body>
</html>