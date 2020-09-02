<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css">
</head>
<body>
theme demo
<a href="http://localhost:8080/theme-demo?theme=red">red</a>
<a href="http://localhost:8080/theme-demo?theme=blue">blue</a>
<div>
</div>
</body>
</html>
