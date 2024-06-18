<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="styleSheet" type="text/css" href="resources/CSS.css">
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<title>CookieList</title>
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
				
				function toCart() {
					window.location.href="/Day5/CookieShopping/cookieCart.jsp";
				}
				
				function isEmpty() {
					let cookies = ["Ame","Double","Otmeal"];
					let allEmpty = true;
					
					for(let i =0; i<3; i++){
						let cnt = document.getElementById("quantity" + cookies[i]).value;
						console.log(cnt);
						if(parseInt(cnt)>0) {
							allEmpty = false;
							break;
						}
					}
					
					if(allEmpty) {
						alert("1개 이상의 상품을 선택해주세요!");
						return false;
					}
					
					return true;
				}
				
		</script>
<style>
        .counter-wrapper {
            display: flex;
            align-items: center;
        }
        .counter-wrapper input[type="number"] {
            text-align: center;
            margin: 0 5px;
        }
</style>
</head>	
<body>
	<div class="text-center">
	<h3 class="text-center my-3" >CookieList</h3>
	<hr/>
	<form name="List" method ="post" action="cookieCart.jsp" onsubmit="return isEmpty()">
	<table class="table table-hover w-75 mx-auto">
		<tr>
			<td>제품 사진</td>
			<td>제품명</td>
			<td>제품가격</td>
			<td class='w-25'>수량</td>
		</tr>
		<tr>
			<td style="font-size :40pt">🍪</td>
			<td>AmericanCookie</td>
			<td>3,000원</td>
			<td>
				<div class="counter-wrapper">
				<input type="button" class="btn btn-secondary" value="-" name="decreaseAme" onclick="decrease('Ame')"/>
				<input type="number" class="form-control" name="AmeCnt" id="quantityAme" value="0" style="width:50px"/>
				<input type="button" class="btn btn-secondary" value="+" name="increaseAme" onclick="increase('Ame')"/>
				</div>
			</td>
		</tr>
		<tr>
			<td style="font-size :40pt">🍪</td>
			<td>DoubleChocoCookie</td>
			<td>2,800원</td>
			<td>
				<div class="counter-wrapper">
				<input type="button" class="btn btn-secondary"  value="-" name="decreaseDouble" onclick="decrease('Double')"/>
				<input type="number" class="form-control" name="DoubleCnt" id="quantityDouble" value="0" style="width:50px"/>
				<input type="button" class="btn btn-secondary"  value="+" name="increaseDouble" onclick="increase('Double')"/>
				</div>
			</td>
		</tr>
		<tr>
			<td style="font-size :40pt">🍪</td>
			<td>OtmealCookie</td>
			<td>2,600원</td>
			<td>
				<div class="counter-wrapper">
				<input type="button" class="btn btn-secondary" value="-" name="decreaseOtmeal" onclick="decrease('Otmeal')"/>
				<input type="number" class="form-control"  name="OtmealCnt" id="quantityOtmeal" value="0" style="width:50px"/>
				<input type="button" class="btn btn-secondary" value="+" name="increaseOtmeal" onclick="increase('Otmeal')"/>
				</div>
			</td>
		</tr>
	</table>
		<input type=submit name=intoCart class="btn btn-success" value="장바구니 담기 및 이동" style="margin-top:20px"/><br>
	</form>
	</div>
</body>

</html>