package com.myCompany.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myCompany.dao.ProjectDAO;
import com.myCompany.objects.Project;
import com.myCompany.objects.Project;
import com.myCompany.service.ProjectService;
@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDAO;
	
	public ProjectServiceImpl() {
		super(); 
	} 
	
	@Override
	public Project createProject(Project project) {
		// TODO Auto-generated method stub
		return projectDAO.createProject(project);
	}

	@Override
	public Project getProject(int id) {
		// TODO Auto-generated method stub
		return projectDAO.getProject(id);
	}

	@Override
	public Project updateProject(Project project) {
		// TODO Auto-generated method stub
		return projectDAO.updateProject(project);
	}

	@Override
	public void deleteProject(int id) {
		projectDAO.deleteProject(id);
	}

	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return projectDAO.getAllProjects();
	}

	@Override
	public boolean projectExists(int id) {
		// TODO Auto-generated method stub
		return projectDAO.projectExists(id);
	}

	
}
