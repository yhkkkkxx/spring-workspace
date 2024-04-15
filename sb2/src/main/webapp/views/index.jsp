<%--
  Created by IntelliJ IDEA.
  User: hayoung
  Date: 2024/03/26
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap 4 Website Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="<c:url value="/js/0327.js"/>"></script>
    <%--KAKAO Map API--%>
    <script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e874df38b9cea9b070cf9266aab4cc6e"></script>
    <%--HighCharts API--%>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <script src="https://code.highcharts.com/modules/series-label.js"></script>
    <script src="https://code.highcharts.com/modules/exporting.js"></script>
    <script src="https://code.highcharts.com/modules/export-data.js"></script>
    <script src="https://code.highcharts.com/modules/accessibility.js"></script>
    <script src="https://code.highcharts.com/highcharts-3d.js"></script>

<%--    web socket--%>
    <script src="<c:url value="/webjars/sockjs-client/sockjs.min.js"/>"></script>
    <script src="<c:url value="/webjars/stomp-websocket/stomp.min.js"/>"></script>
    <style>
        .fakeimg {
            height: 200px;
            background: #aaa;
        }
        #con {
            margin-bottom: 50px;
        }
        #notice {
            margin: 10px;
        }
        #noticetext {
            color: red;
        }
    </style>
    <script>
        let notice = {
            stompClient:null,
            init: function () {
                notice.connect();
            },
            connect:function(){
                console.log("complete connect");

                <%--let socket = new SockJS("<c:out value='${serverurl}'/>"+"/nws");--%>
                let socket = new SockJS("${serverurl}/nws");
                this.stompClient = Stomp.over(socket);

                this.stompClient.connect({}, function(frame) {
                    console.log('Connected: ' + frame);
                    this.subscribe('/send/notice', function(msg) {
                        console.log("notice")

                        $("#noticetext").text("ㅤ"+JSON.parse(msg.body).content1.toString());
                    });
                });
            }
            // disconnect:function(){
            //     if (this.stompClient !== null) {
            //         this.stompClient.disconnect();
            //     }
            //     console.log("Disconnected");
            // }
        };
        $(function () {
             notice.init();
        });
    </script>
</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">
    <h1><spring:message code="site.title" arguments="aa,aa"/></h1>
    <h5><spring:message code="site.phone" arguments="aa,aa"/></h5>
</div>


<c:choose>
    <c:when test="${id == null}">

        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/login"/>">LOGIN</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/register"/>">REGISTER</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/aboutus"/>">ABOUT US</a>
            </li>
        </ul>
    </c:when>
    <c:otherwise>
        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/mypage/"/>">${id}</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/logoutimpl"/>">LOGOUT</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/chat"/>">Chat</a>
            </li>
        </ul>
    </c:otherwise>
</c:choose>

<%--Nav Bar--%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="<c:url value="/"/>">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" href="<c:url value="/login"/>">LOGIN</a>--%>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" href="<c:url value="/register"/>">REGISTER</a>--%>
<%--            </li>--%>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/html/"/>">HTML</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/jquery/"/>">jQuery</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/ajax/"/>">Ajax</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/geo/"/>">Geo</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/chart/"/>">Chart</a>
            </li>
            <c:if test="${id!=null}">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/cust/"/>">Cust</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/item/"/>">Item</a>
                </li>
            </c:if>
            <li class="nav-item">
                <a class="nav-link" href="#">ABOUT US</a>
            </li>
        </ul>
    </div>
</nav>

<div id="notice">
    <label> 🔔 공지사항</label>
    <label id="noticetext"></label>
</div>

<%--End Nav Bar--%>

<%--Center Area--%>
<div id="con" class="container-fluid" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-2">
            <c:choose>
                <c:when test="${left==null}">
                    <jsp:include page="left.jsp"></jsp:include>
                </c:when>
                <c:otherwise>
                    <jsp:include page="${left}.jsp"></jsp:include>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-sm-10">
            <c:choose>
                <c:when test="${center==null}">
                    <jsp:include page="center.jsp"/>
                </c:when>
                <c:otherwise>
                    <jsp:include page="${center}.jsp"/>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
<%--End Center Area--%>

<%--Start Botton Area--%>
<div class="jumbotron text-center" style="margin-bottom:0">
    <p>Footer</p>
</div>
<%--End Botton Area--%>

</body>
</html>