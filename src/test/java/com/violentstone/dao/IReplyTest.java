package com.violentstone.dao;

import com.violentstone.entity.Reply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created by ViolentStone on 2016/10/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class IReplyTest {

    @Resource
    private IReply iReply;

    @Test
    public void addReply() throws Exception {

        Reply reply = new Reply();

        reply.setAnswer("ViolentSone");
        reply.setAnswerDate("January 31, 2014");
        reply.setAnswerContent("那你BB啥？");
        reply.setComId(15);

        int number = iReply.addReply(reply);
        System.out.println("添加回复的数量："+number);
    }

    @Test
    public void delReplyByRly() throws Exception {

        int number = iReply.delReplyByRly(4);
        System.out.println("删除回复的数量："+number);

    }

    @Test
    public void delReplyByCom() throws Exception {

        int number = iReply.delReplyByCom(13);
        System.out.println("删除回复的数量："+number);
    }

    @Test
    public void updateReply() throws Exception {

        Reply reply = new Reply();

        reply.setRlyId(4);
        reply.setAnswer("ViolentSone");
        reply.setAnswerDate("January 31, 2014");
        reply.setAnswerContent("我就BB咋地？");
        reply.setComId(15);

        int number = iReply.updateReply(reply);
        System.out.println("更新回复信息："+number);
    }

    @Test
    public void queryReplyByRly() throws Exception {

        Reply reply = iReply.queryReplyByRly(4);
        System.out.println(reply);
    }

    @Test
    public void queryReplyByCom() throws Exception {

        List<Reply> replyList = iReply.queryReplyByCom(12);
        for (Reply reply: replyList) {
            System.out.println(reply);
        }
    }

}