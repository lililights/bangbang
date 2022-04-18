<%@ page language="java" contentType="text/html; charset=UTF-8"//
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/frame/pageset_order.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 주문관리</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/order/order_list_admin.js?ver=2"/>"></script>

<script>
	const contextPath = '${pageContext.request.contextPath}';
	
	// 관리자 권한으로 요청한 주문 목록
	$(document).ready(function() {

		// 날짜 옵션값 설정
		$('#optPeriod').val(new Date().toISOString().substring(0, 10));

		// 페이지 로드시 ajax로 리스트 불러오기
		getList(contextPath);

		// 옵션값 변경에 따라 ajax로 리스트 불러오기
		$('#optPeriod, input[name="optStatus"]').on('change', function() {
			getList(contextPath);
		});

		// 회원 아이디 또는 가맹점명으로 검색했을때 ajax로 리스트 불러오기
		$('#search').on('click', function() {
			getList(contextPath);
		});

		// 선택 주문건 퀵 배송 요청
		$('#expressDel').on('click', function() {
			deliveryRequest('퀵', 'CJ대한통운');
		});

		// 선택 주문건 택배 배송 요청
		$('#parcelDel').on('click', function() {
			deliveryRequest('택배', 'CJ대한통운');
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
		<h3 class="mt-4 pb-3 font-italic">[ 주문관리 ]</h3>

		<ol class="breadcrumb mb-3 p-2">
			<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/main/mainpage">홈</a></li>
			<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin">관리자 페이지</a></li>
			<li class="breadcrumb-item active">주문관리</li>
		</ol>

		<div class="card mb-3">
			<div class="card-body">
				<form>
					<div class="form-row">
						<div class="col-auto">
							<input type="date" name="optPeriod" id="optPeriod"
								class="form-control">
						</div>
						<div class="col-auto">
							<select name="searchType" id="searchType" class="form-control">
								<option value="userid" selected>회원 아이디로 검색</option>
								<option value="sname">가맹점명으로 검색</option>
							</select>
						</div>
						<div class="col-auto">
							<input type="text" name="searchKeyword" id="searchKeyword"
								class="form-control">
						</div>
						<input type="button" id="search" value="검색"
							class="btn btn-primary">
					</div>

					<div class="mt-3">
						<input type="radio" name="optStatus" value="all" checked>
						전체 <input type="radio" name="optStatus" value="accepted"
							class="ml-2"> 주문완료 <input type="radio" name="optStatus"
							value="delivering" class="ml-2"> 배송진행중 <input
							type="radio" name="optStatus" value="pickupPro" class="ml-2">
						픽업가능 <input type="radio" name="optStatus" value="pickupCom"
							class="ml-2"> 픽업완료 <input type="radio" name="optStatus"
							value="etc" class="ml-2"> 기타 <br>
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

		<div class="float-right">
			<input type="button" id="expressDel" value="퀵 배송 요청"
				class="btn btn-primary"> <input type="button" id="parcelDel"
				value="택배 배송 요청" class="btn btn-primary">
		</div>
	</div>
</main>
	<%-- <%@include file="../includes/bangbang-footer.jsp"%> --%>
</body>
</html>
