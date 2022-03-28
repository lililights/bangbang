<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/frame/pageset_order.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 상세 정보</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/order/order_info.js?ver=5"/>"></script>

<script>
$(document).ready(function() {
	
	$('#updateStatus').click(function(){
		$('#updateStatus').css('display', 'none');
		$('#updateStatusArea').css('display', 'block');
		
		$('#updateStatusBtn').click(function(){
	    	updateStatus("${orderInfo.oidx}", $('#selectStatus option:selected').val());
	    });
		
		$('#updateStatusBtn+input').click(function(){
			$('#updateStatusArea').css('display', 'none');
			$('#updateStatus').css('display', 'block');
	    });
	});
	
	$('#editOrder').click(function(){
		$('#old').css('display', 'none');
		$('#new').css('display', 'block');
		
		$('#editOrderBtn').click(function(){
			updateOrder("${orderInfo.oidx}", $('#newName').val(), $('#newPhone').val(), $('#newMsg').val());
	    });
		
		$('#editOrderBtn+input').click(function(){
			$('#new').css('display', 'none');
			$('#old').css('display', 'block');
	    });
	});
});
</script>
</head>

<style>
th, td {
	text-align: center;
}

#main_container {
  display: inline-block;
  width: 500px;
  margin-top: 50px;
  border: 1px solid black;
  border-radius: 15px;
  padding: 10px 10px;
  box-shadow: 5px 5px 7px rgb(0, 0, 0, 0.5);
}
</style>

<body>
<%-- <c:if test="${loginInfo ne null}">
	<%@include file="../includes/bangbang-header.jsp"%>
	<%@include file="../includes/bangbang-nav.jsp"%>
</c:if>
<c:if test="${storeInfo ne null}">
	<%@include file="../includes/store-header.jsp"%>
	<%@include file="../includes/store-nav.jsp"%>
</c:if>
<c:if test="${adminInfo ne null}">
	<%@include file="../includes/admin-header.jsp"%>
	<%@include file="../includes/admin-nav.jsp"%>
</c:if> --%>

<main class="container">
	<div class="container-fluid px-4">
		<h3 class="mt-4 pb-3 font-italic">[ 주문 상세 정보 ]</h3>

		<ol class="breadcrumb mb-3 p-2">
			<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/main/mainpage">홈</a></li>
			<c:if test="${loginInfo ne null}">
				<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/member/mypage">내 정보</a></li>
				<li class="breadcrumb-item"><a
					href="${pageContext.request.contextPath}/order/member/${loginInfo.uidx}/list">주문목록</a></li>
			</c:if>
			<c:if test="${storeInfo ne null}">
				<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/store/mypage">가맹점 정보</a></li>
				<li class="breadcrumb-item"><a
					href="${pageContext.request.contextPath}/order/store/${storeInfo.sidx}/list">주문목록</a></li>
			</c:if>
			<c:if test="${adminInfo ne null}">
				<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin">관리자 페이지</a></li>
				<li class="breadcrumb-item"><a
					href="${pageContext.request.contextPath}/order/admin/list">주문관리</a></li>
			</c:if>
			<li class="breadcrumb-item active">주문 상세 정보</li>
		</ol>

		<div class="card mb-3">
			<div class="card-body">
				<div>
					<h4>${orderInfo.date}</h4>
					<h5>
						<span id="status">${orderInfo.status}</span>
					</h5>
				</div>

				<!-- -------------------------------------------------------------------------- -->

				<c:if test="${loginInfo ne null}">
					<div>
						<c:if test="${orderInfo.status eq '픽업가능'}">
							<input type="button" value="구매확정" class="btn btn-primary"
								onclick="updateStatus(${orderInfo.oidx}, 'pickupCom')">
						</c:if>
						<br>
						<!-- 지도 링크 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
						<small>픽업 매장</small><br>
						<h6 class="font-weight-bold">
							<a href="#">${orderInfo.sname}</a>
						</h6>
					</div>
					<br>
				</c:if>

				<!-- -------------------------------------------------------------------------- -->

				<c:if test="${adminInfo ne null}">
					<input type="button" id="updateStatus"
						class="btn btn-primary py-0 px-2" value="주문 단계 변경">
					<div id="updateStatusArea" style="display: none">
						<select name="selectStatus" id="selectStatus"
							class="form-control mb-2 p-0 px-2"
							style="width: 130px; height: 27px;'">
							<option value="accepted">주문완료</option>
							<option value="delivering">배송진행중</option>
							<option value="pickupPro">픽업가능</option>
							<option value="pickupCom">픽업완료</option>
							<option value="cancelPro">취소진행중</option>
							<option value="cancelCom">취소완료</option>
							<option value="exchangePro">교환진행중</option>
							<option value="refundPro">반품진행중</option>
							<option value="refundCom">반품완료</option>
						</select> <input type="button" id="updateStatusBtn"
							class="btn btn-primary py-0 px-2" value="확인"> <input
							type="button" class="btn btn-primary py-0 px-2" value="취소">
					</div>
					<br>
					<br>
					<small>회원ID</small>
					<br>
					<h6 class="font-weight-bold">
						<a href="${pageContext.request.contextPath}/admin/member/${orderInfo.uidx}">${orderInfo.userid}</a>
					</h6>
					<small>가맹점명</small>
					<br>
					<h6 class="font-weight-bold">
						<a href="${pageContext.request.contextPath}/admin/store/${orderInfo.sname}">${orderInfo.sname}</a>
					</h6>

					<hr>
				</c:if>

				<!-- -------------------------------------------------------------------------- -->

				<c:if test="${loginInfo ne null or adminInfo ne null}">

					<div class="card mb-3">
						<table id="orderList" class="table table-hover">
							<c:forEach items="${orderInfo.orderItemInfo}" var="oi"
								varStatus="s">
								<tbody>
									<tr>
										<td><c:out value="${s.count}" /></td>
										<td><a href="${pageContext.request.contextPath}/board/detail?iidx=${oi.iidx}">
											<img src="${pageContext.request.contextPath}/resources/uploadfile/${oi.thumb}"
											style="height: 40px; width: 40px;"></a></td>
										<td><a href="${pageContext.request.contextPath}/board/detail?iidx=${oi.iidx}">${oi.name}</a></td>
										<td>${oi.qty}개</td>
										<c:if test="${oi.salePrice eq 0}">
											<td class="text-right"><p>-</p></td>
											<td class="text-right pr-5">${oi.price}원</td>
										</c:if>
										<c:if test="${oi.salePrice ne 0}">
											<td class="text-right"><p style="text-decoration: line-through">${oi.price}원</p></td>
											<td class="text-right pr-5">${oi.salePrice}원</td>
										</c:if>
									</tr>
								</tbody>
							</c:forEach>
						</table>
					</div>
					<br>

					<div id="old">
						<small>주문자명</small><br>
						<h6 class="font-weight-bold">${orderInfo.name}</h6>
						<small>연락처</small><br>
						<h6 class="font-weight-bold">${orderInfo.phone}</h6>
						<c:if test="${orderInfo.msg ne null}">
							<small>쇼핑몰/매장 전달사항</small>
							<h6 class="font-weight-bold">${orderInfo.msg}</h6>
						</c:if>
					</div>

					<div id="new" style="display: none">
						<small>주문자명</small>
						<div class="input-group input-group-sm mb-2" style="width: 350px">
							<input type="text" id="newName" class="form-control"
								value="${orderInfo.name}" aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-sm">
						</div>
						<small>연락처</small>
						<div class="input-group input-group-sm mb-2" style="width: 350px">
							<input type="text" id="newPhone" class="form-control"
								value="${orderInfo.phone}" aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-sm">
						</div>
						<small>쇼핑몰/매장 전달사항</small>
						<div class="input-group input-group-sm mb-2" style="width: 350px">
							<input type="text" id="newMsg" class="form-control"
								value="${orderInfo.msg}" aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-sm">
						</div>
						<br> <input type="button" id="editOrderBtn"
							class="btn btn-primary" value="확인"> <input type="button"
							class="btn btn-primary" value="취소">
					</div>

					<hr>

					<div class="float-right">
						<table>
							<tr>
								<td class="text-right pr-4">상품금액</td>
								<td class="text-right"><h5>${orderInfo.totalPrice}원</h5></td>
							</tr>
							<c:if test="${orderInfo.discount ne 0}">
								<tr>
									<td class="text-right pr-4">할인금액</td>
									<td class="text-right"><h5>${orderInfo.discount}원</h5></td>
								</tr>
							</c:if>
							<c:if test="${orderInfo.pointUsed ne null}">
								<tr>
									<td class="text-right pr-4">사용 포인트</td>
									<td class="text-right"><h5>${orderInfo.pointUsed}원</h5></td>
								</tr>
							</c:if>
							<tr>
								<td class="text-right pr-4">총 결제 금액</td>
								<td class="text-right"><h2>${orderInfo.totalPay}원</h2></td>
							</tr>
							<c:if test="${adminInfo ne null}">
								<tr>
									<td colspan="2" class="text-right"><small>(매장 지급 수수료:
										${orderInfo.commission}원)</small></td>
								</tr>
							</c:if>
						</table>
					</div>
					<div class="clearfix"></div>

					<hr>

					<div class="float-right">
						<c:if test="${orderInfo.status eq '주문완료'}">
							<input type="button" class="btn btn-primary" value="주문 정보 변경"
								id="editOrder">
							<input type="button" class="btn btn-primary" value="주문 취소"
								onclick="if(confirm('정말로 취소하시겠습니까?')) {updateStatus(${orderInfo.oidx}, 'cancelPro');}">
						</c:if>
					</div>
					<div class="clearfix"></div>
				</c:if>

				<!-- -------------------------------------------------------------------------- -->

				<c:if test="${loginInfo ne null}">
					<c:if test="${orderInfo.status eq '픽업가능'}">
						<div class="float-right">
							<small>현재 ${orderInfo.sname}에서 주문한 상품이 기다리고 있습니다.<br>
								신분증 지참 및 영업시간 확인 후 매장 방문 부탁드립니다.
							</small>
						</div>
						<div class="clearfix"></div>
						<br>
					</c:if>

					<c:if
						test="${orderInfo.status eq '배송진행중' or orderInfo.status eq '교환진행중' or orderInfo.status eq '반품진행중' or orderInfo.status eq '취소진행중'}">
						<div class="float-right">
							<small>${orderInfo.status}입니다. 기타 문의사항은 고객센터를 이용해주세요.</small>
						</div>
						<div class="clearfix"></div>
						<br>

						<div class="float-right">
							<input type="button" class="btn btn-primary" value="1:1문의 게시판"
								onclick="location.href='${pageContext.request.contextPath}/member/paq/${loginInfo.uidx}/member-list'">
							<input type="button" class="btn btn-primary" value="카카오톡 채널 상담"
								onclick="location.href='http://pf.kakao.com/_Cxjpwb/chat'">
						</div>
						<div class="clearfix"></div>
					</c:if>

					<c:if test="${orderInfo.status eq '픽업완료'}">
						<div class="float-right">
							<!-- 리뷰 링크 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->
							<input type="button" class="btn btn-primary" value="리뷰 작성"
								onclick=""> <input type="button" class="btn btn-primary"
								value="교환/반품 요청"
								onclick="alert('교환/반품 요청은 1:1문의 게시판 또는 카카오톡 채널 상담을 이용해주세요.');">
						</div>
						<div class="clearfix"></div>
					</c:if>
				</c:if>

				<!-- -------------------------------------------------------------------------- -->

				<c:if test="${adminInfo ne null}">
					<c:if
						test="${orderInfo.status ne '주문완료' and orderInfo.status ne '취소진행중' and orderInfo.status ne '취소완료'}">
						<div class="float-right">
							<input type="button" class="btn btn-primary" value="배송 조회"
								onclick="tracking(${orderInfo.oidx}, '${pageContext.request.contextPath}')">
						</div>
						<div class="clearfix"></div>
					</c:if>
				</c:if>

				<!-- -------------------------------------------------------------------------- -->

				<c:if test="${storeInfo ne null}">
					<div>
						<c:if test="${orderInfo.status eq '픽업가능'}">
							<input type="button" class="btn btn-primary" value="고객 픽업완료"
								onclick="updateStatus(${orderInfo.oidx}, 'pickupCom')">
						</c:if>
						<br> <small>픽업 고객</small> <br>
						<h6 class="font-weight-bold">${orderInfo.name}</h6>
					</div>
					<br>

					<div class="card mb-3">
						<table id="orderList" class="table table-hover">
							<c:forEach items="${orderInfo.orderItemInfo}" var="oi"
								varStatus="s">
								<tbody>
									<tr>
										<td><c:out value="${s.count}" /></td>
										<td><a href="${pageContext.request.contextPath}/board/detail?iidx=${oi.iidx}">
											<img src="${pageContext.request.contextPath}/resources/uploadfile/${oi.thumb}"
											style="height: 40px; width: 40px;"></a></td>
										<td><a href="${pageContext.request.contextPath}/board/detail?iidx=${oi.iidx}">${oi.name}</a></td>
										<td>${oi.qty}개</td>
										<td>${oi.price * 0.1}</td>
									</tr>
								</tbody>
							</c:forEach>
						</table>
					</div>
					<br>

					<c:if test="${orderInfo.msg ne null}">
						<small>고객 전달사항</small>
						<h6 class="font-weight-bold">${orderInfo.msg}</h6>
					</c:if>

					<hr>

					<div class="float-right">
						<table>
							<tr>
								<td class="text-right pr-4">총 지급 수수료</td>
								<td class="text-right"><h2>${orderInfo.commission}원</h2></td>
							</tr>
						</table>
					</div>
					<div class="clearfix"></div>
				</c:if>
			</div>
		</div>
	</div>
</main>
	<%-- <%@include file="../includes/bangbang-footer.jsp"%> --%>
</body>
</html>