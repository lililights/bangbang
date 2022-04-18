// 옵션값 <select> 에 출력할 기간 설정//
function setPeriodOption(date) {
  let year = date.getFullYear();
  let month = date.getMonth();

  for (let i = 1; i <= 5; i++) {
    if (month == 0) {
      month = 12;
      year--;
    }

    $("#month" + i).append(year + "년 " + month + "월");

    let monthStr = month < 10 ? "-0" + month + "%" : "-" + month + "%";
    $("#month" + i).val(year + monthStr);

    month--;
  }
}

// 주문목록 출력
function printList(data, login) {
  let html = "";

  $("#orderList").html(html);

  html += "<thead><tr><th>주문번호</th>";
  html += "<th>주문일시</th>";
  html += "<th>상품사진</th>";
  html += "<th>주문상품</th>";
  html += login == 1 ? "<th>결제금액</th>" : "<th>지급수수료</th>";
  html += login == 1 ? "<th>가맹점명</th>" : "<th>회원이름</th>";
  html += "<th>주문현황</th></tr></thead>";
  html += "<tbody>";

  if (!jQuery.isEmptyObject(data)) {
    for (let i = 0; i < data.length; i++) {
      html += "<tr><td>" + data[i].oidx + "</td>";
      html += "<td>" + data[i].date + "</td>";
      html += '<td><a href="../../';
      html += login == 1 ? "member/list/" : "store/list/";
      html += data[i].oidx + '">';
      html += '<img src="/bangbang/resources/uploadfile/' + data[i].thumb + '" style="height: 50px; width: 50px;"></a></td>';
      html += '<td><a href="../../';
      html += login == 1 ? "member/list/" : "store/list/";
      html += data[i].oidx + '">';
      html += data[i].name;
      html += data[i].restCount + "</a></td>";
      html +=
        login == 1
          ? "<td>" + moneyEx(data[i].totalpay) + "원</td>"
          : "<td>" + moneyEx(data[i].commission) + "원</td>";
      html +=
        login == 1
          ? "<td>" + data[i].sname + "</td>"
          : "<td>" + data[i].username + "</td>";
      html += "<td>" + data[i].status + "</td></tr>";
    }

    html += "</tbody>";
    $("#orderList").append(html);
  } else {
    $("#orderList").html('<td colspan="5">주문내역이 없습니다.</td>');
  }
}

// ajax로 일반회원용 주문 목록 불러오기
function getListMember(uidx) {
  $.ajax({
    url: "list/opt",
    type: "GET",
    data: {
      uidx: uidx,
      optPeriod: $("#optPeriod option:selected").val(),
      optStatus: $('input[name="optStatus"]:checked').val(),
      page: 1,
    },
    success: function (data) {
      printList(data, 1);
    },
    error: function () {
      $("#orderList").html('<td colspan="5">[OM2] error</td>');
    },
  });
}

// ajax로 가맹점용 주문 목록 불러오기
function getListStore(sidx) {
  $.ajax({
    url: "list/opt",
    type: "GET",
    data: {
      sidx: sidx,
      optPeriod: $("#optPeriod option:selected").val(),
      optStatus: $('input[name="optStatus"]:checked').val(),
      page: 1,
    },
    success: function (data) {
      printList(data, 2);
    },
    error: function () {
      $("#orderList").html('<td colspan="5">[OM2] error</td>');
    },
  });
}

// 화폐 단위 (1,000,000) 표현식
function moneyEx(number) {
  return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
