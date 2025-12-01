# SmartBank – Console-Based Banking System (Java)

## 1. Project Title
**SmartBank: A Java Console-Based Banking Management System**

## 2. Description / Overview
SmartBank is a console-based banking system developed using Java and Object-Oriented Programming (OOP) principles. It allows users to create different types of bank accounts, perform transactions such as deposit and withdrawal, and view transaction history. The system simulates real-world banking operations and manages multiple account holders in a simple, organized console environment.

Main features include:
- Multiple account types (Savings, Student, Business)
-Secure transaction handling
-Transaction history tracking
-User input validation through exception handling
-Fully console-based interface

## 3. OOP Concepts Applied

### a. Encapsulation
Encapsulation is implemented by declaring class attributes as private and exposing them through getter/setter methods.
Example: accountNumber, accountHolder, and balance are private and accessed through public getters.

### b. Inheritance
The base abstract class Account is extended by:
-SavingsAccount
-StudentAccount
-BusinessAccount
Each subclass inherits shared properties and implements its own withdrawal rules.

### c. Polymorphism
Polymorphism is demonstrated through method overriding.
Each subclass provides its own version of the withdraw() method.
The SmartBank system calls acc.withdraw() using the Account reference, allowing dynamic method execution depending on the account type.

### d. Abstraction
Abstraction is applied through the Account abstract class, which contains the abstract method withdraw().
This forces subclasses to implement their own rules.


## 4. Program Structure

### Main Classes:
Main Classes

Account (Abstract Class) – Contains common fields and behaviors.

SavingsAccount – Standard rules for withdrawals.

StudentAccount – Allows withdrawals up to ₱2000 only.

BusinessAccount – Charges an additional ₱50 service fee per withdrawal.

SmartBank – Main system containing menus, options, and application flow.

Class Diagram (Improved formatting)
               Account (Abstract)
                     |
    -----------------------------------------
    |                  |                    |
SavingsAccount   StudentAccount     BusinessAccount
                     |
                SmartBank (Main System)

## 5. How to Run the Program

1.Save the files as:
  -SmartBank.java
  -Account.java
  -SavingsAccount.java
  -StudentAccount.java
  -BusinessAccount.java

2.Open Command Prompt or Terminal.

3.Navigate to the folder where the files are saved.

4.Compile all Java files:
  javac *.java
5.Run the program:
  java SmartBank
6.Make sure Java (JDK) is already installed on your system.


## 6. Sample Output

===============================
        SMARTBANK SYSTEM
===============================
1. Create Account
2. Login
3. Exit
Enter choice: 1
Enter Full Name: Juan Dela Cruz
Enter Account Number: 12345
Enter Initial Deposit: 5000

Select Account Type:
1. Savings Account
2. Student Account
3. Business Account
Choice: 2
Account Created Successfully!

===============================
        SMARTBANK SYSTEM
===============================
1. Create Account
2. Login
3. Exit
Enter choice: 2
Enter Account Number: 12345

===== ACCOUNT MENU =====
Account Holder: Juan Dela Cruz
Account Number: 12345
Balance: 5000.0

1. Deposit
2. Withdraw
3. Check Balance
4. View Transaction History
5. Logout
Choice: 2
Enter withdraw amount: 1000
Withdrawal Successful! (Student Rules)

===== ACCOUNT MENU =====
Account Holder: Juan Dela Cruz
Account Number: 12345
Balance: 4000.0

1. Deposit
2. Withdraw
3. Check Balance
4. View Transaction History
5. Logout
Choice:


## 7. Author and Acknowledgement

**Authors:**  
Lenard Roy Lacsamana
Angel Joble
John Russel Labios
Janrenz Oliver Hidalgo
Information Technology Student -2102

**Acknowledgement:**  
I would like to express my gratitude to our Java Programming instructor for guidance and for providing the project requirements, and to my classmates for their support and feedback during development.


## 8. Other Sections

### a. Future Enhancements
- Implement password-protected accounts.
- Save account data using file handling.
- Add interest calculation for savings accounts.
- Improve UI using JavaFX.

### b. References
- Oracle Java Documentation
- Java Programming Textbook and Lecture Materials
- OOP Concepts References (GeeksforGeeks, W3Schools)


