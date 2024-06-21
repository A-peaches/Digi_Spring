<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
	BoardBean board = (BoardBean)request.getAttribute("boarddata");
%>   --%>
<head>
<meta charset="UTF-8">
<link rel="styleSheet" type="text/css" href="resources/css/CSS.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<title>게시글 상세보기</title>
<style>


.box {
	width: 80%;
	margin: auto;
}

#textarea {
	height: 350px; /* 높이 설정 */
	padding: 10px; /* 여백 설정 */
	margin-left: 10%;
}

.form-label {
	display: inline-block;
	width: 10%;
	font-weight: bold;
}

span, body, pre {
	font-size: 15pt;
}

div {
	margin: 15px 0px 15px 0px;
}

.dotted {
	border: none;
	border-top: 3px dotted gray;
	margin: auto;
	width: 95%;
}


</style>
</head>
<body>
	<jsp:include page="../loginState2.jsp"></jsp:include>
	<br>
	<h3 style="font-weight: bold">🔍게시글 조회</h3>
	<hr>
	<div class="box">
		<form style="text-align: left;">
			<br>
			<div style='text-align: left;'>
				<span class="form-label">제목 :</span> <span>${boardDto.BOARD_SUBJECT}</span>
			</div>
			<span style="text-align: left;"> <span class="form-label">작성자
					:</span> <span>${boardDto.BOARD_NAME}</span>
			</span> <br>
			<br>
			<hr class="dotted">
			<br>
			<div style="display: flex; flex-direction: column;">
				<span class="form-label">내용 :</span> <span> <pre class="gowun-dodum-regular"
						style="text-align: left; margin-left: 50px">
		  ${boardDto.BOARD_CONTENT}
		  </pre>
				</span>
			</div>
			<br> <span style="text-align: left;"> <span
				class="form-label">첨부파일 :</span> <c:if
					test="${not empty boardDto.BOARD_FILE}">
					<%-- 		<%if(!(board.getBOARD_FILE()==null)){ %> --%>
					<a
						href="download?fileName=${boardDto.BOARD_FILE}">${boardDto.BOARD_FILE}</a>

					<%-- 		<img src="${pageContext.request.contextPath}/libraryUploadImg/apeach5.gif" /> --%>
				</c:if> <%-- <%} else { %> --%> <c:if test="${empty boardDto.BOARD_FILE}">
		첨부파일 없음
		<%-- <%}%> --%>
				</c:if>
			</span><br>
			<div style="margin-top: 10px;">
				<a href="./boardList" name="prev" class="btn btn-secondary">목록</a> <a
					href="./boardReplyView?num=${boardDto.BOARD_NUM }"
					class="btn btn-warning">답변</a>
				<c:if test="${sessionScope.user_id == boardDto.BOARD_NAME}">
					<a href="./boardModifyView?num=${boardDto.BOARD_NUM }"
						class="btn btn-success">수정</a>
					<a href="./boardDeleteView?num=${boardDto.BOARD_NUM }"
						class="btn btn-danger">삭제</a>
				</c:if>
			</div>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>
</body>
</html>