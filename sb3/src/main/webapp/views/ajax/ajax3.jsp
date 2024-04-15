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
  let ajax3 = {
    init: function() {
      let rankinglist = $('#ranking');
      setInterval(function() {
        $.ajax({
          url:'<c:url value="/ranking"/>',
          success: function(data){
            ajax3.display(data);
          }
        })
      }, 5000);
    },
    display: function(list) {
      let result = ''
      list.forEach((s, i) => {
        result += '<li>'+s+'</li>';
      });
      $('#ranking').html(result);
    }

  }

  $(function() {
    ajax3.init();
  })
</script>
<style>
  ol {
    list-style-type: decimal;
  }
</style>
<div class="container">
  <h2>AJAX3 Page</h2>
  <div class="container">
    <h3>오늘의 🔥HOT🔥 논란 인물</h3>
    <ol id="ranking">
<%--      <c:forEach var="r" items="${rankings}">--%>
<%--        <li>r</li>--%>
<%--      </c:forEach>--%>
    </ol>

  </div>
</div>
