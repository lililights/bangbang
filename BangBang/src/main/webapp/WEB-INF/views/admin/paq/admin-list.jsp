<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../includes/hyunwoo-header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">1:1 문의</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				&nbsp;
<!-- 				<button id="regBtn" type="button" class="btn btn-xs pull-right">새
					글 쓰기</button> -->
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<!-- 						<tr>
							<th>번호</th>
							<th style="padding-right: 180px"></th>
							<th></th>
							<th>수정일</th>
						</tr> -->
					</thead>

					<c:forEach items="${list}" var="paq">

						<tr>
							<%-- <td><c:out value="${paq.pqidx}" /></td> --%>

							<td style="padding: 15px; width: 1250px;"><a class='move' href='<c:out value="${paq.pqidx}"/>'
								style=" padding-left: 20px;" > <c:out value="${paq.title}" /></a></td>



							<td style="padding: 15px; color: rgb(0, 0, 0, 0.5);"><i
								class="fa-solid fa-clock" style="padding-right: 8px; padding-left: 10px;"></i> <fmt:formatDate
									pattern="yyyy-MM-dd" value="${paq.regdate}" /></td>









							<%-- 	<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${paq.updatedate}" /></td> --%>

						</tr>

					</c:forEach>

				</table>




				<div class='pull-left' style="padding-top: 18px;" >
					<div class="col-lg-12">

						<form id='searchForm' action="${pageContext.request.contextPath}/admin/paq/admin-list" method="get">
							<select name='type'>

								<option value="">--</option>
								<option value="T">제목</option>
								<option value="C">내용</option>
								<option value="TC">제목+내용</option>


							</select> 
							
							<input type='text' name='keyword' placeholder="검색"/> 
							<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'> 
							<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
							<button class='btn btn-default'><i class="fa-solid fa-magnifying-glass"></i></button>


						</form>
					</div>
				</div>




				<div class='pull-right'>
					<ul class="pagination">

						<c:if test="${pageMaker.prev}">
							<li class="paginate_button previous"><a
								href="${pageMaker.startPage -1}">이전</a></li>
						</c:if>

						<c:forEach var="num" begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}">
							<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active" : " "}">
								<a href="${num}">${num}</a>
							</li>
						</c:forEach>

						<c:if test="${pageMaker.next }">
							<li class="paginate_button next"><a
								href="${pageMaker.endPage +1 }">다음</a></li>
						</c:if>
					</ul>

				</div>
				<!-- end Pagination -->

				<form id='actionForm' action="${pageContext.request.contextPath}/admin/paq/admin-list" method='get'>
					<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum }'> 
					<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
					<input type='hidden' name='start' value='${pageMaker.cri.start}'>
				</form>


				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">방방술래 서비스 관리</h4>
							</div>
							<div class="modal-body">삭제가 완료되었습니다.</div>
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
	$(document)
			.ready(
					function() {

						var result = '<c:out value="${result}"/>';

						checkModal(result);

						history.replaceState({}, null, null);

						function checkModal(result) {

							if (result === '' || history.state) {
								return;
							}

							$("#myModal").modal("show");
						}

						$("#regBtn").on("click", function() {

							self.location = "${pageContext.request.contextPath}/admin/paq/register";

						})

						var actionForm = $("#actionForm");

						$(".paginate_button a").on(
								"click",
								function(e) {

									e.preventDefault();

									console.log('click');

									actionForm.find("input[name='pageNum']")
											.val($(this).attr("href"));
									
									actionForm.find("input[name='start']")
											.val(($(this).attr("href")-1)*10);

									actionForm.submit();
								});

						$(".move").on("click", function(e) {

											e.preventDefault();
											actionForm
													.append("<input type='hidden' name='pqidx' value='"
															+ $(this).attr(
																	"href")
															+ "'>");
											actionForm.attr("action",
													"${pageContext.request.contextPath}/admin/paq/admin-get");
											actionForm.submit();

										});

					});
	

</script>
