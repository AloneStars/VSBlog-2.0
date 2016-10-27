package com.violentstone.web;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.violentstone.dto.Json;
import com.violentstone.dto.Token;
import com.violentstone.dto.VerifyCode;
import com.violentstone.email.Send;
import com.violentstone.entity.User;
import com.violentstone.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.util.Date;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/10/25 创造的作品
 * ********************************************************
 * +描述:用户控制类
 *********************************************************/
@Controller
@RequestMapping("/user")//url:/模块/资源/{id}/细分 /user/verify
public class UserController {

    private final Logger looger = LoggerFactory.getLogger(this.getClass());

    public static Gson gson = new Gson();

    @Autowired
    private VerifyCode verifyCode;

    @Autowired
    private UserService userService;

    @Autowired
    private Token token;

    /**
     * 注意这里的路径的设置，如果/{verify}和/{order}的两个链接springMVC无法分析交给谁来判断所以路径
     * 一定不能有冲突，或者有歧义。
     * @param verify
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/verify/{verify}", method = RequestMethod.GET)
    public String verify(@PathVariable("verify") String verify,Model model){

        looger.info("开始验证验证码");
        //3.通过动态口令获取用户信息
        User user = userService.checkUser(verify);

        if(user!= null)
            return gson.toJson(new Json("200",gson.toJson(user),new Date()));
        else
            return gson.toJson(new Json("002","密令验证失败",new Date())) ;
    }

    @ResponseBody
    @RequestMapping(value = "/order/{order}", method = RequestMethod.GET)
    public String username(@PathVariable("order") String order,Model model){

        looger.info("开始验证口令");
        //1.验证口令是否正确
        if(userService.checkOrder(order)){
            /*
             * 2.验证口令成功,以邮件的形式发送动态口令
             */
            verifyCode.setMsg(token.randToken());

            looger.info("验证码信息："+verifyCode.toString());

            Send send = new Send("/email.properties");

            send.email("1138494584@qq.com", "VSBlog登录提醒","有人正在在尝试登录主人的网站，如果不是主人亲自操作，请注意有人可能正在攻击你的网站,下面是本次登录的动态口令:<br/><h1 style='color:#08c;'>动态口令:"+verifyCode.getCode()+"</h1>");

            return gson.toJson(new Json("200","口令验证成功",new Date()));

        }

        return gson.toJson(new Json("001","口令验证失败",new Date()));

    }

}
