<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.1.1.min.js"></script>

</head>
<body>
	
	<form action="membership.do" method="post" >
		<li>
			<label for="name">ID</label>
			<input id="id" type="text" name="id" maxlength="15" autofocus >
			<button id="checkId">중복확인</button>
		</li>
		<li>
			PASSWD <input type="password" name="pw" maxlength="15" >
			REPASSWD<input type="password" name="repw" maxlength="15" >
		</li>
		<li>
			<input type="submit" value="가입하기">
		</li>
	</form>
</body>
</html>