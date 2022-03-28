<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../includes/hyunwoo-header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">새 FAQ 등록</h1>
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








				<form role="form" action="${pageContext.request.contextPath}/admin/faq/register" method="post">
					<div class="form-group">

					

						<label>제목</label> <input class="form-control" name='title'>

					</div>


						<th>내용</th>
						<td><textarea id="content" name="content" ></textarea> 
						<script
								type="text/javascript">
							// 글쓰기 editor 및 사진 업로드 기능
							CKEDITOR.replace('content', {
								filebrowserUploadUrl : '${pageContext.request.contextPath}/admin/faq/imageUpload'
							});
						</script></td> 
	
					<br>
					
				


					<button type="submit" class="btn btn-default">등록</button>

				</form>

			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<%@include file="../../includes/hyunwoo-footer.jsp"%>



