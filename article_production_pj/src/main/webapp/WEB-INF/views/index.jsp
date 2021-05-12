<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NEMAM ARTI</title>
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/custom.css"></link>

		<style>
			img { display: block; margin: 0px auto; margin-top: 50px; width: 150px; height: 150px; }
		</style>
</head>
<body>
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

						<a class="dropdown-item" href="userLogin">로그인</a>
						<a class="dropdown-item" href="userJoin">회원 가입</a>
						<a class="dropdown-item" href="userLogout">로그 아웃</a>
				</div>
				</li>
			</ul>
		</div>
	</nav>
	<h3 style="text-align: center; margin-top: 120px;">나만의 온라인 신문 기사를 제작해보세요</h3>
	<img src = "${pageContext.request.contextPath}/img/icon.png">
	<a href = "list"><button style="background-color: #EBF7FF; border-radius: 15%; display: block; margin: 0px auto; margin-top: 50px;"><h5>바로 가기</h5></button></a> 
	<a href = "ideabox"><button style="background-color: #EBF7FF; border-radius: 15%; display: block; margin: 0px auto; margin-top: 15px;"><h5>아이디어 박스</h5></button></a>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/popper.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>