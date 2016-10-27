package com.violentstone.dao;

import java.util.List;

import com.violentstone.entity.Reply;

public interface IReply {
	
    /**
     * 添加回复
     * @param reply
     */
	 int addReply(Reply reply);
	
	/**
	 * 删除回复通过回复Id
	 * @param rlyId 回复Id
	 */
	 int delReplyByRly(int rlyId);
	
	/**
	 * 删除回复通过平论Id
	 * @param comId 评论Id
	 */
	 int delReplyByCom(int comId);
	
	/**
	 * 修改回复
	 * @param reply
	 */
	 int updateReply(Reply reply);
	
	/**
	 * 查询回复By RlyId
	 * @param rlyId 回复Id
	 * @return Reply
	 */
	 Reply queryReplyByRly(int rlyId);
	
	/**
	 * 查询所有回复By ComId
	 * @param comId 评论Id
	 * @return Reply
	 */
	 List<Reply> queryReplyByCom(int comId);

}
