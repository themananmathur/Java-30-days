# Day 11 – Exception Handling

## Learnings

* Understood the use of `try-catch-finally` for error handling.
* Learned how to create and use **custom exceptions** by extending `Exception`.
* Practiced handling invalid input and limiting attempts with loop control.
* Saw how the `finally` block always executes, making it useful for logging or cleanup.

## Key Points

* **InvalidLoginException**: custom exception to represent wrong username/password.
* **try-catch-finally** flow:
    - `try` → runs the login validation.
    - `catch` → handles invalid login errors.
    - `finally` → logs each login attempt.
* **Attempt limit**: restricted to 3 tries before blocking login.
* Used constants (`USERNAME`, `PASSWORD`, `MAX_ATTEMPTS`) to store system credentials and rules.

## Hands-on Task

* Built a **Login System** program:
    - Prompts user for username and password.
    - Throws `InvalidLoginException` if credentials don’t match.
    - Allows max 3 attempts, after which the account is locked.
    - Uses `finally` to log attempt number consistently.
* Tested successful login and multiple failed attempts.
