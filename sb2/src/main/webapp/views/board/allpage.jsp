<%--
  Created by IntelliJ IDEA.
  User: hayoung
  Date: 2024/04/08
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    .comment {
        color: red;
    }
</style>
<div class="container">
    <h1>Get Board</h1>
    <table class="table table-striped" id="board_table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>CustId</th>
            <th>RegDate</th>
            <th>Click</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="b" items="${cpage.getList()}">
            <tr>
                <td><a href="<c:url value="/board/detail"/>?id=${b.boardId}">${b.boardId}</a></td>
                <td>${b.boardTitle}
                    <c:if test="${b.commentCnt != 0}">
                        <span class="comment">[${b.commentCnt}]</span></td>
                    </c:if>
                <td>${b.custId}</td>
                <td>
                    <fmt:parseDate value="${b.boardRegdate}"
                                   pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                    <fmt:formatDate pattern="yyyy년MM월dd일 HH시mm분" value="${ parsedDateTime }" />
                </td>
                <td>${b.boardCnt}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <jsp:include page="../page.jsp"/>
</div>