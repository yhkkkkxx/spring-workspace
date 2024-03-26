<%--
  Created by IntelliJ IDEA.
  User: hayoung
  Date: 2024/03/26
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello</h1>
<h2>${data}</h2>
<c:forEach var="s" items="${datas}">
    <h3>${s}</h3>
</c:forEach>
</body>
</html>
