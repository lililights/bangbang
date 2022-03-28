$(document).ready(function () {
  $("#userid").focusin(function () {
    $("#msg").css("display", "none");
    $("#msg").removeClass("text_blue");
    $("#msg").removeClass("text_red");
    $("#msg").text("");
  });

  $("#userid").focusout(function () {
    if ($("#userid").val() == "") {
      $("#msg").css("display", "block");
      $("#msg").text("사용할 아이디를 작성해주세요.");
      $("#msg").addClass("text_red");
    } else {
      $.ajax({
        url: "general/checkid",
        type: "get",
        data: {
          userid: $("#userid").val(),
        },
        success: function (data) {
          console.log("통신 결과 : ", data);

          // Y | N
          if (data == "Y") {
            // 사용 가능한 아이디
            $("#msg").css("display", "block");
            $("#msg").text("사용가능한 아이디 입니다.");
            $("#msg").addClass("text_blue");
          } else {
            // 사용 불가능한 아이디
            $("#msg").css("display", "block");
            $("#msg").text("사용 불가능한 아이디 입니다.");
            $("#msg").addClass("text_red");
          }
        },
        error: function () {
          console.log("비동기 통신 오류");
        },
      });
    }
  });
});
