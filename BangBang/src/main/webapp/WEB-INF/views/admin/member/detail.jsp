<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>회원 상세정보</title>
<link rel="stylesheet" href="/bangbang/resources/css/container.css">
  <style type="text/css">
      table{
      	width: 100%;
      }
      img{
      	border-radius: 15px;
      }
    </style>
</head>
<body>
<%@include file="../../includes/admin-header.jsp"%>
<%@include file="../../includes/admin-nav.jsp"%>
	<div id="body_container">
		<div id="main_container">
			<table>
				<thead>
					<tr>
						<th colspan="2" style="text-align: center;"><br>${member.username}<hr></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>프로필</td>
						<td><c:if test="${member.sns == true}">
								<img src="${member.photo}" width="200px" height="200px"><hr>
							</c:if> <c:if test="${member.sns == false}">
								<img
									src="${pageContext.request.contextPath}/resources/uploadfile/${member.photo}"
									width="200px" height="200px" /><hr>
							</c:if></td>
					</tr>
					<c:if test="${member.sns == false }">
						<tr>
							<td>아이디<hr></td>
							<td>${member.userid}<hr></td>
						</tr>
					</c:if>
					<tr>
						<td>생년월일<hr></td>
						<td>${member.birth}<hr></td>
					</tr>
					<tr>
						<td>전화번호<hr></td>
						<td>${member.phonenum}<hr></td>
					</tr>
					<tr>
						<td>이메일<hr></td>
						<td>${member.email}<hr></td>
					</tr>
					</table>
					<br>
					<table>
					<tr>
						<td colspan="2" style="font-weight: bolder;">광고 및 알람 수신동의<hr></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td>${member.enotify == true ? '허용' : '비허용'}</td>
					</tr>
					<tr>
						<td>문자</td>
						<td>${member.mnotify == true ? '허용' : '비허용'}</td>
					</tr>
					<tr>
						<td>카카오톡</td>
						<td>${member.snotify == true ? '허용' : '비허용'}</td>
					</tr>
					<tr>
						<td><hr>회원가입일<br></td>
						<td><hr>${member.regdate}<br></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<%@include file="../../includes/bangbang-footer.jsp"%>
</body>
</html>
