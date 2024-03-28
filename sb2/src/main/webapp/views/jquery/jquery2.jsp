<%--
  Created by IntelliJ IDEA.
  User: hayoung
  Date: 2024/03/27
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
  .div_bg {
    border: 6px solid red !important;
  }
</style>
<script>
  let jquery2 = {
    init: function() {
      $('#append').click(function(){
        $('#result').append('<h2>Append..</h2>');
      });
      $('#prepend').click(function(){
        $('#result').prepend('<h2>Prepend..</h2>');

      });
      $('#after').click(function(){
        $('#result').after('<h2>After..</h2>');

      });
      $('#before').click(function(){
        $('#result').before('<h2>Before..</h2>');

      });
      $('#remove').click(function(){
        $('#result').remove('<h2>Remove..</h2>');

      });
      $('#empty').click(function(){
        $('#result').empty('<h2>Empty..</h2>');

      });
    }
  }
  $(function() {
    jquery2.init();
  });
</script>
<div class="container">
  <h2>JQUERY2 Page</h2>
  <button id="append" type="button" class="btn btn-primary">APPEND</button>
  <button id="prepend" type="button" class="btn btn-primary">PREPEND</button>
  <button id="after" type="button" class="btn btn-primary">AFTER</button>
  <button id="before" type="button" class="btn btn-primary">BEFORE</button>
  <button id="remove" type="button" class="btn btn-primary">REMOVE</button>
  <button id="empty" type="button" class="btn btn-primary">EMPTY</button>
  <div id="result" class="containe div_bg">

  </div>
</div>
