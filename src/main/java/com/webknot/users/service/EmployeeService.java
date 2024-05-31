package com.webknot.users.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webknot.users.model.Employee;
import com.webknot.users.model.ProjectAlloc;
import com.webknot.users.repository.EmployeeRepo;
import com.webknot.users.repository.ProjectAllocRepo;
import com.webknot.users.repository.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    ProjectAllocRepo projectAllocRepo;

    public Employee addNewEmp(Employee request) {

        Employee employee = new Employee();
        employee.setEmp_name(request.getEmp_name());
        employee.setEmp_tech(request.getEmp_tech());
        employee.setEmp_yoe(request.getEmp_yoe());
        employee.setEmp_yoew(request.getEmp_yoew());
        return employeeRepo.save(employee);
    }

    public Employee getEmpById(Long id) {
        return employeeRepo.findByEmployeeId(id);
    }

    public List<Employee> getAllEmps() {
        
        return employeeRepo.findAll();
    }

    @Transactional
    public List<Map<String, Object>> getBenchList() {
        List<ProjectAlloc> allocations = projectAllocRepo.findAllocationsLessThanNinetyPercent();

       return allocations.stream()
            .map(alloc -> {
                Map<String, Object> map = new HashMap<>();
                map.put("employeeId", alloc.getEmployeeId().getEmployeeId());
                map.put("employeeName", alloc.getEmployeeId().getEmp_name());
                map.put("techStack", alloc.getAlloc_techstack());
                map.put("allocationPercentage", alloc.getAlloc_percent());
                return map;
            })
            .collect(Collectors.toList());
    }
}
    
