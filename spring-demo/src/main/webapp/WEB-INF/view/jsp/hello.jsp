<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css">
</head>
<body>
hello,jsp, I am ${username}
<div>
    <%--<spring:message code="test"/>--%>
</div>
</body>
</html>
