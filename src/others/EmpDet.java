package com.amoda.EmpManage.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employeeTable")
public class EmpDet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empidentity", unique = true)
    private long emp_id;

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    @OneToOne
    @JoinColumn(name = "emp_userid", referencedColumnName = "user_id")
    private UserDet emp_user_id;

    public UserDet getUserDet() {
        return emp_user_id;
    }

    public void setUserDet(UserDet emp_user_id) {
        this.emp_user_id = emp_user_id;
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

    public EmpDet(){}

    public EmpDet(long emp_id, UserDet emp_user_id, String emp_tech, Integer emp_yoe, Integer emp_yoew) {
        this.emp_id = emp_id;
        this.emp_user_id = emp_user_id;
        this.emp_tech = emp_tech;
        this.emp_yoe = emp_yoe;
        this.emp_yoew = emp_yoew;
    }


}
