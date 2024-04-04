<%--
  Created by IntelliJ IDEA.
  User: hayoung
  Date: 2024/04/03
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(function () {
        addaddr.init('<c:url value="/mypage/addaddrimpl"/>');
    });
</script>
<div class="container">
    <h2>Add Address</h2>
    <form id="addaddr_form">
        <br/>
        <div class="input-group">
            <span class="input-group-text">alias</span>
            <input id="addrName" type="text" class="form-control" placeholder="Enter Alias" name="addrName">
        </div>
        <br/>
        <div class="input-group">
            <span class="input-group-text">address</span>
            <input id="addrDetail" type="text" class="form-control" placeholder="Enter Address" name="addrDetail">
        </div>
        <br/>
        <button id="button" type="button" class="btn btn-primary">Add</button>
    </form>

</div>
