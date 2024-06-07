package com.springboot.users.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.users.controller.errors.InactiveProjectException;
import com.springboot.users.dto.ProjectDetailsWithEmployeesResponse;
import com.springboot.users.model.EnumProjStatus;
import com.springboot.users.model.Project;
import com.springboot.users.repository.ProjectRepo;
import com.springboot.users.service.ProjectService;

@RestController
public class ProjectController {

    //can be implemented inplace of dto

    static class ProjectRequest {
        public Project getProject() {
            return project;
        }
        public void setProject(Project project) {
            this.project = project;
        }
        private Project project;
        public Long getAccountManagerId() {
            return accountManagerId;
        }
        public void setAccountManagerId(Long accountManagerId) {
            this.accountManagerId = accountManagerId;
        }
        private Long accountManagerId;
        public Long getProjectManagerId() {
            return projectManagerId;
        }
        public void setProjectManagerId(Long projectManagerId) {
            this.projectManagerId = projectManagerId;
        }
        private Long projectManagerId;
    }

    // field injection

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectRepo projectRepo;

    //creation of projects

    @PostMapping("/project/create")
    public void createProject(@RequestBody ProjectRequest request){
        projectService.createProject(
            request.getProject(),
            request.getAccountManagerId(),
            request.getProjectManagerId()
    );
    }

    //getting project details by id

    @GetMapping("/project/get-project/{projectId}")
    public Project getProject(@PathVariable("projectId") Long projectId){
        return projectService.getProject(projectId);
    }

    // getting all projects

    @GetMapping("/project/get-all-projects")
    public List<ProjectDetailsWithEmployeesResponse> getAllProjects(){
        return projectService.getAllProjectDetails();
    }

    // removing employees from project by id

    @DeleteMapping("/project/{proj_id}/remove-employee/{emp_id}")
    public void removeEmpFromProj(@PathVariable() Long proj_id, @PathVariable() Long emp_id) {
        projectService.removeEmpFromProj(proj_id, emp_id);
    }

    // adding employees to projects

    @PostMapping("/project/{proj_id}/add-employee")
    public void addEmpToProj(@PathVariable() Long proj_id, @RequestBody Map<String, String> body){
        Project project = projectRepo.findByProjectId(proj_id);
        EnumProjStatus curr = project.getProjStatus();
        if(curr.equals(EnumProjStatus.ACTIVE)){
            Long emp_id = Long.parseLong(body.get("employeeId"));
            String projectRole = body.get("alloc_proj_role");
            Integer allocPer = Integer.parseInt(body.get("alloc_percent"));
            String techStack = body.get("alloc_techstack");
            Integer durationInWeeks = Integer.parseInt(body.get("alloc_duration"));
            projectService.addEmpToProj(proj_id, emp_id, projectRole, allocPer, techStack, durationInWeeks);
        }
        else{
            throw new InactiveProjectException("Project is inactive. Set project to active to make any changes to project.");
        }
    }   

    //getting project details with employee

    @GetMapping("/project/get-project-details/{proj_id}")
    public ProjectDetailsWithEmployeesResponse  getProjectDetails(@PathVariable() Long proj_id){
        return projectService.getProjectDetails(proj_id);
    }

    //setting projects as inactive

    @PutMapping("/project/set-project-null/{projId}")
    public void setStatus(@PathVariable() Long projId){
        projectService.setStatus(projId);
    }

    
}
