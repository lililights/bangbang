$(document).ready(function () {
  $("#email").focusin(function () {
    $("#emsg").css("display", "none");
    $("#emsg").removeClass("text_blue");
    $("#emsg").removeClass("text_red");
    $("#emsg").text("");
  });

  $("#email").focusout(function () {
    if ($("#email").val() == "") {
      $("#emsg").css("display", "block");
      $("#emsg").text("사용할 이메일 작성해주세요.");
      $("#emsg").addClass("text_red");
    } else {
      $.ajax({
        url: "general/checkemail",
        type: "get",
        data: {
          email: $("#email").val(),
        },
        success: function (data) {
          console.log("통신 결과 : ", data);

          // Y | N
          if (data == "Y") {
            // 사용 가능한 아이디
            $("#emsg").css("display", "block");
            $("#emsg").text("사용가능한 이메일 입니다.");
            $("#emsg").addClass("text_blue");
          } else {
            // 사용 불가능한 아이디
            $("#emsg").css("display", "block");
            $("#emsg").text("이미 등록된 이메일 입니다.");
            $("#emsg").addClass("text_red");
          }
        },
        error: function () {
          console.log("비동기 통신 오류");
        },
      });
    }
  });
});
