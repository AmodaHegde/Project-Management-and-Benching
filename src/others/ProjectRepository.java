package com.amoda.EmpManage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amoda.EmpManage.model.ProjDet;

public interface ProjectRepository extends JpaRepository<ProjDet, Long>{
    
}
