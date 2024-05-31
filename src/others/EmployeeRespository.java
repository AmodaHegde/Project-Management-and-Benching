package com.amoda.EmpManage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amoda.EmpManage.model.EmpDet;

public interface EmployeeRespository extends JpaRepository<EmpDet, Long>{
    
}
