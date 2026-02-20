package com.practiceEmployee.empManSystem.service;

import java.util.List;

import com.practiceEmployee.empManSystem.entity.Employee;

public interface EmpSerivces {

	Employee createEmployee(Employee employee);
	
	List<Employee> getAllEmloyee();
	
	Employee getEmpById(int id);
	
	public Employee updateEmployee(Employee employee,int id);
	
	  public void  deleteEmployee(int id);
}
