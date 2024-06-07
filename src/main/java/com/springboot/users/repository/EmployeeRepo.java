package com.springboot.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.users.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{
 
    Employee findByEmployeeId(Long employeeId);
}
