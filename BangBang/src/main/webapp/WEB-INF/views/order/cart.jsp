<%@ page language="java" contentType="text/html; charset=UTF-8"//
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/frame/pageset_order.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/order/web_storage.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/order/cart.js?ver=6"/>"></script>
<script src="https://kit.fontawesome.com/39c52c9ac0.js"
	crossorigin="anonymous"></script>

<c:if test="${not empty loginInfo}">
	<script>
		// 로그인시 로컬스토리지 객체 생성
		var key = "LocalCart" + ${loginInfo.uidx};
		var storage = new local(key);
		var cart = getCart(storage);
	</script>
</c:if>

<c:if test="${empty loginInfo}">
	<script>
		// 비로그인시 세션스토리지 객체 생성
		var key = "SessionCart";
		var storage = new session(key);
		var cart = getCart(storage);
	</script>
</c:if>

<script>
	const contextPath = '${pageContext.request.contextPath}';
	
	$(document).ready(function() {
		getCartItemInfo(contextPath);
	});
</script>
</head>

<style>
th, td {
	text-align: center;
}

td {
	height: 80px;
}

#main_container {
  display: inline-block;
  width: 500px;
  margin-top: 50px;
  border: 1px solid black;
  border-radius: 15px;
  padding: 10px 10px;
  box-shadow: 5px 5px 7px rgb(0, 0, 0, 0.5);
}
</style>

<body>
<%-- <c:if test="${loginInfo ne null}">
	<%@include file="../includes/bangbang-header.jsp"%>
	<%@include file="../includes/bangbang-nav.jsp"%>
</c:if>
<c:if test="${storeInfo ne null}">
	<%@include file="../includes/store-header.jsp"%>
	<%@include file="../includes/store-nav.jsp"%>
</c:if>
<c:if test="${adminInfo ne null}">
	<%@include file="../includes/admin-header.jsp"%>
	<%@include file="../includes/admin-nav.jsp"%>
</c:if> --%>

<main class="container">
	<div class="container-fluid px-4">

		<h3 class="mt-4 pb-3 font-italic">[ 장바구니 ]</h3>

		<ol class="breadcrumb mb-3 p-2">
			<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/main/mainpage">홈</a></li>
			<li class="breadcrumb-item active">장바구니</li>
		</ol>

		<div class="card mb-3">
			<table id="list" class="table table-hover">
				<thead>
					<tr>
						<td colspan="7">목록을 불러오는 중입니다...</td>
					</tr>
				</thead>
			</table>
		</div>

		<div class="float-left">
			<button onclick="location.href='${pageContext.request.contextPath}/item'" class="btn btn-primary">쇼핑하기</button>
		</div>
		
		<div class="float-right">
			<button onclick="removeAll()" class="btn btn-primary">장바구니
				비우기</button>
			<button onclick="order(contextPath)" class="btn btn-primary">주문하기</button>
		</div>
	</div>
	</main>
<%-- 	<%@include file="../includes/bangbang-footer.jsp"%> --%>
</body>
</html>
