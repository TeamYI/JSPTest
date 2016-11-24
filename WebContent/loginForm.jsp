<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./js/jquery-3.1.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#loginButton").click(function(){
		var query = { id : $("#id").val(), pw : $("#pw").val()};
		
		//$("#name").val() = id="name"에 적은 값을 가져온다.
		// name : <- name은 뒷 페이지로 넘길 변수이름 
		// 배열값이라서 name : $("#name").val() ; 찍으면 안된다.
		$.ajax({
			type:"POST" ,
			url : "login.do", // url서버로 보냄
			data : query  
		//	success:function(data) {
			// success 서버가 응답하면 실행
			//	$("#form").addClass("hidden");
		//		$("#result").html(data) ;
		//	}
		
		// 버튼을 클릭하게 되면, post방식으로 url로 data를 넘기고 
		// 서버가 응답하면   result안에 다가 받아온 데이터값 넣음
		});
		
	});
});
</script> 
</head>
<body>
	${error}
	<div>
		ID<input type="text" id="id">
		PASSWD<input  id="pw" type="password" name="pw">
		<button id="loginButton">LOGIN</button>
	</div>

<!-- 	<form action="login.do" method="post">
		ID<input name="id" type="text">
		PASSWD<input name="pw" type="password">
		<input type="submit" value="send">
	</form>
-->
</body>
</html>