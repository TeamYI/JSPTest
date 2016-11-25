<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./js/jquery-3.1.1.min.js"></script>
<script>
var status = true ;
	
	$(document).ready(function(){
		$("#checkId").click(function(){
			if($("#id").val()){
			var query = { id : $("#id").val() } ;
			
			$.ajax({
				type : "POST" ,
				url : "confirmId.do",
				data : query ,
				success : function(data){
					var str1 = '<p id="ck">' ;
					var loc = data.indexOf(str1) ;
					var len = str1.length ;
					var check = data.substr(loc+len,1) ;
					if(check == "1"){
						alert("사용할 수 없는 아이디");
						$("#id").val("");
					}else{
						alert("사용할 수 있는 아이디");
					}
					
					
				}
			})
		}else{
			alert("사용할 아이디를 입력");
			$("#id").focus();
		}
			
		});
		
		$("#process").click(function(){
			checkIt();
			if(status){
			var query = {id : $("#id").val(),
					pw : $("#pw").val()}
			
			$.ajax({
				type : "POST" ,
				url : "membership.do",
				data : query ,
				success : function(data){
					$("#wrap").load("main.jsp") ;
				}
			})
		
			}		
			
		})
		
		$("#cancle").click(function(){
			$("#wrap").load("main.jsp") ;
		})
		
		function checkIt(){
			status = true ;
			if(!$("#id").val()){
				alert("아이디를 입력하세요");
				$("#id").focus();
				status = false ;
				return false ; 
			}
			if(!$("#pw").val()){
				alert("비밀번호를 입력하세요");
				$("#pw").focus();
				status = false ;
				return false ; 
			}
			if($("#pw").val() != $("#repw").val()){
				alert("비밀번호를  동일하게 입력하세요");
				$("#repw").focus();
				status = false ;
				return false ; 
			}
			
		}
});
</script>
</head>
<body>
	<div id="wrap">
		<li>
			<label for="name">ID</label>
			<input id="id" type="text" name="id" maxlength="15" autofocus >
			<button id="checkId">중복확인</button>
		</li>
		<li>
			PASSWD <input type="password" id="pw" name="pw" maxlength="15" >
			REPASSWD<input type="password" id="repw"  maxlength="15" >
		</li>
		<li>
			<button id="process">가입</button>
			<button id="cancle">취소</button>
		</li>
	</div>
</body>
</html>