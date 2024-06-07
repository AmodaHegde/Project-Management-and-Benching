package com.webknot.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webknot.users.model.Project;

public interface ProjectRepo extends JpaRepository<Project, Long>{
    
    Project findByProjectId(Long projectId);
}
 
