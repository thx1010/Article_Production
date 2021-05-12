<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="dto" value="${articleDTO}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 사항</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/custom.css">
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
							<a class="dropdown-item" href="userLogout">로그 아웃</a>
					</div>
					</li>
				</ul>
			</div>
	</nav>
	
	<!-- 기사 모양으로 만들기 -->
	<section class="container" style="display: block; margin: 0px auto; margin-top: 50px;">
		<div class="card bg-light mt-3">
			<div class="card-header bg-light">
				<br>
				<h1 class="card-title" style="text-align:center">
						${dto.title}
				</h1>
				<br>
				<h5 class="card-title" style="text-align:center">
						${dto.subtitle}
				</h5>
				<br>
				<c:if test="${not empty dto.photo}">
					<img src="${pageContext.request.contextPath}/img/${dto.photo}" width=1000 height=500 style="display: block; margin: 0px auto;"/><br>
				</c:if>
				<br>
				<h5 class="card-title" style="text-align:center">
						${dto.leadsentence}
				</h5>
				
			</div>
			<div class="card-body" style="text-align:center">
			<h5 style="text-align:center"> ${dto.content}</h5>
			<br>
			</div>
			<p class="card-title" style="padding-left:10px">
			&nbsp;(${dto.regdate})
			</p> 
			<div class="col-9 text-left">
				<span style="color: red;">구분 : ${dto.divide}</span>
			</div>
			<br>
			</div>
		</br>
		<a href = "update?no=${dto.no}"><button type="button" style="background-color: #EBF7FF; border-radius: 15%;">수정</button></a>
		<a href = "delete?no=${dto.no}"><button type="button" style="background-color: #EBF7FF; border-radius: 15%;">삭제</button></a>
		<a href = "list"><button type="button" style="background-color: #EBF7FF; border-radius: 15%;">리스트</button></a>
		<br><br>
	</section>
	
	<script src="../js/jquery.min.js"></script>
	<script src="../js/popper.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>