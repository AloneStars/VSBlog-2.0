package com.violentstone.dao;

import com.violentstone.entity.User;

public interface IUser {
	
	 /**
	  * 验证登录
	  * @parmar order 口令
	  * return 用户信息
	  */
      User checkUser();
     
}
