<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./js/jquery-3.1.1.min.js"></script>

</head>
<body>
	${error}
<!--  	<div>
		ID<input type="text" id="id">
		PASSWD<input  id="pw" type="password" name="pw">
		<button id="loginButton">LOGIN</button>
	</div>
	-->
	<form action="login.do" method="post">
		ID<input name="id" type="text">
		PASSWD<input name="pw" type="password">
		<input type="submit" value="send">
	</form>
	


</body>
</html>