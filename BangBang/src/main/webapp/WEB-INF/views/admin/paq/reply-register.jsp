<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../includes/hyunwoo-header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">1:1 문의 답변</h1>
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




				<div class="form-group" style="display: inline;">

					<h4 style="font-weight: bold;">
						<c:out value="[제목]" />
						</h4>
						
						
						
					<h4>						
						<c:out value="${paq.title }" />
					</h4>


				</div>

				

				<br>


				<div class="form-group">
					<h4 style="font-weight: bold;"><c:out value="[문의 내용]" escapeXml="false" /></h4>
					<h4><c:out value="${paq.content }" escapeXml="false" /></h4>

				</div>
				<br>
				<br>								



				<form role="form" action="${pageContext.request.contextPath}/admin/paq/reply-register" method="post" >


					<div class="form-group">
						<input type='hidden' class="form-control" name='pqidx'
							value='<c:out value="${paq.pqidx}"/>' readonly='readonly'>

					</div>
					
					

					<hr style="border: solid 2px rgb(224, 224, 224);">

					<!-- <h4 style="font-weight: bold;">[답변]</h4> -->
					<td><textarea id="content" name="reply">${paq.reply}</textarea> <script
							type="text/javascript">
						// 글쓰기 editor 및 사진 업로드 기능
						CKEDITOR.replace('content', {
							filebrowserUploadUrl : '${pageContext.request.contextPath}/admin/paq/imageUpload'
						});
					</script></td> <br>


					<button type="submit" class="btn btn-default">등록/수정</button>
						

					

				</form>
				
				
				
				<form action="${pageContext.request.contextPath}/admin/paq/mailSend" method="post">
					
						<div class="form-group">
						<input type='hidden' class="form-control" name='pqidx'
						value='<c:out value="${paq.pqidx}"/>' readonly='readonly'>
						</div>
					
					
					
						<div class="form-group">
						<input type='hidden' class="form-control" name='uidx'
						value='<c:out value="${paq.uidx}"/>' readonly='readonly'>
						</div>
						
						
						
						
						
						<button type="submit" class="btn btn-info">알림 메일 전송</button>
						
					</form>
					
					
					<form action="${pageContext.request.contextPath}/admin/paq/smsSend" method="post">
					
						<div class="form-group">
						<input type='hidden' class="form-control" name='pqidx'
						value='<c:out value="${paq.pqidx}"/>' readonly='readonly'>
						</div>
					
					
					
						<div class="form-group">
						<input type='hidden' class="form-control" name='uidx'
						value='<c:out value="${paq.uidx}"/>' readonly='readonly'>
						</div>
						
						
						
						
						
						<button type="submit" class="btn btn-info">알림 문자 전송</button>
						
					</form>
					
					
					
					
					
					
				<form id='operForm' action="${pageContext.request.contextPath}/admin/paq/admin-get" method="get" style="padding-top: 15px;">
					<input type='hidden' id='pqidx' name='pqidx'
						value='<c:out value="${paq.pqidx}"/>'> <input
						type='hidden' name='pageNum'
						value='<c:out value="${cri.pageNum}"/>'> <input
						type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
					<input type='hidden' name='start'
						value='<c:out value="${cri.start}"/>'>

				</form>
				
					
					
					<button data-oper='back' class="btn btn-default">뒤로 가기</button>
					
					
					
					
					
					
					
					
					
					
					
					

			<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModal1Label" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModal1Label">방방술래 서비스 관리</h4>
							</div>
							<div class="modal-body">알림 메일 전송이 완료되었습니다.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary"
									data-dismiss="modal">닫기</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
				
			<!-- Modal -->
				<div class="modal fade" id="myModalSms" tabindex="-1" role="dialog"
					aria-labelledby="myModal1Label" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModal1Label">방방술래 서비스 관리</h4>
							</div>
							<div class="modal-body">알림 문자 전송이 완료되었습니다.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary"
									data-dismiss="modal">닫기</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
				
				
				
				
			<!-- Modal -->
				<div class="modal fade" id="answerModal" tabindex="-1" role="dialog"
					aria-labelledby="myModal1Label" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModal1Label">방방술래 서비스 관리</h4>
							</div>
							<div class="modal-body">답변 등록이 완료되었습니다.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-primary"
									data-dismiss="modal">닫기</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->
				
				
					
					

			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<%@include file="../../includes/hyunwoo-footer.jsp"%>


<script type="text/javascript">
	$(document).ready(function() {

						var result = '<c:out value="${result}"/>';

						checkModal(result);

						history.replaceState({}, null, null);

						function checkModal(result) {

							if (result === '' || history.state) {
								return;
							} else if(result === 'answer') {
								
								$("#answerModal").modal("show");
							} else if(result === 'success') {
								$("#myModal").modal("show");
							} else if(result === 'successSms') {
								$("#myModalSms").modal("show");
							}
							
						}
						
						
						
						var operForm = $("#operForm");

						$("button[data-oper='back']").on("click", function(e) {

							operForm.attr("action", "${pageContext.request.contextPath}/admin/paq/admin-get").submit();

						});
						
						
						

						
						
						
	});


</script>
