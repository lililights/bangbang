<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>마이페이지</title>

<style type="text/css">
body{
	align-content: center;
}
	#mypage_container{
		display: flex;
		align-content: center;
		justify-content: center;
		width: 80%
	}
</style>
</head>
<body>
	<!-- 마이페이지 네비 -->
	<%@include file="../../includes/bangbang-header.jsp"%>

	<%@include file="../../includes/bangbang-nav.jsp"%>
	
	<div id="mypage_container">

		<%@ include file="/WEB-INF/views/frame/mypagenav.jsp"%>
		<div id="order_container">
			<h3>주문 목록</h3>
		</div>
	
	</div>
	<%@include file="../../includes/bangbang-footer.jsp"%>
</body>
</html>
