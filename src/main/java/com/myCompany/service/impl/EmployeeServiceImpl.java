package com.myCompany.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myCompany.dao.EmployeeDAO;
import com.myCompany.objects.Employee;
import com.myCompany.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl() {
		super(); 
	} 
	
	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.createEmployee(employee);
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee(id);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeDAO.deleteEmployee(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployees();
	}

	@Override
	public boolean employeeExists(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.employeeExists(id);
	}

	

}
