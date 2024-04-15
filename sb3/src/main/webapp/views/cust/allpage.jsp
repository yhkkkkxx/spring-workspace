<%--
  Created by IntelliJ IDEA.
  User: hayoung
  Date: 2024/04/03
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

</script>

<div class="container">
    <h2>Get Customer</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>PWD</th>
            <th>NAME</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="c" items="${cpage.getList()}">
                <tr>
                    <td><a href="<c:url value="/cust/detail"/>?id=${c.id}">${c.id}</a></td>
                    <td>${c.pwd}</td>
                    <td>${c.name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <jsp:include page="../page.jsp"/>
</div>