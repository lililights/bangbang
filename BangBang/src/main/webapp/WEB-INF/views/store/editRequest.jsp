<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${result > 0 }">
	<script>
		alert("가맹점 정보수정 신청 완료\n수정 처리까지 1~2일정도 소요됩니다.\n수정이 완료되면 이메일로 알려드립니다.");
		location.href="/bangbang/store/mypage";
	</script>
</c:if>
<c:if test="${result == 0 }">
	<script>
		alert("가맹점 정보수정 신청 실패");
		history.go(-1);
	</script>
</c:if>