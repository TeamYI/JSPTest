<%@ page language = "java" contentType = "text/html; charset = UTF-8" pageEncoding = "UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import = "deal.bean.LogonDBBean" %>
<%@ page import = "deal.bean.LogonDataBean" %>
<%@ page import = "java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<title></title>
<link rel = "stylesheet" href = "css/style.css">
<script src = "./js/jquery-3.1.1.min.js"></script>
<head>
<body>
	<table border = "1">
		<tr>
			<th>ID</th>
			<th>PASSWD</th>
		</tr>
		<c:forEach var = "usersView" items = "${users}">
			<tr>
				<td>${usersView.id}</td>
				<td>${usersView.passwd}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>