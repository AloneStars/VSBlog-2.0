package com.violentstone.service;

import com.violentstone.entity.Blog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/10/20 创造的作品
 * ********************************************************
 * +描述:BlogService的测试类
 *********************************************************/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-web.xml","classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
//@ContextConfiguration({"classpath:spring/spring-*.xml"})这种方法更保险
/**
 * 解释一下为什么上面非要导入classpath:spring/spring-web.xml，其实我们不是为了导入这个配置文件，只是为了扫描dto包，并将 这些配置
 * 到IOC容器中，但是这个包的扫描我统一写到了classpath:spring/spring-web.xml中，在说明为什么我们要扫描dto包呢？我们的这个测试时
 * 用不到，但是我们在测试前加载了classpath:spring/spring-service.xml，所以service包下的类会被自动注入IOC容器中，因为userService
 * 中用到了dto中的自动注入，所以我们要扫描dto包到IOC容器中。
 * ***************************************************
 * 为了避免以上的错误，我建议将所有对包的扫描竟可能的放到一个配置文件中，在测试的时候，导入所有需要注入到IOC中的类，不管需不需要。
 */
public class BlogServiceTest {

    //导入日志实例
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BlogService blogService;

    @Test
    public void addBlog() throws Exception {

        Blog blog = new Blog();
        blog.setBlogImg("images/blog/blog-1.jpg,images/blog/blog-2.jpg,images/blog/blog-3.jpg");
        blog.setBlogTitle("论java中“==”与equals的区别");
        blog.setPublishDate("January 31, 2014");
        blog.setAuthor("ViolentStone");
        blog.setTag("java web");
        blog.setBlogContent("我咋知道吗？你又没告诉我");

        int number = blogService.addBlog(blog);

       logger.info("添加Blog数量:{}",number);
    }

    @Test
    public void delBlog() throws Exception {

    }

    @Test
    public void updateBlog() throws Exception {

    }

    @Test
    public void queryBlog() throws Exception {

    }

    @Test
    public void queryAllBlog() throws Exception {

    }

    @Test
    public void queryDetails() throws Exception {

    }

}