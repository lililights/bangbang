<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>간편 회원 가입</title>
<link rel="stylesheet" href="/bangbang/resources/css/container.css">
</head>
<body>
	<%@include file="../includes/bangbang-header.jsp"%>

	<%@include file="../includes/bangbang-nav.jsp"%>
	<div id="body_container">
		<div id="main container">
			<form method="post">
				<input type="checkbox" name="sns" checked="checked"
					style="display: none;">
				<div>
					<label for="photo"><input type="hidden" name="photo"
						value="${userInfo.profile}" /></label>
				</div>
				<div>
					<label for="userid"> <input type="hidden" name="userid"
						value="${userInfo.email}" /></label>
				</div>
				<div>
					<label for="username">이름: <input type="hidden"
						name="username" value="${userInfo.nickname}" required />
						${userInfo.nickname}
					</label>
				</div>
				<div>
					<label for="birth">생년월일: <input type="date" name="birth"
						required /></label>
				</div>
				<div>
					<label for="phonenum">전화번호: <c:if
							test="${empty userInfo.phonenum }">
							<input type="text" name="phonenum" required />
						</c:if> <c:if test="${not empty userInfo.phonenum}">
							<input type="hidden" name="phonenum" value="${userInfo.phonenum}">
           ${userInfo.phonenum}
           </c:if>
					</label>
				</div>
				<div>
					<label for="email"> <input type="hidden" name="email"
						value="${userInfo.email}" /></label>
				</div>
				<div>광고 및 알림 수신동의</div>
				<div>
					<label for="enotify">이메일<input type="checkbox"
						name="enotify" /></label>
				</div>
				<div>
					<label for="mnotify">문자<input type="checkbox"
						name="mnotify" /></label>
				</div>
				<div>
					<label for="snotify">카카오톡<input type="checkbox"
						name="snotify" /></label>
				</div>
				<input type="submit" value="회원가입" />
			</form>
		</div>
	</div>
	<%@include file="../includes/bangbang-footer.jsp"%>
</body>
</html>
