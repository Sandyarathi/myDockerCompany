package com.myCompany.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myCompany.objects.Employee;
import com.myCompany.objects.Project;
import com.myCompany.service.ProjectService;

@RestController
@RequestMapping("/cmpe282SandyarathiDas036/rest")
@Configuration
@ComponentScan("com.company.service")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	public ProjectController() {
		System.out.println("projectController()");
	}
	
	@RequestMapping(value="/project", method = RequestMethod.POST, 
			produces = "application/json", consumes= "application/json")
	public ResponseEntity<Project> createProject( @RequestBody @Valid Project project){
		if(!projectService.projectExists(project.id)){
			Project proj = projectService.createProject(project);
			if(proj !=null){
				return new ResponseEntity<Project>(proj,HttpStatus.CREATED);
			}
			else
				return new ResponseEntity<Project>(HttpStatus.CONFLICT);
		}
		else
			return new ResponseEntity<Project>(HttpStatus.CONFLICT);
	}
	
	@RequestMapping(value="/project/{project_id}", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<Project> viewProject(@PathVariable("project_id") int projectId ) {
	  if(projectService.projectExists(projectId))
		  return new ResponseEntity<Project>(projectService.getProject(projectId), HttpStatus.OK);
	  else{
		  
		  return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
	  }
    }
	
	
	
	@RequestMapping(value="/project/{project_id}", method = RequestMethod.PUT, produces ="application/json")
	public ResponseEntity<Project> updateProject(@PathVariable int project_id, @RequestBody @Valid Project project) {
		if(projectService.projectExists(project_id)){
			if(project.id == project_id){
				return new ResponseEntity<Project>(projectService.updateProject(project), HttpStatus.OK);
			}
			else{
				if(projectService.projectExists(project_id)){
					return new ResponseEntity<Project>(HttpStatus.CONFLICT);
				}
				else
					return new ResponseEntity<Project>(projectService.updateProject(project), HttpStatus.OK);
			}
		}
		else
			 return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);

	}
	
	
	
	@RequestMapping(value="/project/{project_id}", method = RequestMethod.DELETE, produces ="application/json")
    public ResponseEntity<String> deleteProject(@PathVariable("project_id") int projectId ) {
	  if(projectService.projectExists(projectId)){
		  projectService.deleteProject(projectId);
		  return new ResponseEntity<String>( HttpStatus.OK);
	  }
	  else{
		  
		  return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	  }
    }
	
	
	
	@RequestMapping(value="/project", method = RequestMethod.GET, produces ="application/json")
	public ResponseEntity<List<Project>> listAllProjects() {
		List<Project> empList= projectService.getAllProjects();
		if(!empList.isEmpty())
			return new ResponseEntity<List<Project>>(empList, HttpStatus.OK);		  
		else
			return new ResponseEntity<List<Project>>(HttpStatus.NOT_FOUND);  
			
	}

}
