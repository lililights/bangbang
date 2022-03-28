<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/hyunwoo/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="${pageContext.request.contextPath}/resources/hyunwoo/vendor/metisMenu/metisMenu.min.css"
	rel="stylesheet">

<!-- DataTables CSS -->
<link
	href="${pageContext.request.contextPath}/resources/hyunwoo/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link
	href="${pageContext.request.contextPath}/resources/hyunwoo/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="${pageContext.request.contextPath}/resources/hyunwoo/dist/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/resources/hyunwoo/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<script src="https://kit.fontawesome.com/ba424bfb3c.js"
	crossorigin="anonymous"></script>


<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>

<div class="container" style="padding-top: 10px;">
	<nav class="nav d-flex justify-content-between">
		<a class="nav-font"
			href="${pageContext.request.contextPath}/store/mypage"
			style="padding-top: 10px;">가맹점 정보 보기</a>
			<a class="nav-font"
			href="${pageContext.request.contextPath}/order/store/${storeInfo.sidx}/list"
			style="padding-top: 10px;">주문 보기</a> 
			<a class="nav-font"
			href="${pageContext.request.contextPath}/store/mypage/fee"
			style="padding-top: 10px;">가맹점 수수료 보기</a>
	</nav>

	<hr style="color: gray;">
</div>





