<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/bangbang-header.jsp"%>
	
<%@include file="../includes/bangbang-nav.jsp"%>

<main class="main">
  <div class="album py-5 bg-light">
    	<div class="search-form margin-top first align-right">
		<h3 class="hidden">상품 게시물 검색</h3>
		<form class="table-form">
			<fieldset>
				<legend class="hidden">검색</legend>
				<label class="hidden">검색분류</label> 
				<div class="col-auto">
				<select name="searchType" class="form-control">
					<option value="name"
								${param.searchType eq 'title' ? 'selected' : ''}>제목</option>
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
	<div class="border mt-3 p-2">전체 상품 수: ${board.totalCount}개 ,
				현재 페이지: ${board.currentPage}/${board.pageTotalCount}</div>

    <div class="container">
		<c:if test="${empty board.list}">
			  <h3>등록된 상품이 없습니다.</h3>
		</c:if>
		
		<c:if test="${not empty board.list}" >

		<c:forEach var="list" items="${board.list}">
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
        <div class="col">
          <div class="card shadow-sm">
            <image src="${pageContext.request.contextPath}/uploadfile/${list.thumb}">

            <div class="card-body">
              <p class="card-text">${list.title}</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <a href="${pageContext.request.contextPath}/board/detail?iidx=${list.iidx}"><button type="button" class="btn btn-sm btn-outline-secondary">View</button></a>
                  <a href="${pageContext.request.contextPath}/board/update?iidx=${list.iidx}"><button type="button" class="btn btn-sm btn-outline-secondary">Edit</button></a>
                  <a href="${pageContext.request.contextPath}/board/delete?iidx=${list.iidx}"><button type="button" class="btn btn-sm btn-outline-secondary">delete</button></a>
                </div>
                <small class="text-muted">${list.hits}</small>
              </div>
            </div>
          </div>
        </div>
      </div>
      </c:forEach>
      </c:if>
   </div>
    <div class="btn-toolbar" role="toolbar" >
		<div class="btn-group mr-2" role="group">
				
			<c:if test="${board.pageTotalCount > 0}">
		
				<c:forEach begin="1" end="${board.pageTotalCount}" var="pnum">
					<a href="list?p=${pnum}&searchType=${param.searchType}&keyword=${param.keyword}"
				       class="btn ${board.currentPage eq pnum ? 'btn-dark': 'btn-white'}">${pnum}</a>
				</c:forEach>
			</c:if>
		</div>
	</div>
  </div>
</main>

<%@include file="../includes/bangbang-footer.jsp"%>