<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <spring:message code="test"/>
    <div>
        <a href="http://localhost:8080/locale-demo?locale=zh_CN">中文</a>
        <a href="http://localhost:8080/locale-demo?locale=en_US">English</a>
    </div>
</div>
</body>
</html>
