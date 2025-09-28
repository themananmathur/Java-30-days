# Day 10 – Mini Project: ATM Simulator

## Learnings
* Consolidated Days 1-9 concepts into a working mini project.
* Practiced OOP principles: classes, objects, constructors, encapsulation.
* Replaced manual array resizing with dynamic collections (`ArrayList`, `HashMap`).
* Separated business logic and UI by using exceptions for error handling.
* Learned to build a simple, menu-driven CLI with `Scanner`.

## Key Points
* **Account** class: id, name, pin, balance, transaction history (`ArrayList<String>`).
* **Bank** class: stores accounts in a `HashMap` for O(1) lookups; supports add, search, and transfer.
* **ATMMain**: CLI for login, balance, deposit, withdraw, transfer, history.
* Transaction history returned as an unmodifiable view for safety and efficiency.

## Hands-on Task
* Implemented `Account`, `Bank`, and `ATMMain` classes.
* Used exceptions (`IllegalArgumentException`) to handle invalid inputs cleanly.
* Tested deposit, withdraw, transfer, and transaction history with sample accounts.
* Verified robust input handling (no `Scanner` newline bug).  
