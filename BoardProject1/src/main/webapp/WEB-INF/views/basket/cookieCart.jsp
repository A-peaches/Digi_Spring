<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>   
<%@ page import = "java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/CSS.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<meta charset="UTF-8">
<title>CookieCart</title>
<style>
	.img {
		height : 100px;
		width : 100px
	}
</style>
<link rel="styleSheet" type="text/css" href="./CSS.css">
<meta charset="EUC-KR">
<title>cookieCart</title>
<style>
img {
	height: 20px;
	width: 20px;
}
</style>

</head>
<body>
	<jsp:include page="../user/loginState.jsp"></jsp:include>
	<h3 class="my-4 fw-bold" >🛒 CookieCart</h3>
	<form method="post" action="basketChange">
	<table class="table table-hover w-50">
		<tr>
			<th class="fw-bold">제품사진</th>
			<th class="fw-bold">제품명</th>
			<th class="fw-bold">개당 가격</th>
			<th class="fw-bold">수량</th>
			<th class="fw-bold">합계</th>
			<th class="fw-bold">삭제</th>
		</tr>
		<c:if test="${not empty basketList}">
                    <c:set var="sum" value="0" />
                    <c:forEach var="basket" items="${basketList}">
                        <tr>
                            <td><img src="${basket.cookie_img}" class="img" /></td>
                            <td>${basket.cookie_name}</td>
                            <td>${basket.cookie_price}원</td>
                            <td>
                                <input type="button" class="btn btn-secondary btn-sm" value="-" 
                                       name="decrease${basket.format}" onclick="decrease('${basket.format}')" />
                                <input type="number" class="form-control" name="${basket.format}Cnt" 
                                       id="quantity${basket.format}" value="${basket.cookie_qnt}" 
                                       style="width:50px; display : inline-block;" />
                                <input type="button" class="btn btn-secondary btn-sm" value="+" 
                                       name="increase${basket.format}" onclick="increase('${basket.format}')" />
                            </td>
                            <td>${basket.cookie_qnt * basket.cookie_price}원</td>
                            <td>
                                <button type="button" class="btn btn-danger btn-sm"
                                        onclick="window.location.href='./basketRemove?cookie_name=${basket.format}'">삭제</button>
                            </td>
                        </tr>
                        <c:set var="sum" value="${sum + (basket.cookie_qnt * basket.cookie_price)}" />
                    </c:forEach>
                </c:if>
                <c:if test="${empty basketList}">
                    <tr>
                        <td colspan="6"><h3 class='my-5'>🥲 장바구니가 비어있습니다!</h3></td>
                    </tr>
                </c:if>
            </table>
            <p>총 가격: ${sum}원</p>
            
            <input type="button" onclick="window.location.href='./cookieList'" value="이전"
                   class="btn btn-secondary mx-3" style="margin-top: 20px" />
            <input type="submit" value="수량변경" class="btn btn-warning" style="margin-top: 20px" />
            <input type="button" onclick="window.location.href='./basketCheck'" value="결제"
                   class="btn btn-success mx-3" style="margin-top: 20px" />
        </form>
<script>

	// 수량 증가
	function increase(cookie) {
		let cnt = document.getElementById("quantity" + cookie);
		let quantity = parseInt(cnt.value);
		cnt.value = quantity + 1;
	}

	// 수량 감소
	function decrease(cookie) {
		let cnt = document.getElementById("quantity" + cookie);
		let quantity = parseInt(cnt.value);
		if (quantity > 0) {
			cnt.value = quantity - 1;
		}
	}
</script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
		
</body>

</html>