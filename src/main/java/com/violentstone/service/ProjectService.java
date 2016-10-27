package com.violentstone.service;

import com.violentstone.dao.IProject;
import com.violentstone.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**********************************************************
 * +茫茫人海与你相遇即是一种缘分,这让我不得不好好自我介绍一下
 * +吾名 "暴力的小石头/ViolentStone",吾乃一Java程序猿
 * +吾信 "猿" 乃一世变者
 * +你见到的这个玩意儿,就是吾在 2016/10/20 创造的作品
 * ********************************************************
 * +描述:与项目相关的所有Service
 *********************************************************/
@Service
public class ProjectService implements IProject {

    @Autowired
    private IProject iProject;

    @Override
    public int addProject(Project project) {
        int number = iProject.addProject(project);
        return number;
    }

    @Override
    public int delProject(int proId) {
        int number = iProject.delProject(proId);
        return number;
    }

    @Override
    public int updateProject(Project project) {
        int number = iProject.updateProject(project);
        return number;
    }

    @Override
    public Project queryProject(int proId) {
        Project project = iProject.queryProject(proId);
        return project;
    }

    @Override
    public List<Project> queryAllProject() {
        List<Project> projectList = iProject.queryAllProject();
        return projectList;
    }
}
