<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>내 정보 수정</title>
<link rel="stylesheet" href="/bangbang/resources/css/container.css">
<style>
.change_pw {
	display: none;
}

#profile_img {
	border-radius: 15px;
	width: 150px;
	height: 150px;
}
</style>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>
<%@include file="../../includes/bangbang-header.jsp"%>
<%@include file="../../includes/bangbang-nav.jsp"%>
</head>
<body>
	<div id="body_container">
		<%@ include file="/WEB-INF/views/frame/mypagenav.jsp"%>
		<div id="main_container">
			<h3>${member.username}님의회원정보</h3>
			<form method="post" enctype="multipart/form-data">
				<input type="hidden" name="userid" value="${member.userid}">
				<table style="text-align: center;">
					<c:if test="${loginType eq 'general'}">
						<tr>
							<td>프로필</td>
							<td><img
								src="${pageContext.request.contextPath}/resources/uploadfile/${member.photo}"
								id="profile_img"> <input type="hidden" name=oldPhoto
								value="${member.photo}"></td>
							<td><input type="file" name="photo"></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><div id="change_pw">
									<a
										href="${pageContext.request.contextPath}/member/mypage/edit/pw">변경하기</a>
								</div></td>
						</tr>
					</c:if>
					<tr>
						<td>생년월일</td>
						<td>${member.birth}</td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><input type="text" name="phonenum" required
							value="${member.phonenum }"></td>
					</tr>
					<tr>
						<td>이메일</td>
						<c:if test="${loginType eq 'general'}">
							<td><input type="email" name="email" id="email"
								value="${member.email}" required />
								<div id="emsg"></div></td>
						</c:if>
						<c:if test="${loginType eq 'kakao' || loginType eq 'naver'}">
							<td><input type="hidden" name="email" id="email"
								value="${member.email}" /> ${member.email}</td>
						</c:if>
					</tr>
				</table>
				<hr>
				광고 및 알람 수신동의
				<table>
					<tr>
						<td>이메일</td>
						<td><c:if test="${member.enotify eq true}">
								<input type="checkbox" name="enotify" checked>
							</c:if> <c:if test="${member.enotify eq false}">
								<input type="checkbox" name="enotify">
							</c:if></td>
					</tr>
					<tr>
						<td>문자</td>
						<td><c:if test="${member.mnotify eq true}">
								<input type="checkbox" name="mnotify" checked>
							</c:if> <c:if test="${member.mnotify eq false}">
								<input type="checkbox" name="mnotify">
							</c:if></td>
					</tr>
					<tr>
						<td>카카오톡</td>
						<td><c:if test="${member.snotify eq true}">
								<input type="checkbox" name="snotify" checked>
							</c:if> <c:if test="${member.snotify eq false}">
								<input type="checkbox" name="snotify">
							</c:if></td>
					</tr>
					<tr>
						<td><button type="button" id="back_btn">뒤로가기</button>
						<td>
						<td><button type="submit" name="submit">수정하기</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<%@include file="../../includes/bangbang-footer.jsp"%>
	<script type="text/javascript">
		$("#back_btn").click(function() {
			history.go(-1);
		});
	</script>
</body>
</html>
