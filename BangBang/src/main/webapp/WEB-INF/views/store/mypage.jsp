<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>가맹점 상세정보</title>
<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>
<link rel="stylesheet" href="/bangbang/resources/css/container.css">
</head>
<body>
	<%@include file="../includes/store-header.jsp"%>
	<%@include file="../includes/store-nav.jsp"%>
	<div id="body_container">
		<div id="main_container">
			<table style="text-align: left">
				<thead style="text-align: center;">
					<tr>
						<th colspan="3">${store.sname}</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>가맹점 사진</td>
						<td><img
							src="${pageContext.request.contextPath}/resources/uploadfile/${store.photo}"
							style="width: 200px; height: 200px" /></td>
					</tr>
					<tr>
						<td>아이디</td>
						<td>${store.storeId}</td>
					</tr>
					<tr>
						<td>가맹점명</td>
						<td>${store.sname}</td>
					</tr>
					<tr>
						<td>가맹점 전화번호</td>
						<td>${store.sphone}</td>
					</tr>
					<tr>
						<td>가맹점 주소</td>
						<td>${store.address}</td>
					</tr>
					<tr>
						<td></td>
						<td><button id="update_request_btn">가맹점 정보 수정</button></td>
					</tr>
				</tbody>
			</table>
			<hr />
			<table>
				<tr>
					<td>사업자명</td>
					<td>${store.oname}</td>
				</tr>
				<tr>
					<td>사업자 전화번호</td>
					<td>${store.ophone}</td>
				</tr>
				<tr>
					<td>사업자 이메일</td>
					<td>${store.oemail}</td>
				</tr>
				<tr>
					<td>사업자 번호</td>
					<td>${store.regnum}</td>
				</tr>
				<tr>
					<td>가맹점 등록일</td>
					<td>${store.date}</td>
				</tr>
			</table>
			<hr />
			<button id="changepw_btn">비밀번호 변경</button>
		</div>
	</div>
	<script>
		$("#changepw_btn").click(function() {
			location.href = "mypage/edit/pw";
		});
		$("#update_request_btn").click(function() {
			location.href = "mypage/edit/";
		});
	</script>
</body>
</html>
