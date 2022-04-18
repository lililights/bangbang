// 주문 단계 변경//
function updateStatus(oidx, status) {
  let update = {
    oidx: oidx,
    status: status,
  };

  $.ajax({
    url: oidx + "/status",
    type: "PUT",
    contentType: "application/json",
    data: JSON.stringify(update),
    success: function (data) {
      location.reload();
    },
    error: function (data) {
      alert(data);
    },
  });
}

// 주문 정보 수정
function updateOrder(oidx, name, phone, msg) {
  let update = {
    oidx: oidx,
    name: name,
    phone: phone,
    msg: msg,
  };

  $.ajax({
    url: oidx,
    type: "PUT",
    contentType: "application/json",
    data: JSON.stringify(update),
    success: function (data) {
      location.reload();
    },
    error: function (data) {
      alert(data);
    },
  });
}

// 주문 번호로 배송 조회
function tracking(oidx, contextPath){

		$.ajax({
		url: contextPath + '/order/admin/delivery/' + oidx,
		type: 'GET',
		data: oidx,
		success: function (data) {
			window.open('http://nplus.doortodoor.co.kr/web/detail.jsp?slipno=' + data);
		},
		error: function (data) {
			alert(data);
		}
	});
}

// 화폐 단위 (1,000,000) 표현식
function moneyEx(number) {
  return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
