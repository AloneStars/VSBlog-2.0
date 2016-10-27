package com.violentstone.dao;

import java.util.List;

import com.violentstone.entity.Comment;

public interface IComment {
    
   /**
    * 添加评论
    * @param comment
    */
   int addComment(Comment comment);
	
	/**
	 * 删除博文通过ComId
	 * @param comId
	 */
	int delCommentByCom(int comId);
	
	/**
	 * 删除博文通过BlogId
	 * @param blogId
	 */
	 int delCommentByBlog(int blogId);
	
	
	/**
	 * 修改博文
	 * @param comment
	 */
	 int updateComment(Comment comment);
	
	/**
	 * 查询博文通过ComId
	 * @param comId
	 * @return Comment
	 */
	 Comment queryCommentByCom(int comId);
	
	/**
	 * 查询博文通过BlogId
	 * @param blogId
	 * @return List<Comment>
	 */
	 List<Comment> queryCommentByBlog(int blogId);
	
}
