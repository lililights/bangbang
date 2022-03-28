<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가맹점 관리</title>
<link rel="stylesheet" href="/bangbang/resources/css/container.css">
</head>
<body>
	<%@include file="../../includes/admin-header.jsp"%>
	<%@include file="../../includes/admin-nav.jsp"%>
	<div id="body_container">
		<div id="main_container">
			<form>
				<h3>가맹점 검색</h3>
				<select name="searchType">
					<option value="sname"
						${param.searchType eq 'sname' ? 'selected' : ''}>가맹점명</option>
					<option value="oname"
						${param.searchType eq 'oname' ? 'selected' : ''}>사업자명</option>
				</select> <input type="text">
				<button type="submit">검색</button>
			</form>
			<div>
				<table style="text-align: center; width: 100%;">
					<thead>
						<tr>
							<th colspan="4">가맹점 리스트</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>번호</td>
							<td>가맹점명</td>
							<td>가맹점 주소</td>
							<td>사업자명</td>
						</tr>
						<c:forEach items="${store}" var="s">
							<tr>
								<td>${s.sidx}</td>
								<td>${s.sname}</td>
								<td>${s.address}</td>
								<td>${s.oname}</td>
								<td><a href="store/${s.sname}"><button>상세보기</button></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<br>
			<span>&rarr;<a
				href="${pageContext.request.contextPath}/admin/store/reg">가맹점
					등록하기</a></span>
			<hr>
			<table style="text-align: center; width: 100%;">
				<thead>
					<tr>
						<td colspan="4" style="font-weight: bolder;">가맹점 정보수정 요청<br></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>신청 번호</td>
						<td>가맹점명</td>
						<td>가맹점 아이디</td>
						<td></td>
					</tr>
					<c:forEach items="${storeReq}" var="sr">
						<tr>
							<td>${sr.sridx}</td>
							<td>${sr.sname}</td>
							<td>${sr.storeId}</td>
							<td><a
								href="${pageContext.request.contextPath}/admin/store/${sr.sridx}/req">수정</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<%@include file="../../includes/bangbang-footer.jsp"%>
</body>
</html>