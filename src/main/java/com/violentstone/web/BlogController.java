package com.violentstone.web;

import com.google.gson.Gson;
import com.violentstone.entity.Blog;
import com.violentstone.service.BlogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/10/27 创造的作品
 * ********************************************************
 * +描述:Blog相关的控制类
 *********************************************************/
@Controller
@RequestMapping("/blog")
public class BlogController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Gson gson = new Gson();

    @Autowired
    private BlogService blogService;

    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String getBlogMsg(Model model){

        List<Blog> blogList = blogService.queryDetails();

        return gson.toJson(blogList);
    }

}
