<h1>REST API for Project Management and Benching</h1>
This is a REST API for project management and benching software. It is made using Spring Boot and has the following features:<br>
1. Create projects<br>
2. Project has the following fields: <br> 
 ■ Project type- MSP or SA<br>
 ■ Source Client<br>
 ■ EndClient<br>
 ■ Project description<br>
 ■ Account manager- should relate to an employee<br>
 ■ Project manager- should relate to an employee<br>
 ■ Project status- active / inactive<br>
3. Admin can add as many employees into one or more project<br>
4. Admincancheck the details of a project and it returns the following information<br>
 ○ Complete Project details<br>
 ○ All employees allocated to the project with their allocation percent and tech<br>
 stack<br>
5. Admin can add or remove employees from a project at any point of time<br>
6. Admin can set a project to active or inactive at any point of time<br>
7. If a project is set to inactive- all allocations of the employees in that project will be<br>
 nullified, and the admin cannot add employees to the project , unless he sets it to<br>
 active again.<br>
8. Admin will be able to search for an employee or get a list of all employees<br>
 paginated with his/her allocation and the projects being worked on<br>
9. Admin will be able to see a bench list- which ideally means any employee whose<br>
 allocation is less than 90% should appear in the bench list along with their tech stack<br>
