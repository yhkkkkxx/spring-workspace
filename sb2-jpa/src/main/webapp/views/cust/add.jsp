<%--
  Created by IntelliJ IDEA.
  User: hayoung
  Date: 2024/04/03
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(function () {
        addcust.init('<c:url value="/cust/addimpl"/>');
    });
</script>
<div class="container">
    <h2>Add Customer</h2>
    <form id="add_form">
        <br/>
        <div class="input-group">
            <span class="input-group-text">ID</span>
            <input id="id" type="text" class="form-control" placeholder="Enter ID" name="id">
        </div>
        <br/>
        <div class="input-group">
            <span class="input-group-text">name</span>
            <input id="name" type="text" class="form-control" placeholder="Enter name" name="name">
        </div>
        <br/>
        <div class="input-group">
            <span class="input-group-text">pwd</span>
            <input id="pwd" type="password" class="form-control" placeholder="Enter password" name="pwd">
        </div>
        <br/>
        <button type="button" class="btn btn-primary">Add</button>
    </form>

</div>
