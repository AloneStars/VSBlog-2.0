package com.violentstone.service;

import com.violentstone.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/10/25 创造的作品
 * ********************************************************
 * +描述:用户服务层测试类
 *********************************************************/
@RunWith(SpringJUnit4ClassRunner.class)
/*注意这里配置文件的导入一定要全面，一定要确保测试中用到的对象，都已经被所有配置文件中扫描到的IOC中*/
@ContextConfiguration({"classpath:spring/spring-web.xml","classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
//@ContextConfiguration({"classpath:spring/spring-*.xml"})这种方法更保险
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void checkUser() throws Exception {

        User user = userService.checkUser("");

        System.out.println(user);

    }

    @Test
    public void checkOrder() throws Exception{

        System.out.println(userService.checkOrder("d933b39f1a5fd850091fc2f7b1793406d68542e9"));

    }

}