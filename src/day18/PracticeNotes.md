# Day 18 – Multithreading Basics

## Learnings
- Explored different ways to create threads in Java:
    - Extending the `Thread` class.
    - Implementing the `Runnable` interface.
    - Using `Callable` with `ExecutorService` for return values.
- Understood that thread scheduling is managed by the JVM/OS and execution order is not guaranteed.
- Practiced thread coordination with `sleep()` and `join()`.
- Learned about race conditions when multiple threads update shared data without synchronization.
- Explored solutions for race conditions:
    - Using `synchronized` blocks/methods.
    - Using atomic classes like `AtomicInteger`.
- Understood deadlocks and prevention techniques (`tryLock`, consistent lock ordering).
- Practiced using `ExecutorService` with `Callable` and `Future` for asynchronous tasks.
- Learned how `CompletableFuture` enables asynchronous pipelines with methods like `supplyAsync()`, `thenApply()`, and `thenCompose()`.

## Hands-on Tasks
- Wrote a program to:
    - Demonstrate thread lifecycle states (`NEW`, `RUNNABLE`, `WAITING`, `TERMINATED`).
    - Show race conditions using a shared counter and fix them using `AtomicInteger`.
    - Illustrate deadlock with two locks and prevent it using `tryLock`.
    - Use `ExecutorService` to submit multiple tasks and collect results with `Future`.
    - Build an asynchronous computation pipeline using `CompletableFuture` with chaining.
