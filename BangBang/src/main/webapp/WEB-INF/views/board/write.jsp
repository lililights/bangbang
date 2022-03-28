<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="../includes/bangbang-header.jsp"%>
	
<%@include file="../includes/bangbang-nav.jsp"%>
	
<script type="text/javascript" src="${pageContext.request.contextPath}/ckeditor/ckeditor.js"></script>
	<main role="main" class="container">
		<div class="my-3 p-3 bg-white rounded shadow-sm ">
			<h3>판매 게시물 등록</h3>
			<hr>
			<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/board/insert">

				<div class="form-group row">
					<input type="hidden" value="${item.iidx}" name="iidx" id="iidx" class="form-control" required>
				</div>
				<div class="margin-top first">
					<table class="table">
						<tbody>
							<tr>
								<th>제목</th>
								<td><input type="text" value="${item.name}" name="title" id="title" class="form-control" required></td>
							</tr>
							<tr>
								<th>영어 이름</th>
								<td><label for="ename" class="col-sm-2 col-form-label">${item.ename}</label></td>
							</tr>
							<tr>
								<th>용량</th>
								<td><label for="ml" class="col-sm-2 col-form-label">${item.ml}</label></td>
								<th>도수</th>
								<td><label for="proof" class="col-sm-2 col-form-label">${item.proof}</label></td>
							</tr>
							<tr>
								<th>국가</th>
								<td><label for="location" class="col-sm-2 col-form-label">${item.location}</label></td>
							</tr>
							<tr>
								<th>종류</th>
								<td><label for="type" class="col-sm-2 col-form-label">${item.type}</label></td>
							</tr>
							<tr>
								<th>맛</th>
								<td><label for="taste" class="col-sm-2 col-form-label">${item.taste}</label></td>
								<th>향</th>
								<td><label for="scent" class="col-sm-2 col-form-label">${item.scent}</label></td>
							</tr>
							<tr>
								<th>판매가</th>
								<td><label for="oprice" class="col-sm-2 col-form-label">${item.sprice}</label></td>
								<th>할인가</th>
								<td><label for="sprice" class="col-sm-2 col-form-label">${item.price}</label></td>
							</tr>
							<tr>
								<th>할인율</th>
								<td><label for="discount" class="col-sm-2 col-form-label">${item.discount}%</label></td>
							</tr>
							<tr>
								<th>추가정보</th>
								<td><label for="etc" class="col-sm-2 col-form-label">${item.etc}</label></td>
							</tr>
						</tbody>
					</table>
				</div>
				
				<div class="form-group row">
					<label for="thumb" class="col-sm-2 col-form-label">썸네일 등록</label>
					<div class="col-sm-10">
						<input type="file" name="thumb" id="thumb" class="form-control" required>
						<div class="select_img"><img src="" /></div>
						<script>
 							 $("#thumb").change(function(){
  							 	if(this.files && this.files[0]) {
  									 var reader = new FileReader;
    								 reader.onload = function(data) {
  							 			 $(".select_img img").attr("src", data.target.result).width(500);        
    								 }
   									 reader.readAsDataURL(this.files[0]);
 								 }
 							 });
 						</script>
					</div>
				</div>
				
				<div class="form-group row">
					<label for="photo1" class="col-sm-2 col-form-label">사진1 등록</label>
					<div class="col-sm-10">
						<input type="file" name="photo1" id="photo1" class="form-control" required>
						<div class="select_img2"><img src="" /></div>
						<script>
 							 $("#photo1").change(function(){
  							 if(this.files && this.files[0]) {
  							 var reader = new FileReader;
    						 reader.onload = function(data) {
  							  $(".select_img2 img").attr("src", data.target.result).width(500);        
    						 }
   							 reader.readAsDataURL(this.files[0]);
 							 }
 							 });
 						</script>
					</div>
				</div>
				
				<div class="form-group row">
					<label for="photo2" class="col-sm-2 col-form-label">사진2 등록</label>
					<div class="col-sm-10">
						<input type="file" name="photo2" id="photo2" class="form-control">
						<div class="select_img3"><img src="" /></div>
						<script>
 							 $("#photo2").change(function(){
  							 if(this.files && this.files[0]) {
  							 var reader = new FileReader;
    						 reader.onload = function(data) {
  							  $(".select_img3 img").attr("src", data.target.result).width(500);        
    						 }
   							 reader.readAsDataURL(this.files[0]);
 							 }
 							 });
 						</script>
					</div>
				</div>
				
				<div class="form-group row">
					<label for="pw" class="col-sm-2 col-form-label">내용</label>
					<div id="col-sm-10">
						<textarea id="content" name="content" ></textarea>
						<script type="text/javascript">
						$(function(){
							CKEDITOR.replace('content',{
								filebrowserUploadUrl: '${pageContext.request.contextPath}/mine/upload.do'	
							});
						});
						</script>
					</div>
				</div>
				
				<input type="submit" value="등록" class="btn  btn-primary"> 
				<input type="reset" class="btn btn-secondary"> 
			</form>
		</div>
	</main>

<%@include file="../includes/bangbang-footer.jsp"%>	