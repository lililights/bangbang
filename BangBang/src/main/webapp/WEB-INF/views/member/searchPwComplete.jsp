<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${result > 0 }">
	<script>
		alert("이메일로 회원님의 비밀번호를 전송하였습니다.");
		location.href = "/bangbang/member/login";
	</script>
</c:if>
<c:if test="${result == 0 }">
	<script>
		alert("아이디 또는 이메일을 확인해주세요.");
		history.go(-1);
	</script>
</c:if>