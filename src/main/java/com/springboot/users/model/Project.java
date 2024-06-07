package com.springboot.users.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "projectTable")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId", unique = true)
    private long projectId;

    public long getProjectId() {
        return projectId;
    }

    public void setProj_id(long projectId) {
        this.projectId = projectId;
    }

    @Column(name = "projtype")
    @Enumerated(value = EnumType.STRING)
    private EnumProjType projType;

    public EnumProjType getProjType() {
        return projType;
    }

    public void setProjType(EnumProjType projType) {
        this.projType = projType;
    }

    @Column(name = "projsc")
    private String proj_sc;

    public String getProj_sc() {
        return proj_sc;
    }

    public void setProj_sc(String proj_sc) {
        this.proj_sc = proj_sc;
    }

    @Column(name = "projec")
    private String proj_ec;

    public String getProj_ec() {
        return proj_ec;
    }

    public void setProj_ec(String proj_ec) {
        this.proj_ec = proj_ec;
    }

    @Column(name = "projdesc")
    private String proj_desc;

    public String getProj_desc() {
        return proj_desc;
    }

    public void setProj_desc(String proj_desc) {
        this.proj_desc = proj_desc;
    }

    @ManyToOne
    @JoinColumn(name = "projaccountmanager", referencedColumnName = "empidentity")
    @JsonBackReference
    private Employee projaccountmanager;

    public Employee getProjaccountmanager() {
        return projaccountmanager;
    }

    public void setProjaccountmanager(Employee projaccountmanager) {
        this.projaccountmanager = projaccountmanager;
    }

    @ManyToOne
    @JoinColumn(name = "projmanager", referencedColumnName = "empidentity")
    @JsonBackReference
    private Employee projmanager;

    public Employee getProjmanager() {
        return projmanager;
    }

    public void setProjmanager(Employee projmanager) {
        this.projmanager = projmanager;
    }

    @Column(name = "projstatus")
    @Enumerated(value = EnumType.STRING)
    private EnumProjStatus projStatus;

    public EnumProjStatus getProjStatus() {
        return projStatus;
    }

    public void setProjStatus(EnumProjStatus projStatus) {
        this.projStatus = projStatus;
    }

    @OneToMany(mappedBy = "projectId")
    @JsonManagedReference
    private List<ProjectAlloc> projectAlloc;

    public List<ProjectAlloc> getProjectAlloc() {
        return projectAlloc;
    }

    public void setProjectAlloc(List<ProjectAlloc> projectAlloc) {
        this.projectAlloc = projectAlloc;
    }

    public Project(){}

    public Project(long projectId, EnumProjType projType, String proj_sc, String proj_ec, String proj_desc,
            EnumProjStatus projStatus) {
        this.projectId = projectId;
        this.projType = projType;
        this.proj_sc = proj_sc;
        this.proj_ec = proj_ec;
        this.proj_desc = proj_desc;
        this.projStatus = projStatus;
    }

    public Project(EnumProjType projType, String proj_sc, String proj_ec, String proj_desc, EnumProjStatus projStatus) {
        this.projType = projType;
        this.proj_sc = proj_sc;
        this.proj_ec = proj_ec;
        this.proj_desc = proj_desc;
        this.projStatus = projStatus;
    }

    public Project(EnumProjType projType, String proj_sc, String proj_ec, String proj_desc, Employee projaccountmanager,
            Employee projmanager, EnumProjStatus projStatus) {
        this.projType = projType;
        this.proj_sc = proj_sc;
        this.proj_ec = proj_ec;
        this.proj_desc = proj_desc;
        this.projaccountmanager = projaccountmanager;
        this.projmanager = projmanager;
        this.projStatus = projStatus;
    }
    
}

