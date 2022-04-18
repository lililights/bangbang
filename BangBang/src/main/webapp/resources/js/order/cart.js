// 저장된 장바구니 목록 불러오기 (로컬스토리지/세션스토리지)//
function getCartItemInfo(contextPath) {
  $.ajax({
    url: "",
    type: "POST",
    contentType: "application/json",
    data: JSON.stringify(cart),
    success: function (data) {
      // 장바구니 목록 출력
      printList(data, contextPath);
    },
    error: function () {
      $("#list").html('<td colspan="7">[OC2] error</td>');
    },
  });
}

// 장바구니 목록 출력
function printList(data, contextPath) {
  let html = "";

  $("#list").html(html);

  let totalPrice = 0;
  let totalSalePrice = 0;

  if (!jQuery.isEmptyObject(data)) {
    html += "<thead><tr><th>no</th>";
    html += "<th>사진</th>";
    html += "<th>상품명</th>";
    html += "<th>수량</th>";
    html += "<th>가격</th>";
    html += "<th>할인가격</th>";
    html += "<th>삭제</th></tr></thead>";
    html += "<tbody>";

    for (let i = 0; i < data.length; i++) {
      html += '<tr><td class="align-middle">' + (i + 1) + "</td>";
      html +=
        '<td class="align-middle"><a href=' + contextPath + '/board/detail?iidx=' + data[i].iidx + '>';
      html += 
      	'<img src="/bangbang/resources/uploadfile/' + data[i].thumb + '" style="height: 50px; width: 50px;"></a></td>';
      html +=
        '<td class="align-middle"><a href=' + contextPath + '/board/detail?iidx=' + data[i].iidx + '>' + data[i].name + "</a></td>";

      html +=
        '<td class="align-middle"><i class="fa-solid fa-circle-minus" onclick="dropOne(' +
        i +
        ')"></i>';
      html +=
        '<input onchange="checkQty(' +
        i +
        ', Number($(this).val()))" type="text" id="qty' +
        i +
        '" value="' +
        data[i].qty +
        '" class="form-control mx-1" style="height: 30px; width: 45px; display: inline;">';
      html +=
        '<i class="fa-solid fa-circle-plus" onclick="addOne(' +
        i +
        ')"></i></td>';

      let price = data[i].price * data[i].qty;
      let salePrice = data[i].salePrice * data[i].qty;

      html +=
        salePrice != 0
          ? '<td class="align-middle"><p style="text-decoration: line-through">' +
            moneyEx(price) +
            "원</p></td>"
          : '<td class="align-middle"></td>';
      html +=
        salePrice != 0
          ? '<td class="align-middle">' + moneyEx(salePrice) + "원</td>"
          : '<td class="align-middle">' + moneyEx(price) + "원</td>";
      html +=
        '<td class="align-middle"><i class="fa-solid fa-trash" onclick="removeOne(' +
        i +
        ')"></i></td></tr>';

      totalPrice += price;
      totalSalePrice += salePrice;
    }

    html += "</tbody>";
    $("#list").append(html);

    $("#totalPrice").html(moneyEx(totalPrice));
    $("#discount").html(moneyEx(totalPrice - totalSalePrice));
    $("#point").html(moneyEx($("#point").text() - $("#pointUse").val()));
    $("#totalSalePrice").html(moneyEx(totalSalePrice));

    $("#item").val(data[0].name);
    $("#amount").val(totalSalePrice);
  } else {
    $("#list").html('<td colspan="7">장바구니에 담긴 상품이 없습니다.</td>');
  }
}

// 장바구니 상품 수량 -1 (로컬스토리지/세션스토리지)
function dropOne(index) {
  checkQty(index, Number(cart[index].qty) - 1);
}

// 장바구니 상품 수량 +1 (로컬스토리지/세션스토리지)
function addOne(index) {
  checkQty(index, Number(cart[index].qty) + 1);
}

// 상품 수량 input 값 체크 후 저장 (로컬스토리지/세션스토리지)
function checkQty(index, newQty) {
  if (isNaN(newQty)) {
    alert("숫자만 입력하실 수 있습니다.");
  } else if (newQty > 10) {
    alert("주문 가능한 최대 수량은 10개 입니다.");
  } else if (newQty < 1) {
    alert("주문 가능한 최소 수량은 1개 입니다.");
  } else {
    cart[index].qty = newQty;
    storage.setItem(key, cart);
  }

  getCartItemInfo();
}

// 장바구니에서 선택 상품 삭제 (로컬스토리지/세션스토리지)
function removeOne(index) {
  cart.splice(index, 1);
  storage.setItem(key, cart);

  getCartItemInfo();
}

// 장바구니 전체 비우기 (로컬스토리지/세션스토리지)
function removeAll() {
  storage.removeItem(key);
  location.reload();
}

// 주문페이지 이동
function order(contextPath){
	if (cart.length < 1) {
		alert('장바구니에 담긴 상품이 없습니다.');
	} else {
		location.href= contextPath + '/order';
	}
}

// 화폐 단위 (1,000,000) 표현식
function moneyEx(number) {
  return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
