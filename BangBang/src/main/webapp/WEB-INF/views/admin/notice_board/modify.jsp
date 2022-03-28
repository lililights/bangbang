<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../includes/hyunwoo-header.jsp"%>

<div class="row">
	<div class="col-lg-9" style="padding-left: 200px;">
		<h1 class="page-header">공지사항 수정/삭제</h1>
	</div>
</div>


<div class="row">
	<div class="col-lg-9" style="padding-left: 200px;">
		<div class="panel panel-default">
			<div class="panel-heading">&nbsp;</div>
			<!-- /.panel-heading -->
			<div class="panel-body">

				<form role="form" action="${pageContext.request.contextPath}/admin/notice_board/modify" method="post">

					<input type='hidden' name='pageNum'
						value='<c:out value="${cri.pageNum }"/>'> <input
						type='hidden' name='amount'
						value='<c:out value="${cri.amount }"/>'> <input
						type='hidden' name='start' value='<c:out value="${cri.start }"/>'>



					<div class="form-group">
						<input type='hidden' class="form-control" name='nidx'
							value='<c:out value="${board.nidx}"/>' readonly='readonly'>

					</div>

					<div class="form-group">
						<label>제목</label> <input class="form-control" name='title'
							value='<c:out value="${board.title }"/>'>
					</div>

					<div class="form group">
						<tr>
							<th>내용</th>
							<td><textarea id="content" name="content">${board.content}</textarea>
								<script type="text/javascript">
									// 글쓰기 editor 및 사진 업로드 기능
									CKEDITOR
											.replace(
													'content',
													{
														filebrowserUploadUrl : '${pageContext.request.contextPath}/admin/notice_board/imageUpload'
													});
								</script></td>

					</div>

					<br>


					<div class="form-group">
						<label>등록일</label> <input class="form-control" name='regDate'
							value='<fmt:formatDate pattern = "yyyy/MM/dd" value="${board.regdate }"/>'
							readonly='readonly'>
					</div>

					<div class="form-group">
						<label>수정일</label> <input class="form-control" name='updateDate'
							value='<fmt:formatDate pattern = "yyyy/MM/dd" value="${board.updatedate }"/>'
							readonly='readonly'>
					</div>

					<br>
					
					<button type="submit" data-oper='modify' class="btn btn-default">수정</button>
					<button type="submit" data-oper='remove' class="btn btn-default" style="background-color: rgb(255,0, 0, 70%); color: white;">삭제</button>
					<button type="submit" data-oper='list' class="btn btn-info">목록</button>

				</form>
			</div>
		</div>
	</div>
</div>




<%@include file="../../includes/hyunwoo-footer.jsp"%>

<script type="text/javascript">
	$(document)
			.ready(
					function() {

						var formObj = $("form");

						$('button')
								.on(
										"click",
										function(e) {

											e.preventDefault();

											var operation = $(this)
													.data("oper");

											console.log(operation);

											if (operation === 'remove') {
												formObj
														.attr("action",
																"${pageContext.request.contextPath}/admin/notice_board/remove");
											} else if (operation === 'list') {
												//move to list
												formObj.attr("action",
														"${pageContext.request.contextPath}/admin/notice_board/list")
														.attr("method", "get");
												var pageNumTag = $(
														"input[name='pageNum']")
														.clone();
												var amountTag = $(
														"input[name='amount']")
														.clone();
												var startTag = $(
														"input[name='start']")
														.clone();

												formObj.empty();

												formObj.append(pageNumTag);
												formObj.append(amountTag);
												formObj.append(startTag);
											}
											formObj.submit();

										});

					});
</script>