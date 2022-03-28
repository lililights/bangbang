<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/bangbang-header.jsp"%>
	
<%@include file="../includes/bangbang-nav.jsp"%>

<body>
	<div id="content">
		<h3>상품 정보 수정</h3>
		<hr>
		<form method="post">
			<table>
				<tr>
					<td>이름</td>
					<td>
						<input type="hidden" name="iidx" value="${item.iidx}"> 
						<input type="text" name="name" value="${item.name}">
					</td>
				</tr>
				<tr>
					<td>영어 이름</td>
					<td><input type="text" name="ename" value="${item.ename}"></td>
				</tr>
				<tr>
					<td>용량</td>
					<td><input type="text" name="ml" value="${item.ml}"></td>
				</tr>
				<tr>
					<td>도수</td>
					<td><input type="text" name="proof" value="${item.proof}"></td>
				</tr>
				<tr>
					<td>지역</td>
					<td><input type="location" name="location" value="${item.location}"></td>
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
					<td>맛</td>
					<td class="text-align-left text-indent text-strong text-orange" colspan="3">
					<label></label><input type="checkbox" name="taste" value="달콤한" />달콤한</label>
					<label></label><input type="checkbox" name="taste" value="씁쓸한" />씁쓸한</label>
					<label></label><input type="checkbox" name="taste" value="깔끔한" />깔끔한</label>
					</td>
				</tr>
				<tr>
					<td>향</td>
					<td class="text-align-left text-indent text-strong text-orange" colspan="3">
					<label><input type="checkbox" name="scent" value="과일" />과일</label>
					<label><input type="checkbox" name="scent" value="견과" />견과</label>
					<label><input type="checkbox" name="scent" value="꽃" />꽃</label>
					<label><input type="checkbox" name="scent" value="기타" />기타</label>
					</td>
				</tr>
				<tr>
					<td>원가</td>
					<td><input type="text" name="oprice" value="${item.oprice}"></td>
				</tr>
				<tr>
					<td>판매가</td>
					<td><input type="text" name="sprice" value="${item.sprice}"></td>
				</tr>
				<tr>
					<td>할인율</td>
					<td><input type="text" name="discount" value="${item.discount}"></td>
				</tr>
				<tr>
					<td>재고</td>
					<td><input type="text" name="qty" value="${item.qty}"></td>
				</tr>
				<tr>
					<td>추가 정보</td>
					<td><input type="text" name="etc" value="${item.etc}"></td>
				</tr>
				<tr>
					<td></td>
					<td> <input type="submit" value="수정"> <input type="reset"> </td>
				</tr>			
			</table>
		
		</form>
	
	</div>
</body>
<%@include file="../includes/bangbang-footer.jsp"%>