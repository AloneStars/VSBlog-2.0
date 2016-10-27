/**
 * Created by ViolentStone on 2016/10/27.
 */

$(function(){

    document.onkeyup = function (event) {
        var e = event || window.event;
        var keyCode = e.keyCode || e.which;
        switch (keyCode) {
            case 13:
                checkUser();
                break;
            default:
                break;
        }
    }

});

function checkUser(){

    var verify = $("input:text").val();

    if(verify == ""){
        $(".notice-text").html("小暴暴：请先输入密令。");
    }else {
        //alert("verify:" + verify);

        var pasVerify = CryptoJS.SHA1(verify);

        //alert("pasVerify:" + pasVerify);

        $.ajax({
            type: "get",
            url: "http://localhost:8080/user/verify/" + pasVerify,
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            success: function (msg) {
                //alert(msg);
                var json = eval("(" + msg + ")");
                var errCode = json.errCode;
                //alert(errCode);
                $(".notice-text").html("小暴暴：" + json.msg);
            },
            error: function (jqXHR) {
                alert("请求失败了:" + jqXHR.status);
            }
        });
    }

}

