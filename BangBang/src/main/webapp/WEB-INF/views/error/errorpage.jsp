<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html lang="ko">
<head>

<%-- <%
	response.setStatus(HttpServletResponse.SC_OK);
%> --%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no" />
<title>Error</title>
<style type="text/css">
body,html {margin:0; height:100%;}
img {max-width:100%}
.error {display:table; width:100%; height:100%; background:#fff; text-align:center;}
.error .box {display:table-cell; padding:0 10px 100px 10px; vertical-align:middle;}
.error .box .btn {padding-top:20px;}
</style>
</head>
<body>
<!-- ìë¬íì´ì§ -->
<div class="error" >
    <div class="box">
        <div class="cont"><img src="${pageContext.request.contextPath}/resources/hyunwoo/imageContainer/img_error.png" /></div>
        <div class="btn"><a href="${pageContext.request.contextPath}/main/mainpage"><img src="${pageContext.request.contextPath}/resources/hyunwoo/imageContainer/bt_home.png"/></a></div>
    </div>
</div>

</body>

</html>





