<h1>REST API for Project Management and Benching</h1>
This is a REST API for project management and benching software. It is made using Spring Boot and has the following features:
1. Create projects
2. Project has the following fields:  
 ■ Project type- MSP or SA
 ■ Source Client
 ■ EndClient
 ■ Project description
 ■ Account manager- should relate to an employee
 ■ Project manager- should relate to an employee
 ■ Project status- active / inactive
3. Admin can add as many employees into one or more project
4. Admincancheck the details of a project and it returns the following information
 ○ Complete Project details
 ○ All employees allocated to the project with their allocation percent and tech
 stack
5. Admin can add or remove employees from a project at any point of time
6. Admin can set a project to active or inactive at any point of time
7. If a project is set to inactive- all allocations of the employees in that project will be
 nullified, and the admin cannot add employees to the project , unless he sets it to
 active again.
8. Admin will be able to search for an employee or get a list of all employees
 paginated with his/her allocation and the projects being worked on
9. Admin will be able to see a bench list- which ideally means any employee whose
 allocation is less than 90% should appear in the bench list along with their tech stack
