package com.myCompany.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myCompany.objects.Employee;
@Service
public interface EmployeeService {

	/**
	* Used to Create the Employee Information
	* @param employee
	* @return {@link Employee}
	*/
	public Employee createEmployee(Employee employee);

	/**
	* Getting the Employee Information using Id
	* @param id
	* @return {@link Employee}
	*/
	public Employee getEmployee(int id);

	/**
	* Used to Update the Employee Information
	* @param employee
	* @return {@link Employee}
	*/

	public Employee updateEmployee(Employee employee);

	/**
	* Deleting the Employee Information using Id
	* @param id
	*/
	public void deleteEmployee(int id);

	/**
	* Getting the All Employees information
	* @return
	*/
	public List<Employee> getAllEmployees();
	
	/**
	 * Check if record exists
	 */
	public boolean employeeExists(int id);

	} 
