# ShopSphere

ShopSphere is a backend application for an e-commerce system built using Spring Boot.
The project focuses on implementing secure REST APIs with JWT-based authentication and role-based authorization, along with core e-commerce functionalities such as product management and cart operations.

The main goal of this project was to understand how real-world backend systems are structured using layered architecture, Spring Security, and database integration.

---

## Features

* User registration and login with JWT authentication
* Role-based access control (Admin and User)
* Product management (Admin operations)
* Cart management for users
* Global exception handling
* MySQL database integration using JPA/Hibernate
* Clean layered architecture (Controller → Service → Repository)

---

## Tech Stack

* Java
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA / Hibernate
* MySQL
* Maven

---

## Project Structure

```
controller   → API endpoints
service      → Business logic
repository   → Database operations
entity       → Database models
dto          → Request/response objects
security     → JWT and security configuration
exception    → Global exception handling
```

---

## Authentication & Authorization

Authentication is implemented using JWT tokens.
After successful login, a token is generated which must be included in the request header for accessing protected endpoints.

The system supports two roles:

* **ADMIN** — can add, update, and delete products
* **USER** — can browse products and manage cart

---

## Running the Application

1. Clone the repository

```
git clone https://github.com/MuditBh/shopSphere.git
```

2. Configure database credentials in `application.properties`

3. Run the application

```
mvn spring-boot:run
```

The server will start on `http://localhost:8080`.

---

## Learning Outcomes

Through this project, I gained hands-on experience with:

* Implementing authentication and authorization using Spring Security
* Designing REST APIs using Spring Boot
* Working with relational databases using JPA/Hibernate
* Structuring backend projects using layered architecture
* Handling exceptions in a centralized manner

---

## Author

Mudit Bhardwaj
GitHub: https://github.com/MuditBh
