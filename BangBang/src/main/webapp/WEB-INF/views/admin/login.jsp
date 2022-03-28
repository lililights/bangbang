<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>관리자 로그인</title>
<link rel="stylesheet" href="/bangbang/resources/css/container.css">
</head>
<body>
	<%@include file="../includes/admin-header.jsp"%>
	<%@include file="../includes/admin-nav.jsp"%>
	<div id="body_container">
		<div id="main_container">
			<form method="post">
				<table>
					<tr>
						<td>관리자 아이디</td>
						<td><input type="text" name="aid" required /></td>
					</tr>
					<tr>
						<td>관리자 비밀번호</td>
						<td><input type="password" name="apw" required /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="로그인" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<%@include file="../includes/bangbang-footer.jsp"%>
</body>
</html>
