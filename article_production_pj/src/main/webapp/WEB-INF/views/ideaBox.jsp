<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
	<title>아이디어 박스</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/custom.css"></link>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/popper.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script>
		request.setCharacterEncoding("UTF-8");
	
		String cp = request.getContextPath();
	
		String registerNickname = request.getParameter("registerNickname");
		String registerIdea = request.getParameter("registerIdea");
		String registerMemo = request.getParameter("registerMemo");
		String registerEmail = request.getParameter("registerEmail");
	</script>
	
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
	
	<br><br><br><br>
	<table class="table" style="text-align: center; border: 1px solid #dddddd; width: 900px; margin: auto;">
		<thead>
			<tr>
				<th style="background-color: #fafafa; text-align:center">닉네임</th>
				<th style="background-color: #fafafa; text-align:center">주제</th>
				<th style="background-color: #fafafa; text-align:center">메모</th>
				<th style="background-color: #fafafa; text-align:center">이메일</th>
			</tr>
		</thead>
		<tbody id="ajaxTable">
		</tbody>
	</table>
	<div class="container">
	<br><br><br><br>
		<table class="table" style="text-align:center; border: 1px solid #ddddd">
			<thead>
				<tr>
					<th colspan="2" style="background-color: #fafafa; text-align:center;">아이디어 박스</th>
				</tr>
			</thead>
			<tbody>
			<tr>
				<td style="backgound-color:#fafafa; text-align:center;"><h5>닉네임</h5></td>
				<td><input class="form-control" type="text" id="registerNickname" size="20"></td>
			</tr>
			<tr>
				<td style="backgound-color:#fafafa; text-align:center;"><h5>주제</h5></td>
				<td><input class="form-control" type="text" id="registerIdea" size="20"></td>
			</tr>
			<tr>
				<td style="backgound-color:#fafafa; text-align:center;"><h5>메모</h5></td>
				<td><input class="form-control" type="text" id="registerMemo" size="20"></td>
			</tr>
			<tr>
				<td style="backgound-color:#fafafa; text-align:center;"><h5>이메일</h5></td>
				<td><input class="form-control" type="text" id="registerEmail" size="20"></td>
			</tr>
			<tr>
				<td colspan="2"><button  onclick="registerFunction()" type="button" style="background-color: #EBF7FF; border-radius: 15%; display: block; margin: 0px auto;">등록</button></td>
			</tr>
			</tbody>
		</table>
	</div>
	</body>
</html>