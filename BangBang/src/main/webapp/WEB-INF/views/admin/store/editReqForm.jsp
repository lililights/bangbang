<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>가맹점 정보 수정 요청</title>
<link rel="stylesheet" href="/bangbang/resources/css/container.css">
  </head>
  <body>
    <%@include file="../../includes/admin-header.jsp"%> <%@include
    file="../../includes/admin-nav.jsp"%>
    <div id="body_container">
      <div id="main_container" class="text-center">
        <form method="post">
          <input type="hidden" name="sidx" value="${store.sidx}" />
          <table>
            <tr>
              <td>가맹점명</td>
              <td>
                <span>${store.sname}</span>
                <input
                  type="hidden"
                  name="sname"
                  value="${store.sname}"
                  required
                />
              </td>
            </tr>
            <tr>
              <td>가맹점 번호</td>
              <td>
                <span>${store.sphone}</span>
                <input
                  type="hidden"
                  name="sphone"
                  value="${store.sphone}"
                  required
                />
              </td>
            </tr>
            <tr>
              <td>가맹점 주소</td>
              <td>
                <span>${store.address}</span>
                <input
                  type="hidden"
                  name="address"
                  value="${store.address}"
                  required
                />
              </td>
            </tr>
          </table>
          <button id="cancel_btn">거절</button>
          <button id="edit_btn" type="submit">수정</button>
        </form>
      </div>
    </div>
    <%@include file="../../includes/bangbang-footer.jsp"%>
    <script>
      $("#cancel_btn").click(function () {
        alert("요청을 거절하였습니다.");
      });
    </script>
  </body>
</html>
