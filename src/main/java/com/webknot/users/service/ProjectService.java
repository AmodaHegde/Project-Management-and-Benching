package com.webknot.users.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webknot.users.dto.ProjectDetailsWithEmployeesResponse;
import com.webknot.users.model.Employee;
import com.webknot.users.model.EnumProjStatus;
import com.webknot.users.model.Project;
import com.webknot.users.model.ProjectAlloc;
import com.webknot.users.repository.EmployeeRepo;
import com.webknot.users.repository.ProjectAllocRepo;
import com.webknot.users.repository.ProjectRepo;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ProjectAllocRepo projectAllocRepo;

    public Project createProject(Project project, Long accountManagerId, Long projectManagerId) {
        Employee accountManager = employeeRepo.findByEmployeeId(accountManagerId);
        Employee projectManager = employeeRepo.findByEmployeeId(projectManagerId);

        project.setProjaccountmanager(accountManager);
        project.setProjmanager(projectManager);

        return projectRepo.save(project);
    }

    public void addEmpToProj(Long projectId, Long employeeId, String projectRole, Integer allocationPercentage, String techStack, Integer durationInWeeks){
        
        Project project = projectRepo.findByProjectId(projectId);
        Employee employee = employeeRepo.findByEmployeeId(employeeId);

        ProjectAlloc projectEmployee = new ProjectAlloc();
        projectEmployee.setProjectId(project);
        projectEmployee.setEmployeeId(employee);
        projectEmployee.setAlloc_proj_role(projectRole);
        projectEmployee.setAlloc_percent(allocationPercentage);
        projectEmployee.setAlloc_techstack(techStack);
        projectEmployee.setAlloc_duration(durationInWeeks);

        projectAllocRepo.save(projectEmployee);
    }

    public void removeEmpFromProj(Long projectId, Long employeeId) {
        Project project = projectRepo.findByProjectId(projectId);
        Employee employee = employeeRepo.findByEmployeeId(employeeId);

        projectAllocRepo.deleteByProjectIdAndEmployeeId(project, employee);
    }

    public Project getProject(Long proj_id) {
        return projectRepo.findByProjectId(proj_id);
    }

    public List<Project> getAllProject() {
        
        return projectRepo.findAll();
    }

    public List<ProjectDetailsWithEmployeesResponse> getAllProjectDetails() {
        return projectRepo.findAll().stream().map(project -> {
            ProjectDetailsWithEmployeesResponse response = new ProjectDetailsWithEmployeesResponse();
            response.setProject(project);
            response.setAccountManager(project.getProjaccountmanager());
            response.setProjectManager(project.getProjmanager());
            return response;
        }).collect(Collectors.toList());
    }
    
    public ProjectDetailsWithEmployeesResponse getProjectDetails(Long projectId) {
        Project project = projectRepo.findByProjectId(projectId);
        ProjectDetailsWithEmployeesResponse response = new ProjectDetailsWithEmployeesResponse();
        response.setProject(project);
        response.setAccountManager(project.getProjaccountmanager());
        response.setProjectManager(project.getProjmanager());
        return response;
    }

    public void setStatus(Long projectId){
        Project project = projectRepo.findByProjectId(projectId);
        project.setProjStatus(EnumProjStatus.INACTIVE);
        projectRepo.save(project);
    }

}
