// 자바스크립트의 다형성을 이용한 로컬스토리지 프로토타입
function local(key) {}

local.prototype.getItem = function (key) {
  return localStorage.getItem(key);
};

local.prototype.setItem = function (key, cart) {
  return localStorage.setItem(key, JSON.stringify(cart));
};

local.prototype.removeItem = function (key) {
  return localStorage.removeItem(key);
};

// 자바스크립트의 다형성을 이용한 세션스토리지 프로토타입
function session(key) {}

session.prototype.getItem = function (key) {
  return sessionStorage.getItem(key);
};

session.prototype.setItem = function (key, cart) {
  return sessionStorage.setItem(key, JSON.stringify(cart));
};

session.prototype.removeItem = function (key) {
  return sessionStorage.removeItem(key);
};

// 저장된 장바구니를 불러와 자바스크립트 객체의 배열로 저장 (로컬스토리지/세션스토리지)
function getCart() {
  let cart = storage.getItem(key);

  if (!cart) {
    cart = [];
  } else {
    cart = JSON.parse(cart);
  }

  return cart;
}
