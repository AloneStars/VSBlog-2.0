package com.violentstone.service;

import com.violentstone.dao.IReply;
import com.violentstone.entity.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/10/20 创造的作品
 * ********************************************************
 * +描述:与回复相关的所有的Service
 *********************************************************/
@Service
public class ReplyService implements IReply {

    @Autowired
    private IReply iReply;

    @Override
    public int addReply(Reply reply) {
        int number = iReply.addReply(reply);
        return number;
    }

    @Override
    public int delReplyByRly(int rlyId) {
        int number = iReply.delReplyByRly(rlyId);
        return number;
    }

    @Override
    public int delReplyByCom(int comId) {
        int number = iReply.delReplyByCom(comId);
        return number;
    }

    @Override
    public int updateReply(Reply reply) {
        int number = iReply.updateReply(reply);
        return number;
    }

    @Override
    public Reply queryReplyByRly(int rlyId) {
        Reply reply = iReply.queryReplyByRly(rlyId);
        return reply;
    }

    @Override
    public List<Reply> queryReplyByCom(int comId) {
        List<Reply> replyList = iReply.queryReplyByCom(comId);
        return replyList;
    }
}
