package com.webknot.users.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.webknot.users.model.Employee;
import com.webknot.users.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/emp/add")
    public Employee addEmployee(@RequestBody Employee request) {
        return employeeService.addNewEmp(request);
    }
    
    @GetMapping("/emp/get-emp/{emp_id}")
    public Employee searchEmployee(@PathVariable("emp_id") Long emp_id){
        return employeeService.getEmpById(emp_id);
    }

    @GetMapping("/emp/get-all-emp")
    public List<Employee> getAllEmps(){
         return employeeService.getAllEmps();
    }

    @GetMapping("/emp/bench-list")
    public ResponseEntity<List<Map<String, Object>>> getBenchList() {
        try {
            List<Map<String, Object>> benchList = employeeService.getBenchList();
            return ResponseEntity.ok(benchList);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching bench list", e);
        }
    }

    
}
