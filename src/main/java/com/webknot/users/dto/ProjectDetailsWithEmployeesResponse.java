package com.webknot.users.dto;

import com.webknot.users.model.Employee;
import com.webknot.users.model.Project;

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
