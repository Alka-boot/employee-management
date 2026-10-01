# Employee Management System

This is a backend application for managing employee information. I built this project using Java, Spring Boot, Spring Data JPA, and MySQL.

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman
- Git and GitHub

## Features

- Add a new employee
- View all employees
- View an employee by ID
- Update employee details
- Delete an employee
- Search employees by name
- Search employees by department
- Pagination
- Input validation
- Exception handling
- CORS configuration

## Project Structure

The project is divided into different layers:

- **Controller** – Handles API requests
- **Service** – Contains the business logic
- **Repository** – Handles database operations
- **Entity** – Represents employee data
- **DTO** – Used for transferring employee data
- **Exception** – Handles errors
- **Config** – Contains configuration classes

## API Endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/employees` | Add an employee |
| GET | `/employees` | Get all employees |
| GET | `/employees/{id}` | Get employee by ID |
| PUT | `/employees/{id}` | Update an employee |
| DELETE | `/employees/{id}` | Delete an employee |
| GET | `/employees/search/name/{name}` | Search by name |
| GET | `/employees/search/department/{department}` | Search by department |

## Database

I used MySQL for storing employee information.

Database name:

`employee_db`

Employee details include:

- Name
- Email
- Department
- Salary

## How to Run

1. Start MySQL.
2. Create the `employee_db` database.
3. Add your MySQL username and password in `application.properties`.
4. Run `EmployeeManagementApplication` from IntelliJ.
5. The application will run on `http://localhost:8080`.
6. Use Postman to test the APIs.

**Note:** Do not upload your actual MySQL password to GitHub.

## Testing

I tested the APIs using Postman and checked the employee data in MySQL.

## What I Practiced

Through this project, I practiced building REST APIs with Spring Boot, working with MySQL and JPA, handling validation and exceptions, and using Git and GitHub.

## Author

**Alka Kumari**

GitHub: https://github.com/Alka-boot