package com.violentstone.service;

import com.violentstone.dao.IBlog;
import com.violentstone.entity.Blog;
import com.violentstone.entity.Comment;
import com.violentstone.entity.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/10/20 创造的作品
 * ********************************************************
 * +描述:关于博客的service
 *********************************************************/
@Service
public class BlogService implements IBlog {

    //自动注入mapper实现类
    @Autowired
    private IBlog iBlog;

    @Override
    @Transactional
    public int addBlog(Blog blog) {
        int number = iBlog.addBlog(blog);
        return number;
    }

    @Override
    public int delBlog(int blogId) {
        int number = iBlog.delBlog(blogId);
        return number;
    }

    @Override
    public int updateBlog(Blog blog) {
        int number = iBlog.updateBlog(blog);
        return number;
    }

    @Override
    public Blog queryBlog(int blogId) {
        Blog blog = iBlog.queryBlog(blogId);
        return blog;
    }

    @Override
    public List<Blog> queryAllBlog() {
        List<Blog> blogList = iBlog.queryAllBlog();
        return blogList;
    }

    @Override
    public List<Blog> queryDetails() {
        List<Blog> blogList = iBlog.queryDetails();
        for (Blog blog: blogList) {
           List<Comment> commentList =  blog.getCommentList();
            if((commentList.size()==1) && (commentList.get(0).isNull()))
                blog.setCommentList(null);
            else{
                for (Comment comment:commentList) {
                    List<Reply> replyList = comment.getReplyList();
                    if((replyList.size()==1) && (replyList.get(0).isNull()))
                        comment.setReplyList(null);
                }
            }
        }
        return blogList;
    }
}
