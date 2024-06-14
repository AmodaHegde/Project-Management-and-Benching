package com.springboot.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.users.model.Employee;
import com.springboot.users.model.Project;
import com.springboot.users.model.ProjectAlloc;

public interface ProjectAllocRepo extends JpaRepository<ProjectAlloc, Long>{
    List<ProjectAlloc> findByProjectId(Project project);
    void deleteByProjectIdAndEmployeeId(Project project, Employee employee);

    @Query("SELECT pa FROM ProjectAlloc pa WHERE pa.alloc_percent < 90")
    List<ProjectAlloc> findAllocationsLessThanNinetyPercent();
}
