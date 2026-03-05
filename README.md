# 🔐 Spring Boot User Management API

A production-style **Spring Boot REST API** implementing **JWT Authentication, Spring Security, MySQL integration, and Pagination**.
This project demonstrates how to build a secure backend system with proper authentication and layered architecture.

---

# 🚀 Features

* ✅ User Registration API
* ✅ Secure Login with **JWT Authentication**
* ✅ Password Encryption using **BCrypt**
* ✅ **Role-based Authentication (ADMIN / USER)**
* ✅ Stateless Authentication (No Session Storage)
* ✅ Protected REST APIs using Spring Security
* ✅ Pagination support for user listing
* ✅ Global Exception Handling
* ✅ Layered Architecture (Controller → Service → Repository)

---

# 🛠 Tech Stack

| Technology          | Purpose                   |
| ------------------- | ------------------------- |
| **Java 17**         | Core Programming Language |
| **Spring Boot 3**   | Backend Framework         |
| **Spring Security** | API Security              |
| **Spring Data JPA** | Database Access           |
| **Hibernate**       | ORM                       |
| **MySQL**           | Database                  |
| **JWT**             | Authentication            |
| **Maven**           | Dependency Management     |
| **Postman**         | API Testing               |

---

# 📂 Project Structure

src/main/java/com/aftab/demo

├── controller
├── service
├── repository
├── entity
├── security
├── exception
└── config

This layered structure separates business logic, database access, and API controllers.

---

# 🔐 Authentication Flow

1️⃣ User registers via API
2️⃣ Password is encrypted using **BCrypt**
3️⃣ User logs in with email & password
4️⃣ Server generates **JWT Token**
5️⃣ Client sends JWT token in **Authorization header**

Example:

Authorization: Bearer YOUR_JWT_TOKEN

---

# 📌 API Endpoints

### 🔑 Authentication

| Method | Endpoint            | Description             |
| ------ | ------------------- | ----------------------- |
| POST   | /api/users/register | Register new user       |
| POST   | /api/users/login    | Login and get JWT token |

---

### 👤 User APIs

| Method | Endpoint       | Description                |
| ------ | -------------- | -------------------------- |
| GET    | /api/users/all | Get all users (Pagination) |

Example:

/api/users/all?page=0&size=5

---

# ⚙️ Setup Instructions

### 1️⃣ Clone Repository

git clone https://github.com/aftabmujawar/springboot-user-management-api
.git

---

### 2️⃣ Configure Database

Update **application.properties**

spring.datasource.url=jdbc:mysql://localhost:3306/demo_db
spring.datasource.username=root
spring.datasource.password=your_password

---

### 3️⃣ Run Application

Using Maven:

mvn spring-boot:run

Or run **DemoApplication.java** from your IDE.

---

# 🧪 Testing APIs

You can test APIs using:

* **Postman**
* **Swagger UI** (if enabled)

---

# 🔒 Example Login Request

POST /api/users/login

Request Body:

{
"email": "[admin@gmail.com](mailto:admin@gmail.com)",
"password": "12345"
}

Response:

{
"token": "your_jwt_token"
}

---

# 📊 Example Protected Request

GET /api/users/all

Header:

Authorization: Bearer YOUR_JWT_TOKEN

---

# 🎯 Future Improvements

* Add **Swagger API Documentation**
* Add **Role Based Authorization**
* Add **Refresh Token System**
* Add **Docker Deployment**

---

# 👨‍💻 Author

**Aftab Irshad Mujawar**

📧 [aftabmujawar504@gmail.com](mailto:aftabmujawar504@gmail.com)
🔗 LinkedIn:
https://www.linkedin.com/in/aftab-mujawar-02ba1232b
