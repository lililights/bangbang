// 아임포트 결제 API
function iamportPayment(contextPath) {
  let IMP = window.IMP;
  IMP.init("imp03857707");

  IMP.request_pay(
    {
      pg: "html5_inicis.MID-a",
      pay_method: "card",
      merchant_uid: (Date.now() + Math.random()) * 10000, // 랜덤 일련번호 생성
      name: $("#item").val(), // 상품명
      amount: $("#totalPay").text().replace(/,/g, ""), // 결제금액
      buyer_name: $("#name").val(), // 주문자명
      buyer_tel: $("#phone").val(), // 주문자 전화번호
      buyer_email: "lililights1@gmail.com", // 주문자 이메일주소
    },
    function (rsp) {
      // 결제 성공
      if (rsp.success) {
        $.ajax({
          headers: {
            "X-CSRF-TOKEN": $('meta[name="csrf-token"]').attr("content"),
          },
          type: "post",
          url: contextPath,
          data: {
            imp_uid: rsp.imp_uid,
            merchant_uid: rsp.merchant_uid,
          },
          success: function (data) {
            alert("결제가 완료되었습니다.");

            // 주문 insert
            orderRequest(contextPath);
          },
          //javascript error
          error: function (data) {
            console.log("error" + data);
          },
        });
      } else {
        // 결제 실패
        alert("결제에 실패하였습니다. 에러 내용: " + rsp.error_msg);
      }
    }
  );
}
