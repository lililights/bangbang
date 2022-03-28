<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/bangbang-header.jsp"%>
	
<%@include file="../includes/bangbang-nav.jsp"%>

<body>

	<div>
		<h3>상품 정보 수정</h3>
		<hr>
		<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/board/update">
			<table>
				<tr>
					<th>제목</th>
					<td><input type="hidden" name="iidx" value="${board.iidx}"> 
					<input type="text" value="${board.title}" name="title" id="title" class="form-control" required></td>
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
					<th>원가</th>
					<td><label for="oprice" class="col-sm-2 col-form-label">${item.oprice}</label></td>
					<th>판매가</th>
					<td><label for="sprice" class="col-sm-2 col-form-label">${item.sprice}</label></td>
				</tr>
				<tr>
					<th>할인율</th>
					<td><label for="discount" class="col-sm-2 col-form-label">${item.discount}%</label></td>
				</tr>
				<tr>
					<th>추가정보</th>
					<td><label for="etc" class="col-sm-2 col-form-label">${item.etc}</label></td>
				</tr>
			</table>
			<div class="form-group row">
					<label for="username" class="col-sm-2 col-form-label">썸네일 등록</label>
					<div class="col-sm-10">
						현재 파일 : 
						<c:if test="${not empty board.thumb}">
						<img id="oldfile" src="${pageContext.request.contextPath}/uploadfile/${board.thumb}"><br>
						</c:if>
						<input type="hidden" name="oldfile" value="${board.thumb}">
						<input type="file" name="thumb" id="thumb"  class="form-control">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="username" class="col-sm-2 col-form-label">사진1 등록</label>
					<div class="col-sm-10">
						현재 파일 : 
						<c:if test="${not empty board.photo1}">
						<img id="oldfile" src="${pageContext.request.contextPath}/uploadfile/${board.photo1}"><br>
						</c:if>
						<input type="hidden" name="oldfile" value="${board.photo1}">
						<input type="file" name="photo1" id="photo1"  class="form-control">
					</div>
				</div>
				
				<div class="form-group row">
					<label for="username" class="col-sm-2 col-form-label">사진2 등록</label>
					<div class="col-sm-10">
						현재 파일 : 
						<c:if test="${not empty board.photo2}">
						<img id="oldfile" src="${pageContext.request.contextPath}/uploadfile/${board.photo2}"><br>
						</c:if>
						<input type="hidden" name="oldfile" value="${board.photo2}">
						<input type="file" name="photo2" id="photo2"  class="form-control">
					</div>
				</div>
				<div class="form-group row">
					<label for="pw" class="col-sm-2 col-form-label">내용</label>
					<div id="col-sm-10">
						<textarea id="content" name="content" >${board.content}</textarea>
					<script>
 						var ckeditor_config = {
 				   		resize_enaleb : false,
 				   		enterMode : CKEDITOR.ENTER_BR,
   						shiftEnterMode : CKEDITOR.ENTER_P,
  						filebrowserUploadUrl : "/uploadfile"
						};
 
 						CKEDITOR.replace("content", ckeditor_config);
					</script>
					</div>
				</div>
				
				<div><input type="submit" value="수정"> <input type="reset"></div>
				
		</form>
	
	</div>
</body>
<%@include file="../includes/bangbang-footer.jsp"%>