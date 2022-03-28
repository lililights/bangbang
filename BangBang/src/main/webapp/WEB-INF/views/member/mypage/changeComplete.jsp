<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${result > 0 }">
	<script>
		alert("비밀번호가 변경되었습니다.\n다시 로그인 해주세요.");
		location.href = "/bangbang/member/login";
	</script>
</c:if>