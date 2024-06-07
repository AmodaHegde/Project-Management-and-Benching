package com.webknot.users.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.webknot.users.model.Employee;
import com.webknot.users.model.Project;
import com.webknot.users.model.ProjectAlloc;

public interface ProjectAllocRepo extends JpaRepository<ProjectAlloc, Long>{
    List<ProjectAlloc> findByProjectId(Project project);
    void deleteByProjectIdAndEmployeeId(Project project, Employee employee);

    @Query("SELECT pa FROM ProjectAlloc pa WHERE pa.alloc_percent < 90")
    List<ProjectAlloc> findAllocationsLessThanNinetyPercent();
}
