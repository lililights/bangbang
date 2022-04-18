<%@ page language="java" contentType="text/html; charset=UTF-8"//
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/frame/pageset_order.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/order/web_storage.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/order/order_form.js?ver=6"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/order/payment.js?ver=3"/>"></script>
	
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=82fb75f3990a944f3392bc4d34af2cde&libraries=services"></script>

<c:if test="${linked eq null}">
	<script>
		// 장바구니에서 주문할시 로컬스토리지 객체 생성
		var key = "LocalCart" + ${loginInfo.uidx};
		var storage = new local();
		var cart = getCart(storage);
	</script>
</c:if>

<c:if test="${linked ne null}">
	<script>
		// 상품페이지에서 하나의 제품을 바로 주문할 시 세션스토리지 객체 생성
		var key = 'LinkedCart';
		var storage = new session(key);
		var cart = getCart(storage);
	</script>
</c:if>

<script>
const contextPath = '${pageContext.request.contextPath}';

	$(document).ready(function() {
						// 웹스토리지에 저장된 장바구니 목록 출력
						getCartItemInfo(contextPath);
						
						// 포인트 사용 적용
						$('#pointUse').focusout(function(){
							let pointLeft = '${orderReqMemberInfo.point}'-$('#pointUse').val();
							
							if(pointLeft < 1){
								alert('사용가능 포인트는 ${orderReqMemberInfo.point}원 입니다.');
								
							}else{
								let totalpay = $('#amount').val()-$('#pointUse').val()
								
								if(totalpay>=0){
									$('#point').html(moneyEx(pointLeft));
									$('#totalPay').html(moneyEx(totalpay));
									
								}else{
									alert('총 결제 금액을 초과하였습니다.');
								}
							}
						});

						// 주문 버튼 클릭
						$('#submitOrder').click(function() {
							
							if ($('#sidx').val() == ''){
								alert('선택된 매장이 없습니다.');
								
							}else{
								
								// 아임포트 결제 API 실행
								iamportPayment(contextPath);
								
							}
						});
						
					});
</script>
</head>

<style>
th, td {
	text-align: center;
}

#main_container {
  display: inline-block;
  width: 500px;
  margin-top: 50px;
  border: 1px solid black;
  border-radius: 15px;
  padding: 10px 10px;
}
</style>

<body>
<%-- <c:if test="${loginInfo ne null}">
	<%@include file="../includes/bangbang-header.jsp"%>
	<%@include file="../includes/bangbang-nav.jsp"%>
</c:if>
<c:if test="${storeInfo ne null}">
	<%@include file="../includes/store-header.jsp"%>
	<%@include file="../includes/store-nav.jsp"%>
</c:if>
<c:if test="${adminInfo ne null}">
	<%@include file="../includes/admin-header.jsp"%>
	<%@include file="../includes/admin-nav.jsp"%>
</c:if> --%>

<main class="container">
	<div class="container-fluid px-4">
		<h3 class="mt-4 pb-3 font-italic">[ 주문 ]</h3>

		<ol class="breadcrumb mb-3 p-2">
			<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/main/mainpage">홈</a></li>
			<li class="breadcrumb-item active">주문서 작성</li>
		</ol>
		
			<div class="float-left">
			<%@ include file="/WEB-INF/views/order/map.jsp"%>
	<br>
			
		<c:if test="${OrderReqStoreInfo ne null}">
		<h5 class="font-weight-bold"><u>선택한 픽업 매장</u></h5>
		<div class="py-2">
		<small>가맹점명</small><br>
		<h6 class="font-weight-bold">${OrderReqStoreInfo.sname}</h6>
		<small>가맹점 연락처</small><br>
		<h6 class="font-weight-bold">${OrderReqStoreInfo.sphone}</h6>
		<small>가맹점 주소</small><br>
		<h6 class="font-weight-bold">${OrderReqStoreInfo.address}</h6>
		</div>
		</c:if>
		<c:if test="${OrderReqStoreInfo eq null}">
<h5 class="font-weight-bold"><u>픽업할 매장을 선택해주세요.</u></h5>
		</c:if>
		
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
 가맹점 번호(hidden)<input type="text" name="sidx" id="sidx" value="${OrderReqStoreInfo.sidx}"><br>
		<div>대표상품명(hidden)<input type="text" name="item" id="item"></div>
	<div><input type="text" name="amount" id="amount" hidden></div>
	<div><input type="text" name="uidx" id="uidx" value="${orderReqMemberInfo.uidx}" hidden></div>
	</div>

<div class="float-right">
<div class="float-right">
			<div class="card mb-3">
			<table id="list" class="table table-hover">
				<thead>
					<tr>
						<td colspan="6">목록을 불러오는 중입니다...</td>
					</tr>
				</thead>
			</table>
		</div>
		</div>
		<div class="clearfix"></div>
		
		<div class="float-right">
			<div class="text-right p-1"><small>주문자명</small></div>
			<div class="input-group input-group-sm mb-2" style="width: 300px">
				<input type="text" name="name" id="name" class="form-control text-right" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm"
				value="${orderReqMemberInfo.username}" required>
			</div>
			<div class="text-right p-1"><small>연락처</small></div>
			<div class="input-group input-group-sm mb-2" style="width: 300px">
				<input type="text" name="phone" id="phone" class="form-control text-right" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm"
				value="${orderReqMemberInfo.phonenum}" required>
			</div>
			<div class="text-right p-1"><small>쇼핑몰/매장 전달사항</small></div>
			<div class="input-group input-group-sm mb-2" style="width: 300px">
				<input type="text" name="msg" id="msg" class="form-control text-right" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm">
			</div>
			</div>
			<div class="clearfix"></div>
			<br>
			<br>
		
		<div class="float-right">
			<table>
				<tr>
					<td class="text-right pr-4">상품금액</td>
					<td class="text-right"><h5 id=totalPrice></h5></td>
				</tr>
				<tr>
					<td class="text-right pr-4">할인금액</td>
					<td class="text-right"><h5 id="discount"></h5></td>
				</tr>
				<tr>
					<td class="text-right pr-4">포인트 사용</td>
					<td class="text-right"><div class="input-group input-group-sm mb-2"><input type="number" min="0" name="pointUse" id="pointUse" value="0" class="form-control text-right" aria-label="Sizing example input"
					aria-describedby="inputGroup-sizing-sm" style="width: 150px; height: 28px;"></div></td>
				</tr>
				<tr>
					<td class="text-right" colspan="2"><small>(사용가능 포인트 : <span id="point">${orderReqMemberInfo.point}</span>원)</small></td>
				</tr>
				<tr><td colspan="2"><hr></td></tr>
				<tr>
					<td class="text-right pr-4">총 결제 금액</td>
					<td class="text-right"><h3 id="totalPay"></h3></td>
				</tr>
				<tr><td colspan="2"><hr></td></tr>
				<tr><td></td><td class="text-right"><input type="button" value="주문하기" id="submitOrder" class="btn btn-primary"></td></tr>
				</table>
			</div>
			</div>
			<div class="clearfix"></div>
	</div>
</main>
<%-- 	<%@include file="../includes/bangbang-footer.jsp"%> --%>
</body>
</html>