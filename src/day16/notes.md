# Day 16 – Streams & Lambdas

## Learnings
- Understood Functional Interfaces (interfaces with only one abstract method).
- Learned Lambda Expressions for concise implementation of functional interfaces.
- Explored the Stream API:
    - filter() - to select elements based on a condition.
    - map() - to transform elements.
    - sorted() - to order elements.
    - collect() - to gather results into a collection.
- Combined functional interfaces and streams in one program.

## Hands-on Task
- Created a custom functional interface BonusCalculator and implemented it with a lambda to calculate 10% bonus of employee salary.
- Used Stream API on Employee objects to:
    - Filter employees with salary > x
    - Sort them by age
    - Map names to uppercase
    - Collect the results into a new list
