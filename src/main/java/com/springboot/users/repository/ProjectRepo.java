package com.springboot.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.users.model.Project;

public interface ProjectRepo extends JpaRepository<Project, Long>{
    
    Project findByProjectId(Long projectId);
}
 
