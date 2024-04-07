
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
  let custadd = {
    init:function() {
      $('#add_btn').click(() => {
        let c = confirm('입력하시겠습니까?');
        if(c == true){
          custadd.send('<c:url value="/cust/addimpl"/>');
        }
      });
    },
    send:function(url) {
      $('#add_form').attr({
        'method':'post',
        'action':url
      });
      $('#add_form').submit();
    }
  }
  $(function() {
    custadd.init();
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
        <form id="add_form">
          <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">

          </div>
          <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">

          </div>
          <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">

          </div>
            <button id="add_btn" type="button" class="btn btn-primary">ADD</button>

        </form>
      </div>
    </div>
  </div>

</div>

