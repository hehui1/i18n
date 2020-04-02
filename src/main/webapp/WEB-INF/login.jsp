<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!--引入 spring 标签使用国际化-->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录页面</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<form class="form-horizontal" role="form">
    <div class="form-group">
        <div class="col-sm-offset-1 col-sm-2">
            <input type="text" class="form-control" id="username"
                   placeholder="<spring:message code="message_user"/>">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-1 col-sm-2">
            <input type="text" class="form-control" id="password"
                   placeholder="<spring:message code='message_pass'/>">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-1 col-sm-2">
            <samp><a href="/language/change?locale=zh">中文</a>|</samp>
            <samp><a href="/language/change?locale=us">English</a>|</samp>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-1 col-sm-2">
            <button type="submit" class="btn btn-default"><a href="/index"><spring:message code="message_login"/></a></button>
        </div>
    </div>
</form>
<script>

</script>
</body>
</html>
