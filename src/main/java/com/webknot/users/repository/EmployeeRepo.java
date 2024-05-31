package com.webknot.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webknot.users.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{
 
    Employee findByEmployeeId(Long employeeId);
}
