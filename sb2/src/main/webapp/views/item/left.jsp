<%--
  Created by IntelliJ IDEA.
  User: hayoung
  Date: 2024/04/08
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul class="nav nav-pills flex-column">
  <p>Item</p>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/item/add"/>">add</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/item/get"/>">get</a>
  </li>

</ul>
