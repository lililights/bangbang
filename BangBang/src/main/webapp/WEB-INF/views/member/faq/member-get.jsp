<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../includes/bangbang-header.jsp"%>

<%@include file="../../includes/bangbang-nav.jsp"%>

<%@include file="../../includes/hyunwoocss.jsp"%>


<main class="container">

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">자주묻는 질문(FAQ)</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->


<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">&nbsp;</div>
			<!-- /.panel-heading -->
			<div class="panel-body">


				<%-- 				<div class="form-group">
					<label>공지사항 번호</label> <input class="form-control" name='fqidx'
						value='<c:out value="${faq.fqidx}"/>' readonly='readonly'>

				</div> --%>




				<div class="form-group" style="display: inline;">

					<h2>
						<c:out value="${faq.title }" />
					</h2>


					<div
						style="color: rgb(0, 0, 0, 0.5); display: inline; float: right; padding-right: 10px;">
						<i class="fa-solid fa-clock"></i>
						<fmt:formatDate pattern="yyyy-MM-dd" value="${faq.regdate}" />
					</div>
				</div>

				<br>

				<hr style="border: solid 2px rgb(224, 224, 224);">



				<div class="form-group">
					<c:out value="${faq.content }" escapeXml="false" />

				</div>



				<br>


				<button data-oper='list' class="btn btn-info">목록</button>

				<form id='operForm' action="${pageContext.request.contextPath}/member/faq/modify" method="get">
					<input type='hidden' id='fqidx' name='fqidx'
						value='<c:out value="${faq.fqidx}"/>'> <input
						type='hidden' name='pageNum'
						value='<c:out value="${cri.pageNum}"/>'> <input
						type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
					<input type='hidden' name='start'
						value='<c:out value="${cri.start}"/>'>

				</form>




			</div>
		</div>
	</div>
</div>

</main>


<%@include file="../../includes/bangbang-footer.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {

		var operForm = $("#operForm");

		$("button[data-oper='modify']").on("click", function(e) {

			operForm.attr("action", "${pageContext.request.contextPath}/member/faq/modify").submit();

		});

		$("button[data-oper='list']").on("click", function(e) {

			operForm.find("#fqidx").remove();
			operForm.attr("action", "${pageContext.request.contextPath}/member/faq/member-list")
			operForm.submit();

		});

	});
</script>