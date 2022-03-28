<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>회원가입</title>
<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>
<link rel="stylesheet" href="/bangbang/resources/css/container.css">
<style>
#msg {
	display: none;
}

.text_red {
	color: red;
}

.text_blue {
	color: blue;
}
</style>
<script type="text/javascript"
	src="<c:url value="/resources/js/checkid.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/checkemail.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/checkpw.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/reg.js"/>"></script>
</head>
<body>
	<%@include file="../includes/bangbang-header.jsp"%>

	<%@include file="../includes/bangbang-nav.jsp"%>
	<div id="body_container">
		<div id="main_container">
			<form method="post" id="form">
				<table>
					<!-- 아이디 비밀번호 이름 생년월일 전화번호 이메일 이메일(수신여부) 문자(수신여부) 카카오톡(수신여부) -->
					<tr>
						<td>아이디</td>
						<td><input type="text" name="userid" id="userid" required
							min="5" max="30" />
							<div id="msg"></div></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="password" id="password1"
							min="8" max="16" required /></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" name="password2" id="password2"
							min="8" max="16" required />
							<div id="pmsg"></div></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="username" id="username" required /></td>
					</tr>
					<tr>
						<td>생년월일</td>
						<td><input type="date" name="birth" required /></td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><input type="text" name="phonenum" required /></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="email" name="email" id="email" required />
							<div id="emsg"></div></td>
					</tr>
				</table>
				<hr />
				<span>광고및 알람 수신여부</span><br />
				<table>
					<tr>
						<td>이메일</td>
						<td><input type="checkbox" name="enotify" /></td>
					</tr>
					<tr>
						<td>문자</td>
						<td><input type="checkbox" name="mnotify" /></td>
					</tr>
					<tr>
						<td>카카오톡</td>
						<td><input type="checkbox" name="snotify" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<button name="submit" id="submit" type="submit">가입하기</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<%@include file="../includes/bangbang-footer.jsp"%>
</body>
</html>
