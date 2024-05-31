package com.amoda.EmpManage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "projectTable")
public class ProjDet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projidentity", unique = true)
    private long proj_id;

    public long getProj_id() {
        return proj_id;
    }

    public void setProj_id(long proj_id) {
        this.proj_id = proj_id;
    }

    @Column(name = "projtype")
    @Enumerated(value = EnumType.STRING)
    private EnumProjType ProjType;

    public EnumProjType getProjType() {
        return ProjType;
    }

    public void setProjType(EnumProjType projType) {
        ProjType = projType;
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
    @JoinColumn(name = "projaccountmanager", referencedColumnName = "user_id")
    private UserDet proj_acc_man;

    public UserDet getProj_acc_man() {
        return proj_acc_man;
    }

    public void setProj_acc_man(UserDet proj_acc_man) {
        this.proj_acc_man = proj_acc_man;
    }

    @ManyToOne
    @JoinColumn(name = "projmanager", referencedColumnName = "user_id")
    private UserDet proj_man;

    public UserDet getProj_man() {
        return proj_man;
    }

    public void setProj_man(UserDet proj_man) {
        this.proj_man = proj_man;
    }

    @Column(name = "projstatus")
    private EnumProjStatus projStatus;

    public EnumProjStatus getProjStatus() {
        return projStatus;
    }

    public void setProjStatus(EnumProjStatus projStatus) {
        this.projStatus = projStatus;
    }

    public ProjDet(){}
    
    public ProjDet(long proj_id, com.amoda.EmpManage.model.EnumProjType projType, String proj_sc, String proj_ec,
            String proj_desc, UserDet proj_acc_man, UserDet proj_man, EnumProjStatus projStatus) {
        this.proj_id = proj_id;
        ProjType = projType;
        this.proj_sc = proj_sc;
        this.proj_ec = proj_ec;
        this.proj_desc = proj_desc;
        this.proj_acc_man = proj_acc_man;
        this.proj_man = proj_man;
        this.projStatus = projStatus;
    }
    
}
