# Library Management System – Mini Project (Java-30-Days)

## Overview
A simple console-based Library Management System built in Java.  
It covers core OOP concepts, custom exceptions, and basic library operations without persistence.

## How to Run
1. Save all `.java` files in a folder (e.g., `LMS/`).
2. Compile:  
   javac LMS/*.java
3. Run:  
   java LMS.Main

## What’s Implemented
- Core classes: `LibraryItem`, `Book`, `Member`, and `DVD` (for inheritance).
- Exception handling with `BookNotFoundException`, `MemberNotFoundException`, and `BookAlreadyBorrowedException`.
- Library features: add books/members, borrow and return, list all and available books.
- A simple menu in `Main` with proper try-catch and finally.

### Members
- M001 - Manan
- M002 - Shaikh
- M003 - Gautham
- M004 - Kushagra
- M005 - Randstad

### All Books
- Book | Title: Design Patterns | Author: Erich Gamma | ISBN: 2025-8 
- Book | Title: Refactoring | Author: Martin Fowler | ISBN: 2025-10 
- Book | Title: The Pragmatic Programmer | Author: Andrew Hunt | ISBN: 2025-9 
- Book | Title: Java Concurrency in Practice | Author: Brian Goetz | ISBN: 2025-6 
- Book | Title: Introduction to Algorithms | Author: Thomas H. Cormen | ISBN: 2025-7 
- Book | Title: Java: The Complete Reference | Author: Herbert Schildt | ISBN: 2025-4 
- Book | Title: Thinking in Java | Author: Bruce Eckel | ISBN: 2025-5 
- Book | Title: Head First Java | Author: Kathy Sierra | ISBN: 2025-2 
- Book | Title: Clean Code | Author: Robert C. Martin | ISBN: 2025-3 
- Book | Title: Effective Java | Author: Joshua Bloch | ISBN: 2025-1


## Sample Run
=== Library Menu ===
1) Add Book
2) Add Member
3) Borrow Book
4) Return Book
5) List All Books
6) List Available Books
7) Exit

Choice: 1
ISBN: 2025-11
Title: Patterns of Enterprise Application Architecture
Author: Martin Fowler
Book added.

Choice: 2
Member ID: M006
Name: Walmart
Member added.

Choice: 5
All books:
Book | Title: Design Patterns | Author: Erich Gamma | ISBN: 2025-8
Book | Title: Refactoring | Author: Martin Fowler | ISBN: 2025-10
Book | Title: The Pragmatic Programmer | Author: Andrew Hunt | ISBN: 2025-9
Book | Title: Java Concurrency in Practice | Author: Brian Goetz | ISBN: 2025-6
Book | Title: Introduction to Algorithms | Author: Thomas H. Cormen | ISBN: 2025-7
Book | Title: Java: The Complete Reference | Author: Herbert Schildt | ISBN: 2025-4
Book | Title: Thinking in Java | Author: Bruce Eckel | ISBN: 2025-5
Book | Title: Head First Java | Author: Kathy Sierra | ISBN: 2025-2
Book | Title: Clean Code | Author: Robert C. Martin | ISBN: 2025-3
Book | Title: Effective Java | Author: Joshua Bloch | ISBN: 2025-1

Choice: 3
Member ID: M001
Book ISBN: 2025-1
Borrow successful.

Choice: 6
Available books:
Book | Title: Design Patterns | Author: Erich Gamma | ISBN: 2025-8
Book | Title: Refactoring | Author: Martin Fowler | ISBN: 2025-10
Book | Title: The Pragmatic Programmer | Author: Andrew Hunt | ISBN: 2025-9
Book | Title: Java Concurrency in Practice | Author: Brian Goetz | ISBN: 2025-6
Book | Title: Introduction to Algorithms | Author: Thomas H. Cormen | ISBN: 2025-7
Book | Title: Java: The Complete Reference | Author: Herbert Schildt | ISBN: 2025-4
Book | Title: Thinking in Java | Author: Bruce Eckel | ISBN: 2025-5
Book | Title: Head First Java | Author: Kathy Sierra | ISBN: 2025-2
Book | Title: Clean Code | Author: Robert C. Martin | ISBN: 2025-3

Choice: 4
Book ISBN: 2025-1
Return processed.

Choice: 6
Available books:
Book | Title: Design Patterns | Author: Erich Gamma | ISBN: 2025-8
Book | Title: Refactoring | Author: Martin Fowler | ISBN: 2025-10
Book | Title: The Pragmatic Programmer | Author: Andrew Hunt | ISBN: 2025-9
Book | Title: Java Concurrency in Practice | Author: Brian Goetz | ISBN: 2025-6
Book | Title: Introduction to Algorithms | Author: Thomas H. Cormen | ISBN: 2025-7
Book | Title: Java: The Complete Reference | Author: Herbert Schildt | ISBN: 2025-4
Book | Title: Thinking in Java | Author: Bruce Eckel | ISBN: 2025-5
Book | Title: Head First Java | Author: Kathy Sierra | ISBN: 2025-2
Book | Title: Clean Code | Author: Robert C. Martin | ISBN: 2025-3
Book | Title: Effective Java | Author: Joshua Bloch | ISBN: 2025-1

Choice: 7
Scanner closed. Exiting.



**Manan Mathur**  
manan.mathur@randstaddigital.com
