package com.springboot.users.dto;

import com.springboot.users.model.Employee;
import com.springboot.users.model.Project;

public class ProjectDetailsWithEmployeesResponse {
    private Project project;
    private Employee accountManager;
    private Employee projectManager;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(Employee accountManager) {
        this.accountManager = accountManager;
    }

    public Employee getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Employee projectManager) {
        this.projectManager = projectManager;
    }
}
