<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="/bangbang/resources/css/container.css">
</head>
<body>
	<!-- 마이페이지 네비 -->
	<%@include file="../includes/bangbang-header.jsp"%>

	<%@include file="../includes/bangbang-nav.jsp"%>
	<div id="body_container">
		<div id="main_container">
			<div id="general-reg" class="reg">
				<a href="${pageContext.request.contextPath}/member/join/general">일반
					회원가입</a>
			</div>
			<div id="store-reg" class="reg">
				<a href="${pageContext.request.contextPath}/reg/store">가맹점 등록</a>
			</div>
		</div>
	</div>
	<%@include file="../includes/bangbang-footer.jsp"%>
</body>
</html>