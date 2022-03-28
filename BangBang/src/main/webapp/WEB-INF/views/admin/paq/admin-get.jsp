<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../includes/hyunwoo-header.jsp"%>

<div class="row">
	<div class="col-lg-9" style="padding-left: 200px;">
		<h1 class="page-header">1:1 문의</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->


<div class="row">
	<div class="col-lg-9" style="padding-left: 200px;">
		<div class="panel panel-default">
			<div class="panel-heading">&nbsp;</div>
			<!-- /.panel-heading -->
			<div class="panel-body">


				<%-- 				<div class="form-group">
					<label>공지사항 번호</label> <input class="form-control" name='pqidx'
						value='<c:out value="${paq.pqidx}"/>' readonly='readonly'>

				</div> --%>




				<div class="form-group" style="display: inline;">

					<h2>
						<c:out value="${paq.title }" />
					</h2>

					<div
						style="color: rgb(0, 0, 0, 0.5); display: inline; float: right; padding-right: 10px;">
						<i class="fa-solid fa-clock"></i>
						<fmt:formatDate pattern="yyyy-MM-dd" value="${paq.regdate}" />
					</div>
				</div>

				<br>

				<hr style="border: solid 2px rgb(224, 224, 224);">



				<div class="form-group">
					<c:out value="${paq.content }" escapeXml="false" />

				</div>
					
				
				<br>
				<br>								
				
				<!-- 답변 내용 -->
				

				<div class="form-group">
					<c:out value="${paq.reply }" escapeXml="false" />

				</div>
				
				


				<br>
				<br>

				<button data-oper='replyRegister' class="btn btn-default">답변</button>
				
				<form id='operForm' action="${pageContext.request.contextPath}/admin/paq/reply-register" method="get" style="display: inline;">
					<input type='hidden' id='pqidx' name='pqidx'
						value='<c:out value="${paq.pqidx}"/>'> <input
						type='hidden' name='pageNum'
						value='<c:out value="${cri.pageNum}"/>'> <input
						type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
					<input type='hidden' name='start'
						value='<c:out value="${cri.start}"/>'>
									
				</form>
				
				
				
				
				
				
				
				<button data-oper='list' class="btn btn-info">목록</button>

				<form id='operForm' action="${pageContext.request.contextPath}/admin/paq/adminGet" method="get" style="display: inline;">
					<input type='hidden' id='pqidx' name='pqidx'
						value='<c:out value="${paq.pqidx}"/>'> <input
						type='hidden' name='pageNum'
						value='<c:out value="${cri.pageNum}"/>'> <input
						type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
					<input type='hidden' name='start'
						value='<c:out value="${cri.start}"/>'>
									
				</form>
				
				
				
				
				

				<form id='operForm' action="${pageContext.request.contextPath}/admin/paq/remove" method="post" style="display: inline;">
				
				<input type='hidden' id='pqidx' name='pqidx'
						value='<c:out value="${paq.pqidx}"/>'> <input
						type='hidden' name='pageNum'
						value='<c:out value="${cri.pageNum}"/>'> <input
						type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
					<input type='hidden' name='start'
						value='<c:out value="${cri.start}"/>'>
						
						
				<button type="submit" data-oper='remove' class="btn btn-default" style="background-color: rgb(255,0, 0, 70%); color: white;">삭제</button>
				
				
				</form>


			</div>
		</div>
	</div>
</div>


<%@include file="../../includes/hyunwoo-footer.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {

		var operForm = $("#operForm");

		$("button[data-oper='replyRegister']").on("click", function(e) {

			operForm.attr("action", "${pageContext.request.contextPath}/admin/paq/reply-register").submit();

		});
		
		
		$("button[data-oper='remove']").on("click", function(e) {

			operForm.attr("action", "${pageContext.request.contextPath}/admin/paq/remove").submit();

		});
		
		
		
		

		$("button[data-oper='list']").on("click", function(e) {

			operForm.find("#pqidx").remove();
			operForm.attr("action", "${pageContext.request.contextPath}/admin/paq/admin-list")
			operForm.submit();

		});

	});
</script>