# 🏦 Bank Management System - Project Summary

---

## 📌 Project Information

| Field | Details |
|------|--------|
| **Project Name** | Bank Management System |
| **Project Type** | Java Swing Desktop Application (ATM Simulation System) |

---

## 🎯 Project Purpose

This project is designed to simulate a basic **banking and ATM system**.

It allows users to:
- Create a bank account
- Login securely using card number and PIN
- Perform banking operations like deposit, withdraw, fast cash, balance inquiry
- View mini statements
- Manage account settings (PIN change, account close)

---

## 💻 Technologies Used

### 🧠 Programming Languages
- Java
- SQL (MySQL)

---

### 🧩 Libraries & Frameworks

- `Swing (javax.swing.*)` → GUI development  
- `AWT (java.awt.*)` → Layout, design, fonts, colors  
- `JDBC (java.sql.*)` → Database connectivity  
- `MySQL` → Data storage and management  
- `JDateChooser (com.toedter.calendar.JDateChooser)` → Date selection UI  

---

## ⚙️ Main Features

### 👤 1. User Registration
- Multi-step signup process
- Collects:
  - Personal details
  - Family information
  - Address
  - Account preferences
- Generates:
  - Form number
  - Card number
  - PIN

---

### 🔐 2. User Login
- Secure login using:
  - Card number
  - PIN
- Authentication using database validation

---

### 💰 3. Banking Transactions
- Deposit money
- Withdraw money
- Fast cash (predefined amounts)
- Balance inquiry
- PIN change system

---

### 🧾 4. Mini Statement
- Shows transaction history
- Displays:
  - Date
  - Time
  - Transaction type
  - Amount
- Includes real-time balance calculation

---

### 🏦 5. Account Management
- Account closure feature
- Confirmation-based deletion system
- Removes all related data from database

---

### 🗄️ 6. Database-Driven System
- All operations connected to MySQL database
- Uses JDBC for communication
- Real-time data storage and retrieval

---

## 🧱 Key Java Classes

| Class Name | Purpose |
|------------|--------|
| `Login.java` | Login screen |
| `Signup.java` | First registration page |
| `Singup2.java` | Additional user details |
| `Signup3.java` | Account creation & PIN generation |
| `Deposit.java` | Deposit money screen |
| `Withdrawl.java` | Withdraw money screen |
| `FastCash.java` | Quick withdrawal options |
| `BalanceEnquriy.java` | Balance check screen |
| `Pin.java` | PIN change system |
| `CloseAccount.java` | Account deletion system |
| `mini.java` | Mini statement (transaction history) |
| `main_Class.java` | Main ATM dashboard |
| `Conn.java` | Database connection handler |

---

## 🗃️ Database Configuration

| Field | Value |
|------|------|
| **Database Name** | banksystem |
| **JDBC URL** | jdbc:mysql://localhost:3306/banksystem |
| **Username** | root |
| **Password** | *(empty string)* |

---

## 📊 Database Tables

| Table Name | Description |
|------------|-------------|
| `signup` | Stores personal details (Step 1 registration) |
| `signuptwo` | Stores additional details (Step 2 registration) |
| `signupthree` | Stores account type, card number, PIN |
| `login` | Stores login credentials (card & PIN) |
| `bank` | Stores all transactions (deposit/withdraw) |

---

## 📌 Notes

- This is a **beginner-friendly Java desktop banking project**
- Built for learning:
  - Java Swing GUI
  - JDBC database connection
  - Real-world banking logic
- Not intended for real banking use
- Uses direct SQL queries for simplicity

---

## 🚀 Project Highlights

✔ ATM-like interface  
✔ Secure login system  
✔ Full database integration  
✔ Real banking workflow simulation  
✔ Modular Java architecture  
✔ Easy to understand and extend  

---

## 👨‍💻 Developer

**MD Jishan Prodhan**  
Java Developer | Web Developer | Software Enthusiast  

---

## ⭐ Future Improvements

- 📄 PDF mini statement export  
- 🖨️ Real ATM receipt printing  
- 📱 Mobile banking version  
- 📊 Graph-based balance analysis  
- 🔔 Transaction notifications system  

---

## video link :
 https://drive.google.com/file/d/1fNzX_oQgmFjhoK6AJMVUQWzLqS2kgqNk/view?usp=drive_link