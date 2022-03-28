<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>가맹점 정보 수정</title>
<link rel="stylesheet" href="/bangbang/resources/css/container.css">
<%@include file="/WEB-INF/views/frame/pageset.jsp"%>
</head>
<body>
	<%@include file="../../includes/admin-header.jsp"%>
	<%@include file="../../includes/admin-nav.jsp"%>
	<div id="body_container">
		<div id="main_container">
			<form method="post" enctype="multipart/form-data">
				<input type="hidden" name="storeId" id="storeId"
					value="${store.storeId}" required />
				<table>
					<tr>
						<td>가맹점 이름</td>
						<td><input type="text" name="sname" id="sname"
							value="${store.sname}" required /></td>
					</tr>
					<tr>
						<td>가맹점 전화번호</td>
						<td><input type="text" name="sphone" id="sphone"
							value="${store.sphone}" required /></td>
					</tr>
					<tr>
						<td>가맹점 주소</td>
						<td><input type="text" name="address" id="address"
							value="${store.address}" required /></td>
					</tr>
					<tr>
						<td>사업자명</td>
						<td><input type="text" name="oname" id="oname"
							value="${store.oname}" required /></td>
					</tr>
					<tr>
						<td>사업자 전화번호</td>
						<td><input type="text" name="ophone" id="ophone"
							value="${store.ophone}" required /></td>
					</tr>
					<tr>
						<td>사업자 이메일</td>
						<td><input type="email" name="oemail" id="oemail"
							value="${store.oemail}" required /></td>
					</tr>
					<tr>
						<td>사업자 등록번호</td>
						<td><input type="text" name="regnum" id="regnum"
							value="${store.regnum}" required /></td>
					</tr>
					<tr>
						<td><button type="submit">정보저장</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<%@include file="../../includes/bangbang-footer.jsp"%>
</body>
</html>
