package com.myCompany.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myCompany.objects.Project;
@Repository
public interface ProjectDAO {
	
	/**
	* Used to Create the Project Information
	* @param employee
	* @return {@link Project}
	*/
	public Project createProject(Project employee);

	/**
	* Getting the Project Information using Id
	* @param id
	* @return {@link Project}
	*/
	public Project getProject(int id);

	/**
	* Used to Update the Project Information
	* @param employee
	* @return {@link Project}
	*/

	public Project updateProject(Project employee);

	/**
	* Deleting the Project Information using Id
	* @param id
	*/
	public void deleteProject(int id);

	/**
	* Getting the All Projects information
	* @return
	*/
	public List<Project> getAllProjects();
	/**
	 * Check if project record exists
	 * */
	 public boolean projectExists(int id);

}
