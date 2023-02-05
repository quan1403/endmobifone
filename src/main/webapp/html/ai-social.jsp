<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
  <%@include file="header/head.jsp" %>
</head>
<body>
<div class="loader">
  <img src="img/logomobifone.jpg" class="loaderLogo"/>
</div>

<%@include file="menu/menu.jsp" %>

<%@include file="body/contact_phone.jsp" %>

<div class="modal fade submitCV" id="submitCV" tabindex="-1" role="dialog" aria-hidden="true">
  <%@include file="modal/modal_fade_submitCV.jsp" %>
</div>

<div class="modal fade submitCVRecrui" id="submitCVRecrui" tabindex="-1" role="dialog" aria-hidden="true">
  <%@include file="modal/modal_fade_submitCVRecrui.jsp" %>
</div>

<div class="modal fade" id="modal-register" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"aria-hidden="true">
  <%@include file="modal/modal_register.jsp" %>
</div>

<div id="product">
  <%@include file="body/content_ai_social.jsp" %>
</div>
<div id="sec-register">
  <%@include file="body/content_register.jsp" %>
</div>

<%@include file="footer/footer.jsp" %>

<!-- /wrapper -->

<%@include file="footer/javascript.jsp" %>
</body>
</html>
