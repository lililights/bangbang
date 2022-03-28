<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../includes/bangbang-header.jsp"%>
	
<%@include file="../includes/bangbang-nav.jsp"%>

<main>
<form name="form" method="post" action="${pageContext.request.contextPath}/admin/item/insert">
	<div class="margin-top first">
		<h3 class="hidden">게시물 등록</h3>
		<table class="table">
			<tbody>
				<tr>
					<th>이름</th>
					<td class="text-align-left text-indent text-strong text-orange" colspan="3"><input type="text" name="name" placeholder="이름을 입력해주세요." /></td>
				</tr>
				<tr>
					<th>영어 이름</th>
					<td class="text-align-left text-indent text-strong text-orange" colspan="3"><input type="text" name="ename" placeholder="영어 이름을 입력해주세요." /></td>
				</tr>
				<tr>
					<th>용량</th>
					<td class="text-align-left text-indent text-strong text-orange" colspan="3"><input type="text" name="ml" placeholder="용량을 입력해주세요." /></td>
				</tr>
				<tr>
					<th>도수</th>
					<td class="text-align-left text-indent text-strong text-orange" colspan="3"><input type="text" name="proof" placeholder="도수를 입력해주세요." /></td>
				</tr>
				<tr>
					<th>지역</th>
					<td class="text-align-left text-indent text-strong text-orange" colspan="3"><input type="text" name="location" placeholder="지역을 입력해주세요." /></td>
				</tr>
				<tr>
					<th>종류</th>
					<td class="text-align-left text-indent text-strong text-orange" colspan="3">
					<label><input type="radio" name="type" value="위스키"/>위스키</label>
					<label><input type="radio" name="type" value="와인"/>와인</label>
					<label><input type="radio" name="type" value="럼"/>럼</label>
					<label><input type="radio" name="type" value="맥주"/>맥주</label>
					<label><input type="radio" name="type" value="사케"/>사케</label>
					<label><input type="radio" name="type" value="브랜디"/>브랜디</label>
					<label><input type="radio" name="type" value="리큐르"/>리큐르</label>
					<label><input type="radio" name="type" value="전통주"/>전통주</label>
					<label><input type="radio" name="type" value="기타"/>기타</label>
					</td>
				</tr>
				<tr>
					<th>맛</th>
					<td class="text-align-left text-indent text-strong text-orange" colspan="3">
					<label></label><input type="checkbox" name="taste" value="달콤한" />달콤한</label>
					<label></label><input type="checkbox" name="taste" value="씁쓸한" />씁쓸한</label>
					<label></label><input type="checkbox" name="taste" value="깔끔한" />깔끔한</label>
					</td>
				</tr>
				<tr>
					<th>향</th>
					<td class="text-align-left text-indent text-strong text-orange" colspan="3">
					<label><input type="checkbox" name="scent" value="과일" />과일</label>
					<label><input type="checkbox" name="scent" value="견과" />견과</label>
					<label><input type="checkbox" name="scent" value="꽃" />꽃</label>
					<label><input type="checkbox" name="scent" value="기타" />기타</label>
					</td>
				</tr>
				<tr>
					<th>원가</th>
					<td class="text-align-left text-indent text-strong text-orange" colspan="3"><input type="text" name="oprice" placeholder="원가를 입력해주세요." /></td>
				</tr>
				<tr>
					<th>판매가</th>
					<td class="text-align-left text-indent text-strong text-orange" colspan="3"><input type="text" name="sprice" placeholder="판매가를 입력해주세요." /></td>
				</tr>
				<tr>
					<th>할인율</th>
					<td class="text-align-left text-indent text-strong text-orange" colspan="3"><input type="text" name="discount" placeholder="할인율을 입력해주세요." /></td>
				</tr>
				<tr>
					<th>재고</th>
					<td class="text-align-left text-indent text-strong text-orange" colspan="3"><input type="text" name="qty" placeholder="재고를 입력해주세요." /></td>
				</tr>
				<tr>
					<th>추가정보</th>
					<td class="text-align-left text-indent text-strong text-orange" colspan="3"><input type="text" name="etc" placeholder="추가 정보를 입력해주세요." /></td>
				</tr>
				
			</tbody>
		</table>
	</div>
	<div class="margin-top text-align-center">
		<input class="btn-text btn-default" type="submit" value="등록" /> <a class="btn-text btn-cancel" href="list">취소</a>
	</div>
</form>
</main>
<%@include file="../includes/bangbang-footer.jsp"%>