package com.practiceEmployee.empManSystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practiceEmployee.empManSystem.entity.Employee;
import com.practiceEmployee.empManSystem.service.EmpSerivces;

@RestController
@RequestMapping("/employee")
public class EmployeController {

	private EmpSerivces employeservices;

	public EmployeController(EmpSerivces employeservices) {
		super();
		this.employeservices = employeservices;
	}
	
	@PostMapping()
	public ResponseEntity<Employee> createEmployee( @RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeservices.createEmployee(employee),
				HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeservices.getAllEmloyee();
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Employee> getEmpById(@PathVariable int id){
		 return new ResponseEntity<Employee>(employeservices.getEmpById(id),
				HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeservices.updateEmployee(employee ,id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id){
		employeservices.deleteEmployee(id);
		
		return new  ResponseEntity<Employee>( HttpStatus.OK);
	}
	
}
