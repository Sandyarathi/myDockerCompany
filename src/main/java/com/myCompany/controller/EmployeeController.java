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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myCompany.objects.Employee;
import com.myCompany.service.EmployeeService;


@RestController
@RequestMapping("/cmpe282SandyarathiDas036/rest")
@Configuration
@ComponentScan("com.company.service")
public class EmployeeController {
		
	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeController() {
		System.out.println("EmployeeController()");
	}
	
	@RequestMapping(value="/employee", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Employee> createEmployee( @RequestBody @Valid Employee employee){
		Employee emp = employeeService.createEmployee(employee);
		if(emp !=null){
			 if(employeeService.employeeExists(emp.id)){
				 return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
			 }
			 else
				 return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
	}
	
			

	
	
	@RequestMapping(value="/employee/{employee_id}", method = RequestMethod.GET, produces ="application/json")
    public ResponseEntity<Employee> viewEmployee(@PathVariable("employee_id") int employeeId ) {
	  if(employeeService.employeeExists(employeeId))
		  return new ResponseEntity<Employee>(employeeService.getEmployee(employeeId), HttpStatus.OK);
	  else{
		  
		  return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	  }
    }
	
	
	@RequestMapping(value="/employee/{employee_id}", method = RequestMethod.PUT, produces ="application/json")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int employee_id, @RequestBody @Valid Employee employee) {
		if(employeeService.employeeExists(employee_id)){
			if(employee.id == employee_id){
				return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK);
			}
			else{
				if(employeeService.employeeExists(employee_id)){
					//return conflict error code, if the put request uses an already existing id while updating record
					return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
				}
				else
					return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK);
			}
		}
		else
			 return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);

	}
	
	
	@RequestMapping(value="/employee/{employee_id}", method = RequestMethod.DELETE, produces ="application/json")
    public ResponseEntity<String> deleteEmployee(@PathVariable("employee_id") int employeeId ) {
		if(employeeService.employeeExists(employeeId)){
		  employeeService.deleteEmployee(employeeId);
		  return new ResponseEntity<String>( HttpStatus.OK);
	  }
	  else{
		  return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	  }
    }
	
	
	@RequestMapping(value="/employee", method = RequestMethod.GET, produces ="application/json")
	public ResponseEntity<List<Employee>> listAllEmployees() {
		List<Employee> empList= employeeService.getAllEmployees();
		if(!empList.isEmpty())
			return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);		  
		else
			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);  
			
	}
	

}



