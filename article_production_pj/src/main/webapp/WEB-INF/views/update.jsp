<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="dto" value="${articleDTO}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기사 수정</title>
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
		<form action="updateAction" method="post">
			<label>번호: ${dto.no}</label> 
		    <input type="hidden" name="no" value="${dto.no}"/>	
			<div class="form-group">
				<label>제목</label>
					<input type="text" name="title" class="form-control" maxlength="30" required="required" value="${dto.title}"/>						
			</div> 
			<div class="form-group">
					<label>부제목</label>
					<input type="text" name="subtitle" class="form-control" maxlength="30" value="${dto.subtitle}"/>						
			</div> 
			<div class="form-group">
					<label>리드 문장</label>
					<input type="text" name="leadsentence" class="form-control" maxlength=20 value="${dto.leadsentence}"/>
			</div>
						
			<div class="form-group">
				<label>내용</label>
				<textarea name="content" class="form-control" maxlength="500" style="height:180px;">${dto.content}</textarea>
			</div>		
			<div class="modal-footer">						
				<a href = "list"><button type="button" style="background-color: #EBF7FF; border-radius: 15%;">취소</button></a>
				<button type="submit" style="background-color: #EBF7FF; border-radius: 15%;">수정하기</button>
			</div>
		</form>
	</div>

	<script src="../js/jquery.min.js"></script>
	<script src="../js/popper.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>