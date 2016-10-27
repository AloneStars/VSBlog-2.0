package com.violentstone.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by ViolentStone on 2016/10/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class IUserTest {

    @Resource
    private IUser iUser;

    @Test
    public void checkUser() throws Exception {

        System.out.println(iUser.checkUser());
    }

}