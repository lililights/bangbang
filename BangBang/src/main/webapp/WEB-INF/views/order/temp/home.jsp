<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
			<title>Home</title>
		</head>

		<body>

			<ul>
				<li><a href="${pageContext.request.contextPath}/order">orderform</a></li>
				<li><a href="${pageContext.request.contextPath}/cart/item">item page</a></li>
				<li><a href="${pageContext.request.contextPath}/cart">cart list</a></li>
				<li><a href="${pageContext.request.contextPath}/temp/order-list">order list</a></li>
			</ul>

			<button onclick="location.href='login/member'">Member login</button>
			<button onclick="location.href='login/store'">Store login</button>
			<button onclick="location.href='login/admin'">Admin login</button>
			<button onclick="location.href='logout'">logout</button>

		</body>
		</html>