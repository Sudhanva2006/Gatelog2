# GateLog – Gate Entry & Exit Management System

GateLog is a Java-based desktop application developed to digitally manage student exit approvals and visitor entry records in a college campus.  
The system replaces manual register-based processes with a secure, role-based, and database-backed solution using Java, Swing, JDBC, and MySQL.

 Project Overview

In many colleges, gate entry and exit processes are handled manually using registers and permission letters.  
This approach is time-consuming, error-prone, and difficult to maintain securely.

GateLog provides:
Role-based access for Adminand Faculty
Digital approval of student exit requests
Secure logging of visitor entry details
Permanent data storage using MySQL
Easy-to-use graphical user interface (GUI)** built with Java Swing

Features

Authentication
Login system with role selection (Admin / Faculty)
Separate dashboards based on user role
Logout option with confirmation dialog

Faculty Module
Add student exit requests
Enter student details (USN, name, department, year, reason)
Store exit approval details in the database

 Admin Module
Add visitor entry details
 View complete visitor log in tabular format
 Verify student exit details using USN
 Secure access to administrative operations

 Database Integration
Uses **MySQL** for permanent data storage
JDBC used for database connectivity
DAO pattern implemented for clean separation of logic

 Technologies Used

Java, Core application logic
Java Swing, Graphical User Interface
JDBC, Database connectivity
MySQL, Backend database
Git & GitHub, Version control
Visual Studio Code, Development environment

Project Structure
GateLog2/
│
├── gatelog/
│ ├── Admin.java
│ ├── Faculty.java
│ ├── MainApp.java
│ ├── DBConnection.java
│ ├── StudentExit.java
│ ├── StudentExitDAO.java
│ ├── Visitor.java
│ ├── VisitorDAO.java
│ │
│ ├── ui/
│ │ ├── LoginUI.java
│ │ ├── AdminUI.java
│ │ └── FacultyUI.java
│ │
│ └── lib/
│ └── mysql-connector-j-9.5.0.jar
│
└── .gitignore


How to Run the Project

Prerequisites
 Java JDK 8 or above
 MySQL Server
 MySQL Connector/J (already included in `/lib`)
 Git (optional)

Database Setup
 Create a MySQL database: sql
 CREATE DATABASE gatelog;
 Create required tables (student_exit, visitor_log) as per project scheme.
 Update database credentials in: DBConnection.java

Compile the Project
 javac -cp ".;gatelog/lib/mysql-connector-j-9.5.0.jar" gatelog/*.java gatelog/ui/*.java
Run the Application
 java -cp ".;gatelog/lib/mysql-connector-j-9.5.0.jar" gatelog.MainApp






