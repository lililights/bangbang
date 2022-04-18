<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>

	<c:if test="${loginInfo ne null}">
		<button
			onclick="location.href='../order/member/${loginInfo.uidx}/list'">일반회원
			주문목록</button>
	</c:if>
	<c:if test="${storeInfo ne null}">
		<button
			onclick="location.href='../order/store/${storeInfo.sidx}/list'">가맹점
			주문목록</button>
	</c:if>
	<c:if test="${adminInfo ne null}">
		<button onclick="location.href='../order/admin/list'">관리자
			주문목록</button>
		<button onclick="location.href='../order/admin/delivery'">배송관리</button>
	</c:if>
	<c:if
		test="${loginInfo eq null and storeInfo eq null and adminInfo eq null}">
		<h1>로그인이 필요한 페이지입니다.</h1>
	</c:if>

</body>
</html>