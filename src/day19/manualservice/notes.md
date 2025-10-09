# Day 19 — Unit Testing (JUnit 5 & Mockito Basics)

## Learnings

- **Unit Testing** is the process of verifying small pieces of code (units) in isolation.  
  Each test checks if a method or function behaves as expected.

- **JUnit 5** is a Java testing framework that provides annotations like `@Test` and methods like `assertEquals()`, `assertThrows()`, etc., to automate testing.

- **Assertions** act as checkpoints in tests — they confirm whether the output matches the expected result.

- Even without JUnit, we can simulate tests using our own simple **test harness** with `main()` and `try-catch`, to understand the core logic of testing.

- **Mockito** is a framework used to create *mock* (fake) objects for dependencies.  
  It helps test classes that rely on external components such as databases, APIs, or repositories.

- We manually implemented the *mocking concept* using a **Fake Repository**, which mimicked the behaviour of a real database layer —  
  this is exactly what Mockito does automatically.

- Testing ensures:
    - Code correctness
    - Early bug detection
    - Confidence during refactoring
    - Better code design and maintainability

---

## Key Concepts Covered

| Concept | Explanation |
|----------|-------------|
| **Unit Test** | Code that automatically tests a function/class. |
| **Assertion** | Logical check that verifies the output (pass/fail). |
| **Test Case** | One specific test scenario (valid input, invalid input, edge case, etc.). |
| **Mock Object** | A fake dependency used to isolate and test logic. |
| **Repository Mocking** | Pretending a database exists by returning predefined values. |
| **Validation Testing** | Ensuring that invalid data throws correct exceptions. |

---

## Hands-on Task

### Task 1 – Write Test Cases for `Student` Class

- Create `Student.java` with fields: `id`, `name`, `age`, `email`.
- Add validations:
    - Name cannot be blank.
    - Age must be between 0–150.
    - Email must be valid (contain `@`).
- Write automated test cases in `StudentTest.java`:
    - Test valid student creation.
    - Test invalid name, age, and email.
    - Test `equals()` behaviour for same ID.

### Task 2 – Simulate Mocking for `StudentService`

- Create a `FakeRepo` that implements `StudentRepository`.
- Configure it to:
    - Return a sample student when `findById()` is called.
    - Track whether repository methods are invoked.
- Write a demo (`StudentServiceMockDemo.java`) to:
    - Call `service.getStudent(id)`
    - Verify:
        - Correct data is returned.
        - Repository method was actually called.

---

## Expected Outputs

**Running `java day19.StudentTest`:**
