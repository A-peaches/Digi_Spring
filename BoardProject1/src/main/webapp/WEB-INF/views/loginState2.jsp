<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>   
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<script>
	function loginCheck() {
   	 var loggedIn = <%= (session.getAttribute("user_id") != null) ? "true" : "false" %>;
    	if(!loggedIn) {
     	   alert("로그인이 필요합니다!");
     	   window.location.href = "login";
    	}
	}
</script>
<style>
	* {
		font-family : "Gowun Dodum";
		text-align : center;
	}
</style>
<title>loginState</title>
</head>
<body onload="loginCheck()">
</body>
</html>