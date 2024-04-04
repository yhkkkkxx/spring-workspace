<%--
  Created by IntelliJ IDEA.
  User: hayoung
  Date: 2024/03/27
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
  $(function(){
    login.init('<c:url value="/loginimpl"/>');
  });
</script>
<html>
<head>

  <div class="container">
    <h2>Login Page</h2>
    <form id="login_form">
      <div class="form-group">
        <label for="id">ID:</label>
        <input value="id01" type="text" class="form-control" id="id" placeholder="Enter id" name="id">
        <span id="id_span"></span>
      </div>
      <div class="form-group">
        <label for="pwd">Password:</label>
        <input value="pwd01" type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
        <span id="pwd_span"></span>
      </div>
      <div class="form-group form-check">
        <label class="form-check-label">
          <input class="form-check-input" type="checkbox" name="remember"> Remember me
        </label>
      </div>
      <button type="button" class="btn btn-primary">Login</button>
    </form>
  </div>

</head>
<body>

</body>
</html>