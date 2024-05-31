package com.amoda.EmpManage.model;

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
public class ProjAlloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "allocidentity")
    private long alloc_id;

    public long getAlloc_id() {
        return alloc_id;
    }

    public void setAlloc_id(long alloc_id) {
        this.alloc_id = alloc_id;
    }

    @ManyToOne
    @JoinColumn(name = "alloc_projid", referencedColumnName = "proj_id")
    private ProjDet proj_ident;

    public ProjDet getProj_ident() {
        return proj_ident;
    }

    public void setProj_ident(ProjDet proj_ident) {
        this.proj_ident = proj_ident;
    }

    @ManyToOne
    @JoinColumn(name = "alloc_empid", referencedColumnName = "emp_id")
    private EmpDet emp_ident;

    public EmpDet getEmp_ident() {
        return emp_ident;
    }

    public void setEmp_ident(EmpDet emp_ident) {
        this.emp_ident = emp_ident;
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
    private String alloc_percent;

    public String getAlloc_percent() {
        return alloc_percent;
    }

    public void setAlloc_percent(String alloc_percent) {
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

    public ProjAlloc(long alloc_id, ProjDet proj_ident, EmpDet emp_ident, String alloc_proj_role, String alloc_percent,
            String alloc_techstack, Integer alloc_duration) {
        this.alloc_id = alloc_id;
        this.proj_ident = proj_ident;
        this.emp_ident = emp_ident;
        this.alloc_proj_role = alloc_proj_role;
        this.alloc_percent = alloc_percent;
        this.alloc_techstack = alloc_techstack;
        this.alloc_duration = alloc_duration;
    }
    
}
