<%--
  Created by IntelliJ IDEA.
  User: hayoung
  Date: 2024/03/27
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="nav nav-pills flex-column">
  <p>AJAX</p>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/ajax/ajax1"/>">AJAX1</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/ajax/ajax2"/>">AJAX2</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/ajax/ajax3"/>">AJAX3</a>
  </li>
</ul>
