<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="dto" value="${articleDTO}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 로그인</title>
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

						<a class="dropdown-item" href="userLogin">로그인</a>
						<a class="dropdown-item" href="userJoin">회원 가입</a>

						<a class="dropdown-item" href="userLogout">로그 아웃</a>
				</div>
				</li>
			</ul>
		</div>
	</nav>
	
	<section class="container mt-3" style="max-width: 560px;">
		<form method="post" action="userLoginAction" style="display: block; margin-top: 90px;">
			<div class="form-group">
				<label>아이디</label>
				<input type="text" name="id" class="form-control">		
			</div>
			<div class="form-group">
				<label>비밀번호</label>
				<input type="password" name="password" class="form-control">
			</div>
			<button type="submit" class="btn"  style="background-color: #EBF7FF;">로그인</button>
		</form>
	</section>
	
	<script src="../js/jquery.min.js"></script>
	<script src="../js/popper.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>