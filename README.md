# Bank Management System - Project Documentation
================================================

Project Overview
----------------
This project is a Java-based desktop banking application that simulates an ATM and bank account management system. It allows users to register an account, log in using a card number and PIN, and perform basic banking operations such as deposit, withdrawal, balance inquiry, fast cash, mini statement, and PIN change.

Project Type
------------
- Desktop application
- GUI-based banking system
- MySQL database connected through JDBC

Main Features
-------------
1. User Registration
   - Multi-step signup form for personal details, additional information, and account details.
   - Generates a form number, card number, and PIN during account creation.

2. User Login
   - Login screen with card number and PIN authentication.
   - Validates credentials from the database.

3. ATM-like Transaction Menu
   - Deposit money
   - Withdraw cash
   - Fast cash withdrawal
   - Balance inquiry
   - Pin change
   - Mini statement
   - Exit option

4. Transaction History
   - Stores deposits and withdrawals in the database.
   - Mini statement displays recent transaction history.

5. Database-Backed Operations
   - User account details, login credentials, and transactions are stored in MySQL.

Languages and Libraries Used
----------------------------
- Java
- Swing for graphical user interface
- AWT for layout and event handling
- JDBC for database connectivity
- MySQL for database storage
- com.toedter.calendar.JDateChooser for date selection

Key Java Libraries and Components
--------------------------------
- javax.swing.*
- java.awt.*
- java.awt.event.*
- java.sql.*
- java.util.Random
- java.util.Date

Database Information
--------------------
- Database name: banksystem
- Connection used by the application: jdbc:mysql://localhost:3306/banksystem
- Database user: root
- Database password: empty string

Tables Used in the Project
--------------------------
- signup: stores the first page of personal details during registration
- signuptwo: stores additional information from the second registration page
- signupthree: stores account type, card number, PIN, and services selected
- login: stores login credentials for authentication
- bank: stores transaction history such as deposits and withdrawals

Important Notes
---------------
- The application is built as a simple educational project and uses a local MySQL database.
- The code uses direct SQL statements for CRUD operations and transaction processing.
- Some class names and labels contain spelling variations such as "Withdrawl" and "Enquriy", but the overall system works as a simple banking app.
