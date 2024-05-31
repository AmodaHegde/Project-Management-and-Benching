package com.webknot.users.controller;

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

import com.webknot.users.controller.errors.InactiveProjectException;
import com.webknot.users.dto.ProjectDetailsWithEmployeesResponse;
import com.webknot.users.model.EnumProjStatus;
import com.webknot.users.model.Project;
import com.webknot.users.repository.ProjectRepo;
import com.webknot.users.service.ProjectService;

@RestController
public class ProjectController {

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

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectRepo projectRepo;

    @PostMapping("/project/create")
    public void createProject(@RequestBody ProjectRequest request){
        projectService.createProject(
            request.getProject(),
            request.getAccountManagerId(),
            request.getProjectManagerId()
    );
    }

    @GetMapping("/project/get-project/{projectId}")
    public Project getProject(@PathVariable("projectId") Long projectId){
        return projectService.getProject(projectId);
    }

    @GetMapping("/project/get-all-projects")
    public List<ProjectDetailsWithEmployeesResponse> getAllProjects(){
        return projectService.getAllProjectDetails();
    }

    @DeleteMapping("/project/{proj_id}/remove-employee/{emp_id}")
    public void removeEmpFromProj(@PathVariable() Long proj_id, @PathVariable() Long emp_id) {
        projectService.removeEmpFromProj(proj_id, emp_id);
    }

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

    @GetMapping("/project/get-project-details/{proj_id}")
    public ProjectDetailsWithEmployeesResponse  getProjectDetails(@PathVariable() Long proj_id){
        return projectService.getProjectDetails(proj_id);
    }

    @PutMapping("/project/set-project-null/{projId}")
    public void setStatus(@PathVariable() Long projId){
        projectService.setStatus(projId);
    }

    
}
