# 📚 Smart Library Management System

A **Spring Boot–based backend application** designed to manage library operations such as book management, member management, and book borrowing/returning with proper business rules and data consistency.

This project follows **clean architecture principles**, uses **DTO-based APIs**, and is built to be **scalable and production-ready**.

---

## 🚀 Features

### 📘 Book Management
- Add single book
- Add multiple books (bulk upload)
- Update book details
- Delete book
- Get book by ID
- Get books by author
- Pagination and sorting support

---

### 👤 Member Management
- Register member
- Update member details
- Activate / Deactivate member
- Get member details

---

### 🔄 Borrow & Return Management
- Borrow a book (with availability check)
- Return a book
- Calculate fine for late returns
- Get all borrow records of a member
- Get overdue books

---

## 🧠 Business Rules Implemented

- A book can be borrowed only if **available copies > 0**
- Only **active members** can borrow books
- Book availability is updated during borrow/return
- Late returns automatically calculate fines
- Borrow & return operations are **transactional**
- DTOs are used to prevent entity exposure

---

## 🏗️ Architecture

Controller Layer
↓
Service Layer (Business Logic)
↓
DAO Layer
↓
Repository (Spring Data JPA)
↓
Database (PostgreSQL)


### Design Principles Used
- DTO pattern
- Mapper utility classes
- Layered architecture
- Transaction management
- Exception handling
- Pagination & sorting

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Postman (API testing)

---

## 📦 Dependencies

- spring-boot-starter-web
- spring-boot-starter-data-jpa
- spring-boot-devtools
- postgresql-driver

---

## 🗃️ Database Design

### Tables
- `books`
- `members`
- `borrow_records`

### Relationships
- One Book → Many BorrowRecords
- One Member → Many BorrowRecords

---

## 🔐 Transaction Management

Critical operations such as **borrowing and returning books** are handled using:

```java
@Transactional
This ensures:
1) Atomic operations
2) No partial data updates
3) Data consistency

Future Enhancements
1) Borrow limit per membership type
2) Fine payment tracking
3) Role-based access (Admin / User)
4) Optimistic locking for concurrency
5) Swagger API documentation
6) Authentication & Authorization (JWT)

Author-:
Rishav Raj Singh
Java Backend Developer (Fresher)

Final Note
This project is built as a learning and portfolio project, focusing on real-world backend practices, not just basic CRUD operations.
