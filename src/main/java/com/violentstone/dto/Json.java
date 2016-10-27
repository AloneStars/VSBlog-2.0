package com.violentstone.dto;

import java.util.Date;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/10/27 创造的作品
 * ********************************************************
 * +描述:Json内容类
 *********************************************************/
public class Json {

    private String errCode;

    private String msg;

    private Date createDate;

    /*****************constructor******************/
    public Json(String errCode, String msg, Date createDate) {
        this.createDate = createDate;
        this.errCode = errCode;
        this.msg = msg;
    }

    /*************setter and getter*****************/
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /***************toString***************/
    @Override
    public String toString() {
        return "Json{" +
                "createDate=" + createDate +
                ", errCode='" + errCode + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
