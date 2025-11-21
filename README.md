# SmartBank – Console-Based Banking System (Java)

## 1. Project Title
**SmartBank: A Java Console-Based Banking Management System**

## 2. Description / Overview
SmartBank is a console-based banking system developed using Java and Object-Oriented Programming (OOP) principles. It allows users to create different types of bank accounts, perform transactions such as deposit and withdrawal, and view transaction history. The system simulates real-world banking operations and solves the problem of managing multiple account holders in a simple, organized, and interactive way through the console.

Main features include:
- Multiple account types (Savings, Student, Business)
- Secure transaction handling
- Transaction history tracking
- User input validation using exception handling
- Console-based interaction

## 3. OOP Concepts Applied

### a. Encapsulation
Encapsulation is implemented by making class attributes `private` and providing controlled access through `getters` and `setters`.  
Example: `accountNumber`, `accountHolder`, and `balance` are private and accessed using public getter methods.

### b. Inheritance
Inheritance is used by creating a base class `Account` and extending it into:
- `SavingsAccount`
- `StudentAccount`
- `BusinessAccount`

Each subclass inherits common properties and behaviors while implementing its own withdrawal rules.

### c. Polymorphism
Polymorphism is achieved by overriding the `withdraw()` method in each subclass.  
The `SmartBank` system uses a superclass reference `Account` to call the overridden method dynamically based on the account type.

### d. Abstraction
Abstraction is applied using the abstract class `Account` which contains an abstract method `withdraw()` that forces subclasses to implement their own version.


## 4. Program Structure

### Main Classes:
- **Account (Abstract Class)**  
  Base class containing common attributes and methods for all account types.

- **SavingsAccount (Subclass)**  
  Implements basic withdrawal rules.

- **StudentAccount (Subclass)**  
  Adds withdrawal limit for student users.

- **BusinessAccount (Subclass)**  
  Includes service fee per withdrawal.

- **SmartBank (Main Class)**  
  Handles user interaction, menus, and system operations.

### Simple Class Relationship:

          Account (Abstract)
                |
    --------------------------------
    |               |               |

SavingsAccount StudentAccount BusinessAccount
|
SmartBank (Main System)

## 5. How to Run the Program

Follow these steps using the command line:

1. Save your code as `SmartBank.java`
2. Open Command Prompt or Terminal.
3. Navigate to the folder where your file is saved.
4. Compile the program:
5. Make sure you have Java installed on your system.


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

