<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${result > 0 }">
  <script>
    alert("회원정보 수정 완료");
    location.href="/bangbang/member/mypage/edit";
  </script>
</c:if>
<c:if test="${result == 0 }">
  <script>
    alert("회원정보 수정 실패");
    history.go(-1);
  </script>
</c:if>
