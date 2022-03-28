$(document).ready(function () {
  $("#change_btn").click(function (e) {
    e.preventDefault();
    $("#btn").remove();
    $(".change_pw").css("display", "block");
  });
});
