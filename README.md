# 🔐 Spring Boot User Management API

Production-ready Spring Boot REST API with JWT Authentication, Spring Security, MySQL integration, and Pagination support.

---

## 🚀 Features

- ✅ User Registration
- ✅ Secure Login with JWT Authentication
- ✅ Password Encryption using BCrypt
- ✅ Stateless Authentication (No Sessions)
- ✅ Protected REST APIs
- ✅ Pagination Support
- ✅ Global Exception Handling
- ✅ Layered Architecture (Controller → Service → Repository)

---

## 🛠 Tech Stack

- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- Hibernate
- MySQL
- JWT (JSON Web Token)
- Maven

---

## 🔐 Authentication Flow

1. User registers
2. Password is encrypted using BCrypt
3. User logs in
4. JWT token is generated
5. Token must be sent in header for protected APIs
