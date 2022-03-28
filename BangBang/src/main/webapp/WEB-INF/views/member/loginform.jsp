<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>로그인</title>
<link rel="stylesheet" href="/bangbang/resources/css/container.css">
<style type="text/css">
#main_container {
	width: 322px;
}
</style>
</head>
<body>
	<%@include file="../includes/bangbang-header.jsp"%>
	<%@include file="../includes/bangbang-nav.jsp"%>
	<div id="body_container">
		<div id="main_container" class="text-center">
			<form method="post">
				<input type="hidden" name="url" value="${param.referer}" />
				<div class="form-floating">
					<label for="userid">아이디</label> <input type="text"
						class="form-control" name="userid" required
						placeholder="아이디를 입력하세요."
						value="${cookie.saveId != null ? cookie.saveId.value : ''}" />
				</div>
				<div class="form-floating">
					<label for="password">비밀번호</label> <input type="password"
						name="password" class="form-control" required
						placeholder="비밀번호를 입력하세요." />
				</div>
				<div>
					<label>아이디 저장</label> <input type="checkbox" name="saveid"
						${cookie.saveId != null ? 'checked' : ' '}>
				</div>
				<div>
					<button type="submit" class="w-100 btn btn-lg btn-primary">
						로그인</button>
				</div>
			</form>
			<div>
				<a
					href="https://kauth.kakao.com/oauth/authorize?client_id=${kakao.client_id}&redirect_uri=${kakao.redirect_uri}&response_type=code"><img
					src="${pageContext.request.contextPath}/resources/images/kakao_login_medium_wide.png" /></a>
			</div>
			<div>
				<a
					href="https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=${naver.client_id}&redirect_uri=${naver.redirect_uri}&state=hLiDdL2uhPtsftcU
 "><img
					src="${pageContext.request.contextPath}/resources/images/naver_login.png"
					width="300px" height="45px" /></a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath }/login/store">가맹점
					로그인</a>
			</div>
			<hr />
			<div>
				<a href="${pageContext.request.contextPath}/member/search/id">아이디
					찾기</a> <a href="${pageContext.request.contextPath}/member/search/pw">비밀번호
					찾기</a>
			</div>
			<span>아직 회원이 아니신가요?</span> <br /> &rarr; <a
				href="${pageContext.request.contextPath }/member/join">회원가입</a>
		</div>
	</div>
	<%@include file="../includes/bangbang-footer.jsp"%>
</body>
</html>
