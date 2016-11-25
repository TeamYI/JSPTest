<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = "css/style.css">
<script src = "./js/jquery-3.1.1.min.js"></script>
<script>
	$(document).ready(function() {
		$('#auctionManagement').mouseenter(function() {
			$('.auctionChild').css('display', 'block');
		});
	});
</script>
</head>
<body>
	<nav>
		<ul>
			<li id = "auctionManagement"><a href = "#">경매</a></li>
			<li class = "auctionChild"><a href = "auction.do">진행중인 경매</a></li>
			<li class = "auctionChild"><a href = "planAuction.do">진행 예정 경매</a></li>
			<li class = "auctionChild"><a href = "resultAuction.do">종료된 경매 및 결과</a></li>
			<li class = "auctionChild"><a href = "updateAuction.do">경매 물품 등록 및 수정</a></li>
			
			<li id = "memberManagement"><a href = "#">회원 관리</a></li>
			<li class = "memberChild"><a href = "usersView.do">회원 리스트</a></li>
			<li class = "memberChild"><a href = "usersUpdate.do">회원 정보 수정</a></li>
		</ul>
	</nav>
	<div>
		<section id = "view">
			<c:if test = "${view != null}">
				<jsp:include page = "${view}"></jsp:include>
			</c:if>
		</section>
	</div>
</body>
</html>