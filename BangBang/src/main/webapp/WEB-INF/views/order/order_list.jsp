<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/frame/pageset_order.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문목록</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/order/order_list.js?ver=7"/>"></script>

<c:if test="${loginInfo ne null}">
	<script>
		// 일반회원 권한으로 요청한 주문 목록
		$(document).ready(function() {

			// 옵션값 <select> 에 출력할 기간 설정
			setPeriodOption(new Date());

			// 페이지 로드시 ajax로 리스트 불러오기
			getListMember(${loginInfo.uidx});

			// 옵션값 변경에 따라 ajax로 리스트 불러오기
			$('#optPeriod, input[name="optStatus"]').on('change', function() {
				getListMember(${loginInfo.uidx});
			});
		});
	</script>
</c:if>

<c:if test="${storeInfo ne null}">
	<script>
		// 가맹점 권한으로 요청한 주문 목록
		$(document).ready(function() {

			// 옵션값 <select> 에 출력할 기간 설정
			setPeriodOption(new Date());

			// 페이지 로드시 ajax로 리스트 불러오기
			getListStore(${storeInfo.sidx});

			// 옵션값 변경에 따라 ajax로 리스트 불러오기
			$('#optPeriod, input[name="optStatus"]').on('change', function() {
				getListStore(${storeInfo.sidx});
			});
		});
	</script>
</c:if>
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
  box-shadow: 5px 5px 7px rgb(0, 0, 0, 0.5);
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
		<h3 class="mt-4 pb-3 font-italic">[ 주문목록 ]</h3>

		<ol class="breadcrumb mb-3 p-2">
			<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/main/mainpage">홈</a></li>
			<c:if test="${loginInfo ne null}">
				<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/member/mypage">내 정보</a></li>
			</c:if>
			<c:if test="${storeInfo ne null}">
				<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/store/mypage">가맹점 정보</a></li>
			</c:if>
			<li class="breadcrumb-item active">주문목록</li>
		</ol>

		<div class="card mb-3">
			<div class="card-body">
				<form>
					<div class="form-row">
						<div class="col-auto">
							<select id="optPeriod" class="form-control">
								<option id="month0" value="recent" selected>최근 30일</option>
								<option id="month1"></option>
								<option id="month2"></option>
								<option id="month3"></option>
								<option id="month4"></option>
								<option id="month5"></option>
							</select>
						</div>
					</div>
					<div class="mt-3">
						<input type="radio" name="optStatus" value="all" checked>
						전체 <input type="radio" name="optStatus" value="accepted"
							class="ml-2"> 주문완료 <input type="radio" name="optStatus"
							value="processing" class="ml-2"> 배송진행중 <input
							type="radio" name="optStatus" value="available" class="ml-2">
						픽업가능 <input type="radio" name="optStatus" value="complete"
							class="ml-2"> 픽업완료 <input type="radio" name="optStatus"
							value="etc" class="ml-2"> 기타
					</div>
				</form>
			</div>
		</div>

		<div class="card mb-3">
			<table id="orderList" class="table table-hover">
				<thead>
					<tr>
						<td colspan="5">주문 목록을 불러오는 중입니다...</td>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</main>
<%-- 	<%@include file="../includes/bangbang-footer.jsp"%> --%>
</body>
</html>