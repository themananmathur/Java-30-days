# Day 9 – Abstraction & Interfaces

## Learnings
- **Abstraction** hides implementation details and shows only essential features.
- Achieved in Java using:
    - **Abstract Classes** → can contain both abstract and concrete methods.
    - **Interfaces** → define contracts (methods to be implemented by classes).

## Key Points
- **Abstract Class**:
    - Declared with `abstract` keyword.
    - Can have both abstract methods (without body) and concrete methods (with body).
- **Interface**:
    - Defines methods without implementation (implicitly `public` and `abstract`).
    - From Java 8 onwards, can also have `default` and `static` methods.

## Hands-on Task
- Created a `PaymentMethod` interface.
- Implemented two classes:
    - `creditcard` → prints payment via Credit Card.
    - `UPIPay` → prints payment via UPI.
- Used interface references in `PaymentDemo` to process payments.
