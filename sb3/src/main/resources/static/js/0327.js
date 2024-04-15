
let login = {
    url:'',
    init: function(url){
        this.url = url;
        $('#login_form > button').click(function (){
            let id = $('#id').val();
            let pwd = $('#pwd').val();
            if(id == '' || id == null) {
                alert('ID를 입력하세요');
                $('#id').focus();
                return;
            }
            if(pwd == '' || pwd == null) {
                alert('PWD를 입력하세요');
                $('#pwd').focus();
                return;
            }
            login.send();
        });
    },
    send: function(){
        $('#login_form').attr({
            'method':'post',
            'action': this.url
        });
        $('#login_form').submit();
    }
};



let datas = [
    {"id":"id01","name":"james1"},
    {"id":"id02","name":"james2"},
    {"id":"id03","name":"james3"},
    {"id":"id04","name":"james4"},
    {"id":"id05","name":"james5"}
];

let html2={
    init:function (){
        $('#btn').click(function(){
            html2.display(datas);
        });
    },
    display:function(datas){
        let result = '';
        $(datas).each(function(index,data){
            result+= '<tr>';
            result+= '<td>'+data.id +'</td>';
            result+= '<td>'+data.name+'</td>';
            result+= '</tr>';
        });
        // $(datas).each(function(index,data){
        //     result+= '<h3>';
        //     result+= data.id + ' ' + data.name;
        //     result+= '</h3>';
        // });
        // $(result).html(result);
        $('#cust_tb > tbody').html(result);
    }

};


let addcust = {
    url:'',
    init: function(url) {
        this.url = url;
        $('#add_form > button').click(function() {
            let id = $('#id').val();
            let name = $('#name').val();
            let pwd = $('#pwd').val();
            if(id == '' || id == null) {
                alert('ID를 입력하세요');
                $('#id').focus();
                return;
            }
            else if(name == '' || name == null) {
                alert('이름을 입력하세요');
                $('#name').focus();
                return;
            }
            else if(pwd == '' || pwd == null) {
                alert('PWD를 입력하세요');
                $('#pwd').focus();
                return;
            }
            addcust.send();
        });
    },
    send: function() {
        $('#add_form').attr({
            'method':'post',
            'action': this.url
        });
        $('#add_form').submit();
    }

};

let addaddr = {
    url:'',
    init: function(url) {
        this.url = url;
        $('#addaddr_form > button').click(function() {
            let alias = $('#addrName').val();
            let address = $('#addrDetail').val();
            if(alias == '' || alias == null) {
                alert('배송지명을 입력하세요');
                $('#alias').focus();
                return;
            }
            else if(address == '' || address == null) {
                alert('배송지를 입력하세요');
                $('#address').focus();
                return;
            }
            addaddr.send();
        });
    },
    send: function() {
        $('#addaddr_form').attr({
            'method':'post',
            'action': this.url
        });
        $('#addaddr_form').submit();
    }
};
