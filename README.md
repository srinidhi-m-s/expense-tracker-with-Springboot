Expense Tracker System

Project Description:
A simple CRUD-based Expense Tracker backend built using Spring Boot and PostgreSQL.
Users can perform Create, Read, Update, and Delete operations on expenses via RESTful APIs.

Technologies Used:
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- H2 (for development/testing)

Features:
- Create, update, delete, and fetch expense records
- Data persisted in PostgreSQL database
- Easy-to-use RESTful API endpoints
- Configured H2 in-memory database for fast development/testing

How to Run:
1. Configure PostgreSQL database in application.properties
2. Run the application:
   mvn spring-boot:run
3. Access APIs via Postman or curl at:
   http://localhost:8080/api/expenses
4. Optional: Use H2 console at http://localhost:8080/h2-console

Use Case:
Ideal for learning Spring Boot REST APIs, database integration, and CRUD operations.
