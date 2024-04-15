<%--
  Created by IntelliJ IDEA.
  User: hayoung
  Date: 2024/04/01
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    let detail = {
        init: function () {
        }
    };
    $(function () {
        detail.init();
    });
</script>
<div class="container">
    <h1>detail</h1>
    <h2>${custs.id}</h2>
    <h2>${custs.pwd}</h2>
    <h2>${custs.name}</h2>
</div>
