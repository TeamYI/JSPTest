<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css"> 
<script src="../js/jquery-3.1.1.min.js"></script>
</head>
<body>
<header>
	<c:if test="${sessionScope.id == null }" >
		<li><a href="login.do">SING IN</a></li>
		<li><a href="membership.do">SING UP</a></li>
	</c:if>
	<c:if test="${sessionScope.id != null }">
		${id}님 환영합니다.
		<li><a href="login.do?command=logout">Logout</a></li>
	</c:if>
	
</header>
<section>
	<c:if test="${cont != null }">
		<jsp:include page="${cont}"></jsp:include>
	</c:if>
</section>
<footer>
	<p>Daitl</p>
</footer>
</body>
</html>