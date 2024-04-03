<%--
  Created by IntelliJ IDEA.
  User: hayoung
  Date: 2024/04/03
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
  <h2>My Address List</h2>

  <table class="table table-striped">
    <thead>
    <tr>
      <th>배송지명</th>
      <th>주소</th>
      <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="a" items="${addrlist}">
      <tr>
        <td>${a.addrName}</td>
        <td>${a.addrDetail}</td>
        <td>
          <a href="<c:url value="/mypage/deladdr"/>?id=${a.addrId}" class="btn btn-secondary">Delete</a>
<%--          <button id="del_btn" type="button" class="btn btn-secondary">Delete</button>--%>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
