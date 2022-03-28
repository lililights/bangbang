$(document).ready(function () {
  $("#password2").focusin(function () {
    $("#pmsg").css("display", "none");
    $("#pmsg").removeClass("text_blue");
    $("#pmsg").removeClass("text_red");
    $("#pmsg").text("");
  });
  $("#password2").focusout(function () {
    var pwd1 = $("#password1").val();
    var pwd2 = $("#password2").val();

    if (pwd1 != "" && pwd2 == "") {
      null;
    } else if (pwd1 != "" || pwd2 != "") {
      if (pwd1 == pwd2) {
        // 비밀번호 일치 이벤트 실행
        $("#pmsg").css("display", "block");
        $("#pmsg").text("비밀번호가 일치합니다.");
        $("#pmsg").addClass("text_blue");
      } else {
        // 비밀번호 불일치 이벤트 실행
        $("#pmsg").css("display", "block");
        $("#pmsg").text("비밀번호가 일치하지 않습니다.");
        $("#pmsg").addClass("text_red");
      }
    }
  });
});
