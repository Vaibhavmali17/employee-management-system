package com.practiceEmployee.empManSystem.service.implserv;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;


import com.practiceEmployee.empManSystem.entity.Employee;
import com.practiceEmployee.empManSystem.exception.ResourceNotFoundException;
import com.practiceEmployee.empManSystem.repository.EmployeRepository;
import com.practiceEmployee.empManSystem.service.EmpSerivces;

import lombok.RequiredArgsConstructor;


@Service
public class EmplServImplem implements EmpSerivces {
	
	private EmployeRepository employerepository;
	
	public EmplServImplem(EmployeRepository employerepository) {
	
		this.employerepository = employerepository;
	}
		
	
	
	@Override
	public Employee createEmployee(Employee employee) {
		
		return employerepository.save(employee);
	}



	@Override
	public List<Employee> getAllEmloyee() {
		
		return employerepository.findAll();
	}



	@Override
	public Employee getEmpById(int id) {
	  Optional<Employee> employee = employerepository.findById(id);
	  
//	  if(employee.isPresent()) {
//		  return employee.get();
//	  }
//	  else
//	  {
//		  throw new ResourceNotFoundException("employee", "id", id);
//	  }
	  
	  return employerepository.findById(id).orElseThrow(()-> 
	   					new ResourceNotFoundException("employee", "id",id));
	}



	@Override
	public Employee updateEmployee(Employee employee, int id) {
		// fetching 
				Employee existEmployee =	employerepository.findById(id).orElseThrow( ()->
				new ResourceNotFoundException("employee", "id",id));
				
				// update
				existEmployee.setFirstName(employee.getFirstName());
				existEmployee.setLastName(employee.getLastName());
				existEmployee.setEmail(employee.getEmail());
				existEmployee.setRole(employee.getRole());
				
			  Employee updateEmployee = employerepository.save(existEmployee);
			   
			   return updateEmployee;
			
			}



	@Override
	public void deleteEmployee(int id) {
		
	  employerepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("employee","id",id));
	  
	  
	   employerepository.deleteById(id);

	
	}
	
	
	



	
	 
}
