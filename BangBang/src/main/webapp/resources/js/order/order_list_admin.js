// 관리자용 주문목록 출력//
function printList(data, contextPath) {
  let html = "";

  $("#orderList").html(html);

  html +=
    '<thead><tr><th scope="col"><input type="checkbox" id="checkAll" onchange="checkAll();"></th>';
  html += '<th scope="col" class="text-center">주문일시</th>';
  html += '<th scope="col">주문번호</th>';
  html += '<th scope="col">회원 ID</th>';
  html += '<th scope="col">가맹점명</th>';
  html += '<th scope="col">주문현황</th></tr></thead>';

  html += "<tbody>";

  if (!jQuery.isEmptyObject(data)) {
    for (let i = 0; i < data.length; i++) {
      html +=
        '<tr><td><input type="checkbox" name="oidx" value="' + data[i].oidx;
      html += data[i].status == "주문완료" ? '"></td>' : '" disabled></td>';
      html += "<td>" + data[i].date + "</td>";
      html += '<td><a href="../admin/list/';
      html += data[i].oidx + '">';
      html += data[i].oidx + "</a></td>";
      html += '<td><a href=' + contextPath + '/admin/member/' + data[i].uidx + '>' + data[i].userid + "</a></td>";
      html += '<td><a href=' + contextPath + '/admin/store/' + data[i].sname + '>' + data[i].sname + "</a></td>";
      html += "<td>" + data[i].status + "</td></tr>";
    }

    html += "</tbody>";
    $("#orderList").append(html);
  } else {
    $("#orderList").html('<td colspan="6">주문내역이 없습니다.</td>');
  }
}

// ajax로 관리자용 주문 목록 불러오기
function getList(contextPath) {
  $.ajax({
    url: "list/opt",
    type: "GET",
    data: {
      optPeriod: $("#optPeriod").val() + "%",
      searchType: $("#searchType option:selected").val(),
      searchKeyword: $("#searchKeyword").val(),
      optStatus: $('input[name="optStatus"]:checked').val(),
      page: 1,
    },
    success: function (data) {
      printList(data, contextPath);
    },
    error: function () {
      $("#orderList").html('<td colspan="5">[OM2] error</td>');
    },
  });
}

// checkbox 전체선택
function checkAll() {
  if ($("#checkAll").is(":checked")) {
    $("input[name=oidx]:checkbox").prop("checked", true);
  } else {
    $("input[name=oidx]:checkbox").prop("checked", false);
  }
}

// 선택 주문건 퀵/택배 배송 요청
function deliveryRequest(service, provider) {
  let checked = $("input:checkbox[name=oidx]:checked").length;

  if (checked == 0) {
    alert("선택된 항목이 없습니다.");
  } else {
    let deliveryRequest = [];

    $("input:checkbox[name=oidx]:checked").each(function () {
      deliveryRequest.push({
        service: service,
        provider: provider,
        oidx: $(this).val(),
      });
    });

    console.log(deliveryRequest);

    $.ajax({
      url: "delivery",
      type: "POST",
      contentType: "application/json",
      data: JSON.stringify(deliveryRequest),
      success: function (data) {
        alert(data + "건의 배송 요청 성공");
        location.reload();
      },
      error: function (data) {
        alert(data);
      },
    });
  }
}
