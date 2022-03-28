$(document).submit(function (e) {
  const regex =
    /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/;
  if (!regex.test($("#password1").val().trim())) {
    e.preventDefault();
    alert("비밀번호는 영문, 숫자, 기호를 사용하여 8자 이상 입력하세요. ");
    return false;
  }
  if ($("#password1").val() != $("#password2").val()) {
    e.preventDefault();
    alert("비밀번호를 확인해주세요.");
    return false;
  }
  return true;
});
