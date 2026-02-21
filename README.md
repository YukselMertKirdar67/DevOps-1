# 📚 Library Management System – Spring Boot 4

## 📌 Project Overview

This project is a full-stack web application built using **Java 25, Spring Boot 4, and Maven 4**.

It simulates a **Library Management System** where users can manage members, books, and borrowing operations.

Deployed on AWS EC2 with Nginx reverse proxy configuration.


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

The application is built using Maven and packaged as a runnable JAR file.
It is deployed to an AWS EC2 Linux instance and served publicly using Nginx as a reverse proxy.

### 🔨 Build

mvn clean package

This generates the executable JAR file in the `target/` directory.

### 🚀 Deployment Steps

1. Transfer the JAR file to the EC2 instance via SFTP.
2. Connect to EC2 using SSH.
3. Run the application:

java -jar app.jar

The Spring Boot application runs internally on port 8080.

### 🌍 Reverse Proxy Configuration

Nginx forwards public HTTP traffic to the Spring Boot application:

Internet → EC2 Public IP (Port 80)
Nginx → localhost:8080 (Spring Boot)

Users access the system via:

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

## 🧠 Learning Outcomes

- Spring Boot layered architecture
- RESTful API design principles
- Thymeleaf server-side rendering
- JPA entity relationships and mappings
- SQL JOIN operations
- Maven build lifecycle management
- AWS EC2 deployment
- Nginx reverse proxy configuration
