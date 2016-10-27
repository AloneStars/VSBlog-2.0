package com.violentstone.dao;

import java.util.List;

import com.violentstone.entity.Project;

public interface IProject {

	/**
	 * 添加项目
	 * @param project
	 */
	 int addProject(Project project);
	
    /**
     * 删除项目
     * @param proId
     */
	 int delProject(int proId);
	
	/**
	 * 更新项目
	 * @param project
	 */
	 int updateProject(Project project);
	
	/**
	 * 查询项目
	 * @param proId
	 * @return Project
	 */
	 Project queryProject(int proId);
	
	/**
	 * 查询所有项目
	 * @return List<Project>
	 */
	 List<Project> queryAllProject();
	
}
