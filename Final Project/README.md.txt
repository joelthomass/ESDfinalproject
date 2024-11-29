# **Bill Payment History Management System**

## **Overview**
The Bill Payment History Management System is a web-based application that enables users to view their bill and payment history, download payment history as a PDF, and utilize a dark-themed, user-friendly interface. The project is built using **Spring Boot** for the backend and **React.js** for the frontend, with **MySQL** as the database.

---

## **Prerequisites**
Before running the project, ensure the following software is installed on your system:
1. **MySQL** (Version 8.4.3 or higher)
2. **Java Development Kit (JDK)** (Version 17 or higher)
3. **IntelliJ IDEA** (or any other Java IDE)
4. **Node.js** (Version 16.x or higher)
5. **Visual Studio Code** (or any other code editor for React)

---

## **Steps to Execute**

### **1. Run the SQL Script**
To set up the database:
- **Option 1: Using Command Prompt**
  1. Open Command Prompt (`Win + R`, type `cmd`, and hit Enter).
  2. Navigate to the folder containing the SQL script:
     ```bash
     cd "C:\Users\...\...\Final Project\billhistory\src\main\resourcest"
     ```
  3. Run the script:
     ```bash
     mysql -u root -p < esdproject.sql
     ```
  4. Enter the MySQL root password when prompted.

- **Option 2: Using PowerShell**
  1. Open PowerShell (`Win + X`, select PowerShell).
  2. Navigate to the folder containing the SQL script:
     ```powershell
     cd "C:\Users\<YourUsername>\path_to_sql_script"
     ```
  3. Run the script:
     ```powershell
     Get-Content esdproject.sql | mysql -u root -p
     ```
  4. Enter the MySQL root password when prompted.



### **2. Open the Backend Project**
1. Navigate to the backend project directory (`billhistory`) in your file explorer.
2. Open the project in **IntelliJ IDEA**:
   - File > Open > Navigate to the `billhistory` folder > Select `Open`.
3. Wait for IntelliJ to import dependencies (Maven/Gradle will handle this automatically).
4. Start the Spring Boot server:
   - Click the green **Run** button or press `Shift + F10`.



### **3. Open the Frontend Project**
1. Navigate to the frontend project directory (`my-react-app`) in your file explorer.
2. Open the project in **Visual Studio Code**:
   - File > Open Folder > Navigate to `my-react-app` > Select `Open`.
3. Install dependencies (if not already installed):
   ```bash
   npm install
Start the React app:
bash
Copy code
npm start
The application will open in your default browser at http://localhost:3000.


Project Features
User Authentication:
Login functionality with JWT-based authentication.
Bill and Payment Management:
View bill and payment history.
Display total amount paid.
PDF Generation:
Download payment history as a PDF.
Dark Mode:
User-friendly dark-themed interface for better readability.


Tech Stack
Frontend: React.js
Backend: Spring Boot
Database: MySQL
PDF Library: iText7


Notes
Ensure both the backend and frontend servers are running simultaneously.
For any issues, check the console logs in IntelliJ (backend) or the browser developer tools (frontend).
Verify that the database connection details in the application.properties file match your local MySQL setup.