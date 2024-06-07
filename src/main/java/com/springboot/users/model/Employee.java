package com.springboot.users.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.JoinColumn;
// import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employeeTable")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empidentity", unique = true)
    private long employeeId;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name = "empname")
    private String emp_name;

    // @OneToOne
    // @JoinColumn(name = "emp_userid", referencedColumnName = "user_id")
    // private User user;

    // public User getUser() {
    //     return user;
    // }

    // public void setUser(User user) {
    //     this.user = user;
    // }

    // public User getUserDet() {
    //     return user;
    // }

    // public void setUserDet(User emp_user_id) {
    //     this.user = emp_user_id;
    // }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    @Column(name = "emptech")
    private String emp_tech;

    public String getEmp_tech() {
        return emp_tech;
    }

    public void setEmp_tech(String emp_tech) {
        this.emp_tech = emp_tech;
    }

    @Column(name = "empyoe")
    private Integer emp_yoe;

    public Integer getEmp_yoe() {
        return emp_yoe;
    }

    public void setEmp_yoe(Integer emp_yoe) {
        this.emp_yoe = emp_yoe;
    }

    @Column(name = "empyoew")
    private Integer emp_yoew;

    public Integer getEmp_yoew() {
        return emp_yoew;
    }

    public void setEmp_yoew(Integer emp_yoew) {
        this.emp_yoew = emp_yoew;
    }

    @OneToMany(mappedBy = "projaccountmanager")
    @JsonManagedReference
    private List<Project> accountManagerProjects;

    public List<Project> getAccountManagerProjects() {
        return accountManagerProjects;
    }

    public void setAccountManagerProjects(List<Project> accountManagerProjects) {
        this.accountManagerProjects = accountManagerProjects;
    }

    @OneToMany(mappedBy = "projmanager")
    @JsonManagedReference
    private List<Project> projectManagerProjects;

    public List<Project> getProjectManagerProjects() {
        return projectManagerProjects;
    }

    public void setProjectManagerProjects(List<Project> projectManagerProjects) {
        this.projectManagerProjects = projectManagerProjects;
    }

    @OneToMany(mappedBy = "employeeId")
    @JsonManagedReference
    private List<ProjectAlloc> projectAlloc;

    public List<ProjectAlloc> getProjectAlloc() {
        return projectAlloc;
    }

    public void setProjectAlloc(List<ProjectAlloc> projectAlloc) {
        this.projectAlloc = projectAlloc;
    }

    public Employee(){}

    public Employee(String emp_name, String emp_tech, Integer emp_yoe, Integer emp_yoew) {
        this.emp_name = emp_name;
        this.emp_tech = emp_tech;
        this.emp_yoe = emp_yoe;
        this.emp_yoew = emp_yoew;
    }

    public Employee(String emp_name, String emp_tech, Integer emp_yoe, Integer emp_yoew, List<Project> accountManagerProjects,
            List<Project> projectManagerProjects) {
        this.emp_name = emp_name;
        this.emp_tech = emp_tech;
        this.emp_yoe = emp_yoe;
        this.emp_yoew = emp_yoew;
        this.accountManagerProjects = accountManagerProjects;
        this.projectManagerProjects = projectManagerProjects;
    }


}
