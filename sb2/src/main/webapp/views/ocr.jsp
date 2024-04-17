<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
  <h2>OCR</h2>

  <form id="ocr_form" action="<c:url value="/ocrimpl"/>" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="image">Image:</label>
      <input type="file"  class="form-control" id="image" placeholder="Enter name" name="image">
    </div>

    <button id="btn_sends" type="submit" class="btn btn-primary">Send</button>

  </form>
  <c:if test="${imgname != null}">
    <img width="300px" src="/imgs/<c:url value="${imgname}"/>"/>
    <h6>${result.bizname}</h6>
    <h6>${result.bizowner}</h6>
    <h6>${result.bizdate}</h6>
    <h6>${result.bizadd}</h6>
  </c:if>
</div>
