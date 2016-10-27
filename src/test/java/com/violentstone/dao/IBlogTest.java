package com.violentstone.dao;

import com.violentstone.entity.Blog;
import com.violentstone.entity.Comment;
import com.violentstone.entity.Reply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ViolentStone on 2016/10/19.
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-text,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit Spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class IBlogTest {

    @Resource
    private IBlog iBlog;

    @Test
    public void addBlog() throws Exception {

        Blog blog = new Blog();
        blog.setBlogImg("images/blog/blog-1.jpg,images/blog/blog-2.jpg,images/blog/blog-3.jpg");
        blog.setBlogTitle("论java中“==”与equals的区别");
        blog.setPublishDate("January 31, 2014");
        blog.setAuthor("ViolentStone");
        blog.setTag("java");
        blog.setBlogContent("我咋知道吗？你又没告诉我");

        int number = iBlog.addBlog(blog);

        System.out.println("添加Blog数量:"+number);
    }

    @Test
    public void delBlog() throws Exception {

        int number = iBlog.delBlog(12);
        System.out.println("删除Blog数量:"+number);

    }

    @Test
    public void updateBlog() throws Exception {

        Blog blog = new Blog();

        blog.setBlogId(12);
        blog.setBlogImg("images/blog/blog-1.jpg,images/blog/blog-2.jpg,images/blog/blog-3.jpg");
        blog.setBlogTitle("论java中“==”与equals的区别");
        blog.setPublishDate("January 31, 2014");
        blog.setAuthor("ViolentStone");
        blog.setTag("java web");
        blog.setBlogContent("java中的equals方法和“==”的功能十分的相似，但是二者有很明显的不同。");

        int number = iBlog.updateBlog(blog);
        System.out.println(number);
    }

    @Test
    public void queryBlog() throws Exception {

        Blog blog = iBlog.queryBlog(11);
        System.out.println(blog);

    }

    @Test
    public void queryAllBlog() throws Exception {

        List<Blog> blogList = new ArrayList<Blog>();

        blogList = iBlog.queryAllBlog();

        for (Blog blog: blogList) {
            System.out.println(blog);
        }
    }

    @Test
    public void queryDetails() throws Exception {

        List<Blog> blogList = null;

        blogList = iBlog.queryDetails();

        List<Comment> commentList = null;

        List<Reply> replyList = null;

        for (Blog blog : blogList) {

            System.out.println(blog.toString());

            System.out.println("该博客评论总数:"+blog.getCommentList().size());

            commentList = blog.getCommentList();

            for (Comment comment : commentList) {

                System.out.println(comment.toString());

                System.out.println("该评论回复总数:"+comment.getReplyList().size());

                replyList = comment.getReplyList();

                for (Reply reply : replyList) {

                    System.out.println("回复类容:"+reply.toString());

                }

            }

        }
    }
}