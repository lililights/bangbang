<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/order/web_storage.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/order/item_to_cart.js"/>"></script>

<script>
	$(document).ready(function() {

		$('#addCart').click(function() {
			addCart();
		});

		$('#insertOrder').click(function() {
			insertOrder();
		});
	});
</script>

<c:if test="${loginInfo ne null}">
	<script>
		// 로그인시 로컬스토리지 객체 생성
		var key = 'LocalCart' + ${loginInfo.uidx};
		var storage = new local(key);
		var cart = getCart(storage);
	</script>
</c:if>

<c:if test="${loginInfo eq null}">
	<script>
		// 비로그인시 세션스토리지 객체 생성
		var key = 'SessionCart';
		var storage = new session(key);
		var cart = getCart(storage);
	</script>
</c:if>
</head>

<body>
	<h1>제품 상세 페이지</h1>

	<table>
		<tr>
			<td>상품번호</td>
			<td><input type="text" name="iidx" id="iidx"></td>
		</tr>
		<tr>
			<td>수량</td>
			<td>
				<button onclick="checkQty(Number($('#qty').val()) - 1)">-</button> <input
				onchange="checkQty(Number($(this).val()))" type="text" name="qty"
				id="qty" value="1">
				<button onclick="checkQty(Number($('#qty').val()) + 1)">+</button>
			</td>
		</tr>

	</table>
	<button id="addCart">장바구니 담기</button>
	<button id="insertOrder">주문하기</button>
</body>
</html>