package com.violentstone.dto;

import org.springframework.stereotype.Component;

import java.util.Date;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/10/25 创造的作品
 * ********************************************************
 * +描述:验证码实体类
 *********************************************************/
@Component
public class VerifyCode {

    private String code;

    private Date  createDate;

    public void setMsg(String code) {
        this.code = code;
        this.createDate = new Date();
    }

    public String getCode() {
        return code;
    }

    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "VerifyCode{" +
                "code='" + code + '\'' +
                ", createDate=" + createDate +
                '}';
    }

}
