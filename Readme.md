# Bank Management System 🏦

## Overview
The **Bank Management System** is a Java-based desktop application designed to simulate standard banking operations. It provides a user-friendly GUI for users to manage their bank accounts, perform financial transactions, and apply for various types of loans. 

## Features
* **User Authentication:** Secure login and multi-step account registration (`signupOne`, `signuptwo`, `signupthree`).
* **Account Management:** Check balance, view account details, and manage the main account profile.
* **Transactions:** Seamlessly handle cash deposits and withdrawals.
* **Mini Statements:** Generate statements of recent account activities.
* **Loan Processing System:** Dedicated modules to apply for and manage different types of loans, including:
  * Home Loan
  * Car Loan
  * Personal Loan
  * Gold Loan

## Technologies Used
* **Frontend:** Java Swing / AWT (GUI)
* **Backend:** Core Java
* **Database:** MySQL / Oracle SQL 
* **Database Connectivity:** JDBC (`mysql-connector-java-8.0.24.jar`, `ojdbc14.jar`)

## Files & Project Structure
* `login.java` - Application entry point and user login screen.
* `signup*.java` - Multi-page registration forms for new users.
* `Transaction.java`, `Deposit.java`, `Withdraw.java`, `Balance.java` - Core banking operations.
* `*Loan.java` - Classes handling specific loan functionalities.
* `BANKING SQL.sql` - Database schema and table structures.
* `connect1.java` - JDBC database connection configuration.

## How to Run the Project
1. **Set up the Database:**
   * Open your MySQL or Oracle database.
   * Run the queries provided in the `BANKING SQL.sql` file to create the necessary tables.
2. **Configure the Project:**
   * Open the project in your preferred IDE (like Eclipse, IntelliJ IDEA, or NetBeans).
   * Update the database credentials (username and password) in the `connect1.java` file.
   * Add the required JDBC Driver (`mysql-connector-java-8.0.24.jar` or `ojdbc14.jar`) to your project's Build Path/Libraries.
3. **Run the Application:**
   * Compile and run the `login.java` file to start the application.

## Future Enhancements
* Add admin panel to manage users and approve/reject loan applications.
* Implement email/SMS notifications for transactions.
* Enhance UI/UX with modern JavaFX components.
