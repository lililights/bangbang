<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../includes/bangbang-header.jsp"%>
<%@include file="../includes/bangbang-nav.jsp"%>

<main class="main">
	<h2 class="main title">목록</h2>
	<div class="search-form margin-top first align-right">
		<h3 class="hidden">상품 검색</h3>
		<form class="table-form">
			<fieldset>
				<legend class="hidden">검색</legend>
				<label class="hidden">검색분류</label> 
				<div class="col-auto">
				<select name="searchType" class="form-control">
					<option value="name"
								${param.searchType eq 'name' ? 'selected' : ''}>이름</option>
					<option value="ename"
								${param.searchType eq 'ename' ? 'selected' : ''}>영어 이름</option>
				</select> 
				</div>
					<div class="col-auto">
						<input type="text" name="keyword" class="form-control"
							value="${param.keyword}">
					</div>
					<div class="col-auto">
						<input type="submit" value="검색" class="btn btn-primary">
					</div>
			</fieldset>
		</form>
	</div>
	<div class="border mt-3 p-2">전체 상품 수: ${item.totalCount}개 ,
				현재 페이지: ${item.currentPage}/${item.pageTotalCount}</div>
	
	<div class="notice margin-top">
		<h3 class="hidden">상품 목록</h3>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>영어 이름</th>
					<th>용량</th>
					<th>도수</th>
					<th>원산지</th>
					<th>종류</th>
					<th>맛</th>
					<th>향</th>
					<th>원가</th>
					<th>판매가</th>
					<th>할인율</th>
					<th>재고</th>
					<th>추가정보</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty item.list}">
			    <tr>
					<td colspan="7">등록된 상품 데이터가 없습니다.</td>
				</tr>
				</c:if>
				<c:if test="${not empty item.list}" >

				<c:forEach var="list" items="${item.list}">
				<tr>
					<td style="text-align: center">${list.iidx}</td>
					<td>${list.name}</td>
					<td>${list.ename}</td>
					<td style="text-align: center">${list.ml}</td>
					<td style="text-align: center">${list.proof}</td>
					<td style="text-align: center">${list.location}</td>
					<td style="text-align: center">${list.type}</td>
					<td style="text-align: center">${list.taste}</td>
					<td style="text-align: center">${list.scent}</td>
					<td style="text-align: center">${list.oprice}</td>
					<td style="text-align: center">${list.sprice}</td>
					<td style="text-align: center">${list.discount}</td>
					<td style="text-align: center">${list.qty}</td>
					<td style="text-align: center">${list.etc}</td>
					<td><a href="${pageContext.request.contextPath}/item/update?iidx=${list.iidx}">수정</a> 
					<a href="javascript:delItem(${list.iidx})">삭제</a></td>
					<td><a href="${pageContext.request.contextPath}/board/write?iidx=${list.iidx}">게시물 등록</a>
				</tr>
				</c:forEach>
				</c:if>
			</tbody>
		</table>
			<a href="${pageContext.request.contextPath}/item/write"><button type="button" id="btnWrite">등록</button></a>
	</div>
	<div class="btn-toolbar" role="toolbar" >
				<div class="btn-group mr-2" role="group">
				
					<c:if test="${item.pageTotalCount > 0}">
		
						<c:forEach begin="1" end="${item.pageTotalCount}" var="pnum">
							<a
								href="list?p=${pnum}&searchType=${param.searchType}&keyword=${param.keyword}"
								class="btn ${item.currentPage eq pnum ? 'btn-dark': 'btn-white'}">${pnum}</a>
						</c:forEach>
		
					</c:if>
				
					
				</div>
				
			</div>
	
			<script>
		function delItem(iidx) {
			if (confirm("해당 회원 정보를 삭제하시겠습니까?")) {
				location.href = '${pageContext.request.contextPath}/item/delete?iidx=' + iidx;
			}
		}
	</script>
</main>

<%@include file="../includes/bangbang-footer.jsp"%>