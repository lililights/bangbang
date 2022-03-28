<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <link
      rel="short icon"
      href="${pageContext.request.contextPath}/resources/imageContainer/wine.png"
    />
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <%@ include file="/WEB-INF/views/frame/pageset.jsp" %>
    <link
      href="//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css"
      rel="stylesheet"
      type="text/css"
    />

    <title>방방술래</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/clipboard.js/2.0.0/clipboard.min.js"></script>
    <link
      rel="stylesheet"
      href="https://d1e2y5wc27crnp.cloudfront.net/web/style_4.css"
    />

    <script
      async
      src="https://www.googletagmanager.com/gtag/js?id=AW-804830038"
    ></script>
    <script>
      window.dataLayer = window.dataLayer || [];
      function gtag() {
        dataLayer.push(arguments);
      }
      gtag("js", new Date());

      gtag("config", "AW-804830038");
    </script>
  </head>
  <body>
    <div id="container">
      <div id="first-section-background">
        <div class="section" id="first-section">
          <p class="catchphrase">
            전국 방방곳곳 원하는 술이 찾아온다<br />
            <span>방방술래</span>
          </p>

          <div id="bar-image-container">
            <div class="bar-images hide--mobile">
              <img
                src="${pageContext.request.contextPath}/resources/hyunwoo/imageContainer/1.jpg"
                alt="1"
                class="bar-image"
              />
              <img
                src="${pageContext.request.contextPath}/resources/hyunwoo/imageContainer/2.jpg"
                alt="2"
                class="bar-image"
              />
              <img
                src="${pageContext.request.contextPath}/resources/hyunwoo/imageContainer/3.jpg"
                alt="3"
                class="bar-image"
              />
            </div>
            <div class="bar-images hide--mobile">
              <img
                src="${pageContext.request.contextPath}/resources/hyunwoo/imageContainer/4.jpg"
                alt="4"
                class="bar-image"
              />
              <img
                src="${pageContext.request.contextPath}/resources/hyunwoo/imageContainer/5.jpg"
                alt="5"
                class="bar-image"
              />
              <img
                src="${pageContext.request.contextPath}/resources/hyunwoo/imageContainer/6.jpg"
                alt="6"
                class="bar-image"
              />
            </div>
            <div class="bar-images hide--mobile">
              <img
                src="${pageContext.request.contextPath}/resources/hyunwoo/imageContainer/7.jpg"
                alt="7"
                class="bar-image"
              />
              <img
                src="${pageContext.request.contextPath}/resources/hyunwoo/imageContainer/8.jpg"
                alt="8"
                class="bar-image"
              />
              <img
                src="${pageContext.request.contextPath}/resources/hyunwoo/imageContainer/9.jpg"
                alt="9"
                class="bar-image"
              />
            </div>
          </div>

          <div id="button-container">
            <div id="app-download-link-button">
              <a
                href="${pageContext.request.contextPath}/main/mainpage"
                style="text-decoration: none; color: white"
                >홈페이지로 이동</a
              >
            </div>
            <div class="hide--mobile"></div>
            <div class="hide--mobile"></div>
          </div>
        </div>
      </div>

      <div id="second-section-background">
        <div class="section" id="second-section">
          <div class="horizontal-section">
            <div class="text-container">
              <p class="section-title">술픽업</p>
              <div class="counts">
                <div>
                  <div class="count-label">픽업 매장</div>
                  <div id="pickup-bar-count" class="count-content">
                    &nbsp;<span data-count="817">0</span>개
                  </div>
                </div>
                <div>
                  <div class="count-label">상품</div>
                  <div id="pickup-product-count" class="count-content">
                    &nbsp;<span data-count="130">0</span>개
                  </div>
                </div>
              </div>

              <p class="description">
                원하는 술 찾으러 돌아다니기 불편하셨나요?<br
                  class="hide--mobile"
                />
                술에 대한 정보를 찾기 어려우셨나요?
              </p>

              <p class="description detail">
                다양한 주류를 둘러보고<br class="hide--mobile" />
                합리적인 가격에 주문하고<br class="hide--mobile" />
                내 주변 식당에서 픽업하세요
              </p>
            </div>
          </div>
        </div>
      </div>

      <div id="footer-background">
        <footer>
          <div>
            <p id="footer-title">
              지금 방방술래에서<br />
              <span>편리한 주류 쇼핑</span>을<br />
              시작해보세요!
            </p>
          </div>
          <div>
            <p id="company-name">(주) 방방술래</p>
            <p class="company-info">
              서울시 비트구 캠프로 123, 5층
              <span class="vertical-divider hide--mobile"
                >&nbsp;&nbsp;|&nbsp;&nbsp;</span
              >
              <br class="show--mobile" />
            </p>
            <p class="company-info">
              문의 &nbsp;bangbang@bang.co
              <span class="vertical-divider hide--mobile"
                >&nbsp;&nbsp;|&nbsp;&nbsp;</span
              >
              <br class="show--mobile" />
              <span class="space show--mobile"></span>
              &nbsp;&nbsp;
              <a href="mailto:contact@dailyshot.co" target="_blank"> </a>
            </p>

            <p id="company-paper-links">
              <a>사업자정보확인</a>
              <span class="vertical-divider">&nbsp;&nbsp;|&nbsp;&nbsp;</span>
              <a>이용약관</a>
              <span class="vertical-divider">&nbsp;&nbsp;|&nbsp;&nbsp;</span>
              <a>개인정보취급방침</a>
            </p>
          </div>
        </footer>
      </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/css-vars-ponyfill@2/dist/css-vars-ponyfill.min.js"></script>

    <script
      type="text/javascript"
      src="https://d1e2y5wc27crnp.cloudfront.net/web/app_4.js"
    ></script>
  </body>
</html>
