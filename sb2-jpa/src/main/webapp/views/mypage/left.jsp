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
  <p>MY PAGE</p>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/mypage/address"/>">ADDRESS LIST</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/mypage/addaddr"/>">ADD ADDRESS</a>
  </li>
</ul>
