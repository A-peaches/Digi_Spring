<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentId</title>

<script>
function showBirth() { // 생년월일 보여주기
    var inputIdNo = document.getElementById("idNo").value;
    var numArray = inputIdNo.split("", 13);
    if (numArray[7] == 3 || numArray[7] == 4) {
        var y = numArray.slice(0, 1);
        var year = "20" + y.join("");
        var month = numArray[2] + numArray[3];
        var day = numArray[4] + numArray[5];
    } else {
        var y = numArray.slice(0, 2);
        var year = "19" + y.join("");
        var month = numArray[2] + numArray[3];
        var day = numArray[4] + numArray[5];
    }
    document.getElementById("year").value = year;
    document.getElementById("month").value = month;
    document.getElementById("day").value = day;
}
</script>
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

input {
	width: 30%;
}

td {
	text-align: left;
}
</style>
</head>
<body on>
	<div>
		<br>
		<h2 align='center'>❤️ 회원 가입 ❤️</h2>
		<br>
		<hr>
		<br>
		<div align='center'>
			<form name="joinForm" method=post action="joinResult"
				onsubmit="return Check()">
				<table border="1" style="width: 90%">
					<tr>
						<td class="subtitle" colspan='2'>
							<h3 align='center'>회원 기본 정보</h3>
						</td>
					</tr>
					<tr>
						<td>아이디 :</td>
						<td><input type='text' name="id" id ="id" class='input' class='input'
							size='20' value="${joinData.id}" maxlength=20></input>&nbsp;&nbsp;4~12자의 영문 대소문자와 숫자로만
							입력</td>
					</tr>
					<tr>
						<td>비밀번호 :</td>
						<td><input type='password' name="pw"  id="pw" size='20' class='input'
							maxlength=20 value="${joinData.pw}"></input>&nbsp;&nbsp;4~12자의 영문 대소문자와 숫자로만 입력</td>
					</tr>
					<tr>
						<td>비밀번호 확인 :</td>
						<td><input type='password' name="pw2" id="pw2" class='input' size='20'
							maxlength=20 value="${joinData.pw2}"></input></td>
					</tr>
					<tr>
						<td>메일 주소:</td>
						<td><input type='text' name="email"  id="email" class='input' size='20'
							maxlength=20 value="${joinData.email}"></input>&nbsp;&nbsp;예) id@domain.com</td>
					</tr>
					<tr>
						<td>이름:</td>
						<td><input type='text' name='name'  id='name' class='input' size='20'
							maxlength=20 value="${joinData.name}"></input></td>
					</tr>
					<tr>
						<td colspan='2' class="subtitle" align='center'>
							<h3 align='center'>개인 신상 정보</h3>
						</td>
					</tr>
					<tr>
						<td>주민등록번호 :</td>
						<td><input type='text' name='idNo' id='idNo' class='input' size='20'
							maxlength=20 value="${joinData.idNo}"  onkeyup="showBirth()" ></input>&nbsp;&nbsp;예) 1234561234567</td>
					</tr>
					<tr>
						<td>생일 :</td>
						<td><input type='text' name='year' id='year' size='20' maxlength=5
							style="height: 26px;" value="${joinData.year}">년</input> 
							<input type='text' name='month' id='month' size='10' maxlength=5
							style="height: 26px; width : 16px" value="${joinData.month}">월</input>
							<input type='text' name='day' id='day' size='10' maxlength=5
							style="height: 26px; width : 16px" value="${joinData.day}">일</input>
					</tr>
					<tr style='height: 45px'>
						<td>관심분야 :</td>
						<td><input type='checkbox' name='habit' id='habit' value='컴퓨터' >컴퓨터
							<input type='checkbox' name='habit' id='habit' value='인터넷'>인터넷 <input
							type='checkbox' name='habit' id='habit' value='여행'>여행 <input
							type='checkbox' name='habit' id='habit' value='영화감상'>영화감상 <input
							type='checkbox' name='habit' id='habit' value='음악감상'>음악감상</td>
					</tr>
					<tr style='height: 65px'>
						<td>자기 소개 :</td>
						<td><textarea name="myInfo" id='myInfo'cols='105' rows='6' value="${joinData.myInfo}"></textarea> <small>30자이상</small>
						</td>
					</tr>
				</table>
				<div style="margin: 20px;">
					<input type="submit" class="btn"
						style="width: 10%; text-decoration: none; color: black;"
						value="제출"> <input type="reset" class="btn"
						style="width: 10%;" value="다시 입력">
				</div>
			</form>
		</div>
	</div>
</body>
</html>