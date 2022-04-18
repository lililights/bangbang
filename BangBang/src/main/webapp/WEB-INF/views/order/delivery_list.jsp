<%@ page language="java" contentType="text/html; charset=UTF-8"//
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/frame/pageset_order.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 배송관리</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>

<style>
th, td {
	text-align: center;
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
		<h3 class="mt-4 pb-3 font-italic">[ 배송관리 ]</h3>

		<ol class="breadcrumb mb-3 p-2">
			<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/main/mainpage">홈</a></li>
			<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin">관리자 페이지</a></li>
			<li class="breadcrumb-item active">배송관리</li>
		</ol>

		<div class="card mb-3">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>배송번호</th>
						<th>주문번호</th>
						<th>배송수단</th>
						<th>업체명</th>
						<th>운송장번호</th>
						<th>배송료</th>
						<th>배송조회</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${deliveryList}" var="del">
						<tr>
							<td class="p-1 align-middle">${del.didx}</td>
							<td class="p-1 align-middle"><a
								href="../admin/list/${del.oidx}">${del.oidx}</a></td>
							<td class="p-1 align-middle">${del.service}</td>
							<td class="p-1 align-middle">${del.provider}</td>
							<td class="p-1 align-middle">${del.no}</td>
							<td class="p-1 align-middle">${del.fee}</td>
							<c:if test="${del.service eq '택배'}">
								<td class="p-1 align-middle"><input type="button"
									value="배송 조회" class="btn btn-primary py-1"
									onclick="window.open('http://nplus.doortodoor.co.kr/web/detail.jsp?slipno=${del.no}')"></td>

							</c:if>
							<c:if test="${del.service eq '퀵'}">
								<td class="p-1 align-middle"><input type="button"
									value="배송 조회" class="btn btn-primary py-1"
									onclick="alert('퀵서비스 배송 조회는 업체에 문의 하세요. 080-111-1234');"></td>

							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</main>
<%-- 	<%@include file="../includes/bangbang-footer.jsp"%> --%>
</body>
</html>