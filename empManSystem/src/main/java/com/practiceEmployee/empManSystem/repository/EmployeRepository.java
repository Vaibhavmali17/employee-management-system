package com.practiceEmployee.empManSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practiceEmployee.empManSystem.entity.Employee;

//@Repository
public interface EmployeRepository extends JpaRepository<Employee, Integer> {

}
