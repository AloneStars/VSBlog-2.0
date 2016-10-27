/**
 * Created by ViolentStone on 2016/10/27.
 */

$(function(){

    document.onkeyup = function (event) {
        var e = event || window.event;
        var keyCode = e.keyCode || e.which;
        switch (keyCode) {
            case 13:
                checkOrder();
                break;
            default:
                break;
        }
    }

});

function checkOrder(){

    var order = $("input:text").val();

    if(order == ""){
        $(".notice-text").html("小暴暴：请先输入口令。");
    }else {

        //alert("order:"+order);

        var pasOrder = CryptoJS.SHA1(order);

        //alert("pasOrder:"+pasOrder);

        $.ajax({
            type: "get",
            url: "http://localhost:8080/user/order/" + pasOrder,
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function (msg) {
                //alert(msg);
                var json = eval("(" + msg + ")");
                var errCode = json.errCode;
                //alert(errCode);
                if (errCode == "200") {
                    //alert("准备跳转");
                    window.location.href = "welcome.html";
                } else {
                    //alert("出现意外了");
                    $(".notice-text").html("小暴暴：" + json.msg);
                }
            },
            error: function (jqXHR) {
                alert("请求失败了:" + jqXHR.status);
            }
        });
    }

}

