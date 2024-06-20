<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="styleSheet" type="text/css" href="resources/CSS.css">
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<title>CookieCart</title>
	<script>
		function onCheck(){
			alert("결제가 완료되었습니다!");
			window.location.href = "check";
		}
	</script>
</head>	
<body>
	<div class="text-center">
	<h3 class="text-center my-3" >CookieList</h3>
	<hr/>
	<table class="table table-hover w-75 mx-auto">
		<tr>
			<td>제품 사진</td>
			<td>제품명</td>
			<td>제품가격</td>
			<td class='w-25'>수량</td>
		</tr>
		<c:forEach items="${list}" var="li">
		<tr>
			<td style="font-size :40pt">🍪</td>
			<td>${li.cookie_name }</td>
			<td>${li.cookie_price }원</td>
			<td>
				${li.cookie_cnt}개
			</td>
		</tr>
		</c:forEach>
	</table>
		<input type='button' name='intoCart' onClick="onCheck()" class="btn btn-primary" value="결제" style="margin-top:20px"/><br>
	</form>
	</div>

</body>

</html>