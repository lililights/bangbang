<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../../includes/hyunwoo-header.jsp"%>



<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">공지사항</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				&nbsp;
				<button id="regBtn" type="button" class="btn btn-xs pull-right">
				공지사항 등록</button>
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

					<c:forEach items="${list}" var="board">

						<tr>
							<%-- <td><c:out value="${board.nidx}" /></td> --%>

							<td style="padding: 15px; width: 1250px;"><a class='move'
								href='<c:out value="${board.nidx}"/>'
								style=" padding-left: 20px;"> <c:out
										value="${board.title}" /></a></td>



							<td style="padding: 15px; color: rgb(0, 0, 0, 0.5);"><i
								class="fa-solid fa-clock"
								style="padding-right: 8px; padding-left: 10px;"></i> <fmt:formatDate
									pattern="yyyy-MM-dd" value="${board.regdate}" /></td>









							<%-- 	<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${board.updatedate}" /></td> --%>

						</tr>

					</c:forEach>

				</table>




				<div class='pull-left' style="padding-top: 18px;">
					<div class="col-lg-12">

						<form id='searchForm' action="${pageContext.request.contextPath}/admin/notice_board/list" method="get">
							<select name='type'>

								<option value="">--</option>
								<option value="T">제목</option>
								<option value="C">내용</option>
								<option value="TC">제목+내용</option>


							</select> <input type='text' name='keyword' placeholder="검색" /> <input
								type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
							<input type='hidden' name='amount'
								value='${pageMaker.cri.amount}'>
							<button class='btn btn-default'>
								<i class="fa-solid fa-magnifying-glass"></i>
							</button>


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

				<form id='actionForm' action="${pageContext.request.contextPath}/admin/notice_board/list" method='get'>
					<input type='hidden' name='pageNum'
						value='${pageMaker.cri.pageNum }'> <input type='hidden'
						name='amount' value='${pageMaker.cri.amount}'> <input
						type='hidden' name='start' value='${pageMaker.cri.start}'>
				</form>


				<!-- Modal -->
				<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
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
				
				
				
				<!-- Modal -->
				<div class="modal fade" id="modifyModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">방방술래 서비스 관리</h4>
							</div>
							<div class="modal-body">수정이 완료되었습니다.</div>
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
							
						} else if(result === 'delete') {
							$("#deleteModal").modal("show");
							
						} else if(result === 'modify') {
							$("#modifyModal").modal("show");
						}
			
					}
						
						
						
						
						
						
						
						
						

						$("#regBtn").on("click", function() {

							self.location = "${pageContext.request.contextPath}/admin/notice_board/register";

						})

						var actionForm = $("#actionForm");

						$(".paginate_button a").on(
								"click",
								function(e) {

									e.preventDefault();

									console.log('click');

									actionForm.find("input[name='pageNum']")
											.val($(this).attr("href"));

									actionForm.find("input[name='start']").val(
											($(this).attr("href") - 1) * 10);

									actionForm.submit();
								});

						$(".move")
								.on(
										"click",
										function(e) {

											e.preventDefault();
											actionForm
													.append("<input type='hidden' name='nidx' value='"
															+ $(this).attr(
																	"href")
															+ "'>");
											actionForm.attr("action",
													"${pageContext.request.contextPath}/admin/notice_board/get");
											actionForm.submit();

										});

						// 기존 css에서 플로팅 배너 위치(top)값을 가져와 저장한다.
						var floatPosition = parseInt($("#floatMenu").css('top'));
						// 250px 이런식으로 가져오므로 여기서 숫자만 가져온다. parseInt( 값 );

						$(window).scroll(function() {
							// 현재 스크롤 위치를 가져온다.
							var scrollTop = $(window).scrollTop();
							var newPosition = scrollTop + floatPosition + "px";

							/* 애니메이션 없이 바로 따라감
							 $("#floatMenu").css('top', newPosition);
							 */

							$("#floatMenu").stop().animate({
								"top" : newPosition
							}, 500);

						}).scroll();

					});
</script>
