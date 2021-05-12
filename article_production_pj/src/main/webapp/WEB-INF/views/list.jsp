<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="java.io.PrintWriter"%>
<%@ page import="java.net.URLEncoder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<link rel="stylesheet" href="../css/custom.css">
</head>
<body>
<%

	String userID = null;
	//유저가 접속 중인 상태
	if(session.getAttribute("user") != null){
	//유저가 접속이 되어있지 않은 상태
	}else{
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('로그인을 해주세요');");
		script.println("location.href = 'userLogin'");
		script.println("</script>");
		script.close();
	}
	
%>

<nav class="navbar navbar-expand-lg navbar-light">
		<a class="navbar-brand" href="index">NEMAM ARTI</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href="index">메인</a>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">
						 멤버
					</a>
					<div class="dropdown-menu" aria-labelledby="dropdown">
						<a class="dropdown-item" href="userLogout">로그 아웃</a>
				</div>
				</li>
			</ul>
		</div>
	</nav>
	
	<section class="container" style="display: block; margin: 0px auto; margin-top: 50px;">
		<div style="background-color:#EBF7FF; border-radius: 120px; width: 260px; display: block; margin: 0px auto;">
			<br>
			<img src="${pageContext.request.contextPath}/img/smile.png" style="width:90px; height:90px; display: block; margin: 0px auto;">
			<p style="text-align:center;"><%out.print(session.getAttribute("user"));%> 님 환영합니다<p>
			<br>
		</div>
	</section>
	
	<section class="container" style="display: block; margin: 0px auto; margin-top: 50px;">
		<a href = "insert"><button style="background-color: #EBF7FF; border-radius: 15%; display: block; margin: 0px auto; margin-top: 50px;">온라인 기사 등록 하기</button></a> 
		<br>
		<c:forEach var="dto" items="${list}">
			<div class="card bg-light mt-3">
				<div class="card-header bg-light">
					<h4 class="card-title">
							<a href="detail?no=${dto.no}">${dto.title} </a>
					</h4>
				</div>
				<div class="card-body">
				<h5 class="card-title">
					&nbsp;<small>(${dto.regdate})</small>
				</h5>
				<p class="card-text">${dto.subtitle}</p>
				<p class="card-text">구분 : ${dto.divide}</p>	
				</div>
			</div>
		</c:forEach>

	</section>

	<script src="../js/jquery.min.js"></script>
	<script src="../js/popper.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>