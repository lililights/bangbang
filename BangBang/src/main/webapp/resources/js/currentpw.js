$(document).ready(function () {
  $("#current_pw").focusin(function () {
    $("#msg").css("display", "none");
    $("#msg").removeClass("text_blue");
    $("#msg").removeClass("text_red");
    $("#msg").text("");
  });

  $("#current_pw").focusout(function () {
    if ($("#current_pw").val() == "") {
      $("#msg").css("display", "block");
      $("#msg").text("현재 비밀번호를 입력하세요.");
      $("#msg").addClass("text_red");
    } else {
      $.ajax({
        url: "pw/checkpw",
        type: "get",
        data: {
          currentpw: $("#current_pw").val(),
        },
        success: function (data) {
          console.log("통신 결과 : ", data);

          if (data == "Y") {
            $("#msg").css("display", "block");
            $("#msg").text("현재 비밀번호가 일치합니다.");
            $("#msg").addClass("text_blue");
          } else {
            $("#msg").css("display", "block");
            $("#msg").text("현재 비밀번호가 일치하지 않습니다.");
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
