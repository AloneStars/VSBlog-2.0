package com.violentstone.service;

import com.violentstone.Util.SHA1;
import com.violentstone.dao.IUser;
import com.violentstone.dto.VerifyCode;
import com.violentstone.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/10/20 创造的作品
 * ********************************************************
 * +描述:和用户相关的Service
 *********************************************************/
@Service
public class UserService{

    private final Logger looger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUser iUser;

    @Autowired
    private VerifyCode verifyCode;

    /**
     * check 口令
     * @param order
     * @return boolean
     */
    public boolean checkOrder(String order) {

        Properties prop = new Properties();

        InputStream in = null;

        User user = null;

        String config = "";

        try {

            in =getClass().getResourceAsStream("/Order.properties");

            prop.load(in);

            config  = SHA1.encryptSHA(prop.getProperty("order"));

            if(config.equals(order)){
                looger.info("口令验证成功，加密口令为："+config);
                return true;
            }


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * 获取用户信息
     * @return user
     */
    public User checkUser(String verify){

        User user = null;

        String pasVerify = "";

        try {

            pasVerify = SHA1.encryptSHA(verifyCode.getCode());

            //验证动态口令是否正确
            if(pasVerify.equals(verify)){
                //口令正确从数据库中获取用户信息
                looger.info("正在验证验证码，加密验证码为" + pasVerify);
                looger.info("验证码验证成功，输入加密验证码为" + verify);
                user = iUser.checkUser();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
