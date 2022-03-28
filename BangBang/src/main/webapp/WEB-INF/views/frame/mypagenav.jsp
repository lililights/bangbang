<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#mypage_nav {
	width: 200px;
	height: 60%;
	text-align: center;
	border: 1px solid black;
	border-radius: 15px;
	margin-right: 50px;
	text-align: center;
}

#mypage_ul {
	list-style: none;
	padding: 0;
	margin: 10px 10px;
}

#mypage_ul>li {
	margin-bottom: 10px;
}

#mypage_ul * a {
	text-decoration: none;
	color: inherit;
	font-weight: bold;
}
</style>
<nav id="mypage_nav">
	<ul id="mypage_ul">
		<li><a
			href="${pageContext.request.contextPath}/member/mypage/edit">내정보
				수정</a></li>
		<li><a href="${pageContext.request.contextPath}/cart">장바구니</a></li>
		<li><a href="${pageContext.request.contextPath}/order/member/${loginInfo.uidx}/list">주문내역</a></li>
		<li><a href="">찜 목록</a></li>
		<li><a href="">쿠폰 / 적립금</a></li>
		<li><a href="">1:1 문의 내역</a></li>
	</ul>
</nav>

