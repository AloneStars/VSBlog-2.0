package com.violentstone.service;

import com.violentstone.dao.IComment;
import com.violentstone.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/10/20 创造的作品
 * ********************************************************
 * +描述:评论相关的所有的service
 *********************************************************/
@Service
public class CommentService implements IComment {

    @Autowired
    private IComment iComment;

    @Override
    public int addComment(Comment comment) {
        int number = iComment.addComment(comment);
        return number;
    }

    @Override
    public int delCommentByCom(int comId) {
        int number = iComment.delCommentByCom(comId);
        return number;
    }

    @Override
    public int delCommentByBlog(int blogId) {
        int number = iComment.delCommentByBlog(blogId);
        return number;
    }

    @Override
    public int updateComment(Comment comment) {
        int number = iComment.updateComment(comment);
        return number;
    }

    @Override
    public Comment queryCommentByCom(int comId) {
        Comment comment = iComment.queryCommentByCom(comId);
        return comment;
    }

    @Override
    public List<Comment> queryCommentByBlog(int blogId) {
        List<Comment> commentList = iComment.queryCommentByBlog(blogId);
        return commentList;
    }
}
