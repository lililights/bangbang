// 장바구니에 선택 상품 추가 (로컬스토리지/세션스토리지)
function addCart() {
  let item = {
    iidx: $("#iidx").val(),
    qty: $("#qty").val(),
  };

  // 중복 상품에 따른 처리
  let msg = checkDup(item);

  if (msg != null) {
    // 상품 추가 후 저장
    cart.push(item);
    storage.setItem(key, cart);

    // 장바구니 페이지로 이동 여부 선택
    if (confirm(msg)) {
      location.href = "cart";
    }
  }
}

// 중복 상품에 따른 처리
function checkDup(item) {
  let msg = "장바구니에 상품을 담았습니다. 장바구니로 이동하시겠습니까?";

  for (let i = 0; i < cart.length; i++) {
    // 동일 상품 존재시 수량 합산
    if (cart[i].iidx == item.iidx) {
      let qty = Number(item.qty) + Number(cart[i].qty);

      if (qty > 10) {
        alert("주문 가능한 최대 수량은 10개 입니다.");
        msg = null;
      } else {
        item.qty = qty;
        cart.splice(i, 1);
        msg =
          "장바구니에 담긴 상품의 수량이 " +
          item.qty +
          "개가 되었습니다. 장바구니로 이동하시겠습니까?";
      }
    }
  }
  return msg;
}

// 상품 수량 input 값 체크
function checkQty(qty) {
  if (isNaN(qty)) {
    alert("숫자만 입력하실 수 있습니다.");
    $("#qty").val(1);
  } else if (qty > 10) {
    alert("주문 가능한 최대 수량은 10개 입니다.");
    $("#qty").val(1);
  } else if (qty < 1) {
    alert("주문 가능한 최소 수량은 1개 입니다.");
    $("#qty").val(1);
  } else {
    $("#qty").val(qty);
  }
}

// 장바구니를 거치지 않고 하나의 제품을 바로 주문할 경우 세션스토리지에 저장
function insertOrder() {
  key = "LinkedCart";
  storage = new session(key);

  let item = [
    {
      iidx: $("#iidx").val(),
      qty: $("#qty").val(),
    },
  ];

  storage.setItem(key, item);

  location.href = "order/linked";
}
