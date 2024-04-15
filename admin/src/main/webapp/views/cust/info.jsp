<%--
  Created by IntelliJ IDEA.
  User: hayoung
  Date: 2024/04/15
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Tables</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
<%--        <div class="card-header py-3">--%>
<%--            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>--%>
<%--        </div>--%>

        <div class="card-body">
            <div class="table-responsive">
                <label>현재 로그인 사용자 수 💁🏻 ${cnt}</label>
            </div>
        </div>
    </div>


    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>ID</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>ID</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach var="l" items="${loginlist}">
                    <tr>
                        <td>${l.loginId}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>