<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="dto" value="${articleDTO}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기사 삭제</title>
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
	
	<div style="width: 550px; height: 1300px; display: block; margin: 0px auto; margin-top: 50px;">
		<form action="deleteAction" method="post">
			<p class="card-title">
						제목 : ${dto.title}
			</p>
			<div class="form-group">
				<label>번호</label>
				번호 : ${dto.no}<input type="hidden" name="no" value="${dto.no}" />
			</div>			
			<div class="modal-footer">									
				<a href = "list"><button type="button" style="background-color: #EBF7FF; border-radius: 15%;">취소</button></a>
				<button type="submit" style="background-color: #EBF7FF; border-radius: 15%;">삭제 하기</button>
			</div>
		</form>
	</div>

	<script src="../js/jquery.min.js"></script>
	<script src="../js/popper.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>