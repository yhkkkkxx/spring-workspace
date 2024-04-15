<%--
  Created by IntelliJ IDEA.
  User: hayoung
  Date: 2024/03/27
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
  let cust_left = {
    init: function () {
      $('#cust_add').click(()=>{
        var login_id = '${sessionScope.id}';
        if(login_id == '' || login_id == null){
          alert('ID를 입력 하세요');
          return;
        }
      });
    }
  };
  $(function () {
    cust_left.init();
  });
</script>
<ul class="nav nav-pills flex-column">
  <p>CUST</p>
  <li class="nav-item">
    <a id="cust_add" class="nav-link" href="<c:url value="/cust/add"/>">ADD</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/cust/get"/>">GET</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/cust/allpage?pageNo=1"/>">ALL PAGE</a>
  </li>
</ul>
