package com.amoda.EmpManage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amoda.EmpManage.model.ProjAlloc;

public interface AllocationRepository extends JpaRepository<ProjAlloc, Long>{
    
}
