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

Client (Browser / Postman) -> Controller -> DTO Layer -> Service -> Repository (JPA) -> MySQL Database

Web Layer: Thymeleaf (Server-side rendering)
API Layer: REST Controllers (JSON responses)



## ☁️ Deployment Architecture (AWS EC2 + Nginx)

This application is packaged as a JAR file using Maven and deployed to an AWS EC2 instance.

### 🔨 Build

mvn clean package

This generates a .jar file inside the `target/` directory.

### 🚀 Deployment Steps

1. Upload the JAR file to AWS EC2 via SFTP.
2. Connect to EC2 using SSH.
3. Run the application:

java -jar app.jar

The application runs on port 8080 inside EC2.

### 🌍 Reverse Proxy (Nginx)

Nginx is configured on EC2 as a reverse proxy:

Public IP (Port 80) → Nginx → Spring Boot (Port 8080)

Users can access the application using:

http://<EC2_PUBLIC_IP>


## 🧪 How to Run

1️⃣ Configure MySQL in `application.properties`

2️⃣ Build project:
mvn clean install

3️⃣ Run:
mvn spring-boot:run

Application runs at: http://localhost:8080

## 📦 Database

Relational structure includes:

-Member
-Book
-Borrow (Join entity)

Uses JOIN queries and JPA relationships.

🧠 Learning Outcomes

Spring Boot layered architecture
RESTful API design
Thymeleaf server-side rendering
JPA entity relationships
SQL JOIN operations
Maven build lifecycle
