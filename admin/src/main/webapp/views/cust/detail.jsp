
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
  let detail = {
    init:function() {
      $('#upd_btn').click(() => {
        let c = confirm('수정하시겠습니까?');
        if (c == true) {
          this.send();
        }
        detail.send('<c:url value="/cust/update"/>');
      });
      $('#del_btn').click(() => {
        let c = confirm('삭제하시겠습니까?');
        if (c == true) {
             let id = $('#id').val();
            location.href = "<c:url value="/cust/delete"/>?id="+id;
        }
      });

    },
    send:function() {
      $('#detail_form').attr({
        'method':'post',
        'action':'<c:url value="/cust/update"/>'
      });
      $('#detail_form').submit();
    }
  }
  $(function() {
    detail.init();
  });
</script>

<div class="container-fluid">

  <!-- Page Heading -->
  <h1 class="h3 mb-2 text-gray-800">Tables</h1>

  <!-- DataTales Example -->
  <div class="card shadow mb-4">
    <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
    </div>
    <div class="card-body">
      <div class="table-responsive">
        <form id="detail_form">
          <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" value="${cust.id}" class="form-control" id="id" placeholder="Enter id" name="id" readonly>

          </div>
          <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password"  value="${cust.pwd}"  class="form-control" id="pwd" placeholder="Enter password" name="pwd">

          </div>
          <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" value="${cust.name}" class="form-control" id="name" placeholder="Enter name" name="name">

          </div>
            <button id="upd_btn" type="button" class="btn btn-primary">UPDATE</button>
            <button id="del_btn" type="button" class="btn btn-danger">DELETE</button>

        </form>
      </div>
    </div>
  </div>

</div>

