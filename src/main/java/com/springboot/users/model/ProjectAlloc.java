package com.webknot.users.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "projectAllocationTable")
public class ProjectAlloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "allocidentity")
    private long allocationId;

    public long getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(long allocationId) {
        this.allocationId = allocationId;
    }

    @ManyToOne
    @JoinColumn(name = "alloc_projid", referencedColumnName = "projectId")
    @JsonBackReference
    private Project projectId;

    public Project getProjectId() {
        return projectId;
    }

    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }

    @ManyToOne
    @JoinColumn(name = "alloc_empid", referencedColumnName = "empidentity")
    @JsonBackReference
    private Employee employeeId;

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name = "projrole")
    private String alloc_proj_role;

    public String getAlloc_proj_role() {
        return alloc_proj_role;
    }

    public void setAlloc_proj_role(String alloc_proj_role) {
        this.alloc_proj_role = alloc_proj_role;
    }

    @Column(name = "allocpercentage")
    private Integer alloc_percent;

    public Integer getAlloc_percent() {
        return alloc_percent;
    }

    public void setAlloc_percent(Integer alloc_percent) {
        this.alloc_percent = alloc_percent;
    }

    @Column(name = "alloctechstack")
    private String alloc_techstack;

    public String getAlloc_techstack() {
        return alloc_techstack;
    }

    public void setAlloc_techstack(String alloc_techstack) {
        this.alloc_techstack = alloc_techstack;
    }

    @Column(name = "allocduration")
    private Integer alloc_duration;

    public Integer getAlloc_duration() {
        return alloc_duration;
    }

    public void setAlloc_duration(Integer alloc_duration) {
        this.alloc_duration = alloc_duration;
    }

    public ProjectAlloc(){}

    public ProjectAlloc( String alloc_proj_role, Integer alloc_percent, String alloc_techstack,
    Integer alloc_duration) {
        this.alloc_proj_role = alloc_proj_role;
        this.alloc_percent = alloc_percent;
        this.alloc_techstack = alloc_techstack;
        this.alloc_duration = alloc_duration;
}
    
    public ProjectAlloc(long alloc_id, String alloc_proj_role, Integer alloc_percent, String alloc_techstack,
            Integer alloc_duration) {
        this.allocationId = alloc_id;
        this.alloc_proj_role = alloc_proj_role;
        this.alloc_percent = alloc_percent;
        this.alloc_techstack = alloc_techstack;
        this.alloc_duration = alloc_duration;
    }

    public ProjectAlloc(Project projectId, Employee employeeId, String alloc_proj_role, Integer alloc_percent,
            String alloc_techstack, Integer alloc_duration) {
        this.projectId = projectId;
        this.employeeId = employeeId;
        this.alloc_proj_role = alloc_proj_role;
        this.alloc_percent = alloc_percent;
        this.alloc_techstack = alloc_techstack;
        this.alloc_duration = alloc_duration;
    }
    
}
