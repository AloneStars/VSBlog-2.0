package com.violentstone.dao;

import com.violentstone.entity.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created by ViolentStone on 2016/10/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class IProjectTest {

    @Resource
    private IProject iProject;

    @Test
    public void addProject() throws Exception {

        Project project = new Project();
        project.setProName("校园团体展示平台");
        project.setProImage("gdp.jpg");
        project.setProType(2);
        project.setProDec("introduce");
        project.setProSrc("www.violentstone.com/gdp");

        int number = iProject.addProject(project);
        System.out.println("插入项目数量:"+number);
    }

    @Test
    public void delProject() throws Exception {

        int number = iProject.delProject(9);
        System.out.println("删除项目数量："+number);
    }

    @Test
    public void updateProject() throws Exception {

        Project project = new Project();
        project.setProId(9);
        project.setProName("校园团体展示平台");
        project.setProImage("gdp.jpg");
        project.setProType(3);
        project.setProDec("introduce");
        project.setProSrc("www.violentstone.com/gdp");

        int number = iProject.updateProject(project);
        System.out.println("更新项目数量："+number);

    }

    @Test
    public void queryProject() throws Exception {

        Project project = iProject.queryProject(9);
        System.out.println(project);

    }

    @Test
    public void queryAllProject() throws Exception {

        List<Project> projectList = iProject.queryAllProject();
        for (Project proejct: projectList) {
            System.out.println(proejct);
        }
    }

}