package com.violentstone.dao;

import com.violentstone.entity.Comment;
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
//告诉junit Spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ICommentTest {

    @Resource
    private IComment iComment;

    @Test
    public void addComment() throws Exception {

        Comment comment = new Comment();
        comment.setQuestioner("耀光下的孤星");
        comment.setQuestionDate("January 31, 2014");
        comment.setQuestionContent("该说点啥了");
        comment.setEmail("1138494584@qq.com");
        comment.setBlogId(11);

        int number = iComment.addComment(comment);
        System.out.println("添加评论的条数："+number);
    }

    @Test
    public void delCommentByCom() throws Exception {
        int number = iComment.delCommentByCom(16);
        System.out.println("删除评论的条数："+number);
    }

    @Test
    public void delCommentByBlog() throws Exception {
        int number = iComment.delCommentByBlog(11);
        System.out.println("删除评论的条数："+number);
    }

    @Test
    public void updateComment() throws Exception {

        Comment comment = new Comment();
        comment.setComId(15);
        comment.setQuestioner("耀光下的孤星");
        comment.setQuestionDate("January 31, 2014");
        comment.setQuestionContent("啥也不想和你说");
        comment.setEmail("1138494584@qq.com");
        comment.setBlogId(1);

        int number = iComment.updateComment(comment);
        System.out.println("更新评论的数量："+number);

    }

    @Test
    public void queryCommentByCom() throws Exception {

        Comment comment = iComment.queryCommentByCom(15);
        System.out.println(comment);
    }

    @Test
    public void queryCommentByBlog() throws Exception {

        List<Comment> commentList = iComment.queryCommentByBlog(1);

        for (Comment comment: commentList) {
            System.out.println(comment);
        }
    }

}