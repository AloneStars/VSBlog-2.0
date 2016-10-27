package com.violentstone.dao;

import java.util.List;

import com.violentstone.entity.Blog;

public interface IBlog {

	/**
	 * 添加博文
	 * @param blog
	 */
	int addBlog(Blog blog);
	
	/**
	 * 删除博文
	 * @param blogId
	 */
	int delBlog(int blogId);
	
	/**
	 * 更新博文
	 * @param blog
	 */
	int updateBlog(Blog blog);
	
	/**
	 * 查询博文ById
	 * @param blogId
	 * @return
	 */
	Blog queryBlog(int blogId);
	
	/**
	 * 查询所有博文
	 * @return List<Blog>
	 */	
	List<Blog> queryAllBlog();

	/**
	 * 查询所有博客类容
	 * @return List<Blog>
	 */
	List<Blog> queryDetails();
}
