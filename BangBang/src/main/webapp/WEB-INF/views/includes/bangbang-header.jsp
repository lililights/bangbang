<!DOCTYPE html>
<html lang="en">


<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">


<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.84.0">
<title>방방술래</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/blog/">

<link rel="short icon"
	href="${pageContext.request.contextPath}/resources/imageContainer/wine.png">

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/getboot/bootstrap.min.css"
	rel="stylesheet">


<style>
@import
	url('https://fonts.googleapis.com/css2?family=Song+Myung&display=swap')
	;

@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&family=Song+Myung&display=swap')
	;
</style>

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.title-font {
	font-family: 'Song Myung', serif;
	color: black;
	font-size: 40px;
	text-decoration: none;
}

.title-font:hover {
	font-family: 'Song Myung', serif;
	color: gray;
	font-size: 40px;
	text-decoration: none;
}

.nav-font {
	font-family: 'Noto Sans KR', sans-serif;
	text-decoration: none;
	padding: 8px;
	color: black;
	font-size: 18px;
}

.nav-font:hover {
	font-family: 'Noto Sans KR', sans-serif;
	text-decoration: none;
	padding: 8px;
	color: gray;
	font-size: 18px;
}
#profile{
	width: 40px;
	height: 40px;
	border: 1px solid black;
	border-radius: 50%;
}
#user_container{
	
}
</style>

<link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css'
	rel='stylesheet' type='text/css'>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/2.0.0/clipboard.min.js"></script>
<link rel="stylesheet"
	href="https://d1e2y5wc27crnp.cloudfront.net/web/style_4.css">
<!-- Custom styles for this template -->
<link
	href="https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/resources/getboot/blog.css"
	rel="stylesheet">

<script src="https://kit.fontawesome.com/ba424bfb3c.js"
	crossorigin="anonymous"></script>



</head>
<body style="background-color: white;">

	<div class="container">
		<header>
			<div
				class="row flex-nowrap justify-content-between align-items-center">
				<div class="col-4 pt-1"></div>
				<div class="col-4 text-center" style="padding-top: 10px;">
					<a href="${pageContext.request.contextPath}/main/mainpage"
						class="title-font">방방술래</a>
				</div>
				<div class="col-4 d-flex justify-content-end align-items-center"
					style="padding-top: 50px;">


					<div class="header-search"
						style="border: 1px solid rgb(0, 0, 0, 20%); background: #ffffff;">
						<input class="header-serach-input" style="border: 0px;"
							type="text" placeholder="찾으시는 상품">
						<button
							style="border: 0px; background: rgb(0, 0, 0, 20%); outline: none;">
							<i class="fa-solid fa-magnifying-glass"
								style="color: rgb(0, 0, 0, 60%);"></i>
						</button>
					</div>

					<div style="width: 10px;"></div>
					<div id="user_container">
						<c:if test="${empty loginInfo }">
							<div>
								<a href="${pageContext.request.contextPath}/member/login">로그인</a>
								<a href="${pageContext.request.contextPath}/member/join">회원가입</a>
							</div>
						</c:if>
						<c:if test="${not empty loginInfo }">
							<div>
								<c:if test="${loginType eq 'kakao'}">
									<img id="profile" src="${loginInfo.photo}">
									<a
										href="https://kauth.kakao.com/oauth/logout?client_id=${kakao.client_id}&logout_redirect_uri=${kakao.logout_redirect_uri}">로그아웃</a>
								</c:if>
								<c:if test="${loginType eq 'naver'}">
									<img id="profile" src="${loginInfo.photo}">
									<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
								</c:if>
								<c:if test="${loginType eq 'general'}">
									<img id="profile"
										src="${pageContext.request.contextPath}/resources/uploadfile/${loginInfo.photo}">
									<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
								</c:if>
							</div>
						</c:if>
					</div>
				</div>
			</div>
		</header>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>