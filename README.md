# 📚 Library Management System – Spring Boot 4

## 📌 Project Overview

This project is a full-stack web application built using **Java 25, Spring Boot 4, and Maven 4**.

It simulates a **Library Management System** where users can manage members, books, and borrowing operations.

The system supports both:
- Web-based interface (Thymeleaf)
- REST API endpoints (for Postman testing)

## 🛠️ Technology Stack

- Java 25
- Spring Boot 4
- Maven 4
- MySQL
- Spring Data JPA
- Thymeleaf
- REST Controllers
- Postman (API testing)

## 🚀 Features

### 👤 Member Management
- Create, Read, Update, Delete members

### 📖 Book Management
- Create, Read, Update, Delete books

### 🔄 Borrow System
- Members can borrow books
- Database JOIN operations used to fetch related data
- Relational mapping via JPA

### 🌐 Web Interface
- Server-side rendered pages using Thymeleaf

### 🔌 REST API
- Separate REST controllers for Postman testing


## 🏗️ Architecture

Client (Browser / Postman)
        ↓
Controller
        ↓
DTO Layer
        ↓
Service
        ↓
Repository (JPA)
        ↓
MySQL Database

Web Layer: Thymeleaf (Server-side rendering)
API Layer: REST Controllers (JSON responses)


## 🧪 How to Run

1️⃣ Configure MySQL in `application.properties`

2️⃣ Build project:

```bash
mvn clean install


3️⃣ Run:

```bash
mvn spring-boot:run

Application runs at: http://localhost:8080

## 📦 Database

Relational structure includes:

Member

Book

Borrow (Join entity)

Uses JOIN queries and JPA relationships.
