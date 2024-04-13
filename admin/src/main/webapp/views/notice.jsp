<%--
  Created by IntelliJ IDEA.
  User: hayoung
  Date: 2024/04/12
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    #notice {
        height: 100px;
    }
</style>

<script>
    let notice = {
        init: function () {
            notice.connect();
            $('#send').click(function() {
                let msg = JSON.stringify({
                    'content1' : $("#noticetext").val()
                });
                console.log("complete connect");
                notice.stompClient.send("/receivenotice", {}, msg);
                console.log("complete send");
                // notice.disconnect();
            });

        },
        connect:function(){
            let socket = new SockJS('${serverurl}/nws');
            this.stompClient = Stomp.over(socket);

            this.stompClient.connect({}, function(frame) {
                console.log('Connected: ' + frame);
                this.subscribe('/send/notice', function(msg) {
                    console.log("notice")
                    $("#complete").text("\""+JSON.parse(msg.body).content1.toString()+"\" 전달 완료✔️");
                });
            });
        },
        disconnect:function(){
            if (this.stompClient !== null) {
                this.stompClient.disconnect();
            }
            console.log("Disconnected");
        }
    };
    $(function () {
        notice.init();
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
                <label for="notice">공지사항 📣</label>
                <h6 id="complete"></h6>
                <input id="noticetext" type="text" class="form-control" id="notice" placeholder="Enter notice" name="notice"> <br/>
                <button id="send" type="button" class="btn btn-primary">SEND</button>
            </div>
        </div>
    </div>

</div>
