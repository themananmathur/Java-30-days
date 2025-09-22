# Day 18 – Multithreading Basics

## Learnings
- Explored multithreading in Java using `Thread` and `Runnable`.
- Understood that thread scheduling is managed by the JVM/OS and execution order is not guaranteed.
- Practiced using `Thread.sleep()` to simulate work and observe interleaving outputs.
- Learned how to use `join()` to make the main thread wait for other threads.
- Compared creating threads by extending `Thread` vs implementing `Runnable`.
- Reinforced the idea that multiple threads run concurrently but require proper synchronization for shared data.

## Hands-on Task
- Wrote a program `HelloThreads.java` to demonstrate multiple threads.
- Created two threads by extending `Thread` and two by implementing `Runnable`.
- Started all threads and observed their outputs running in parallel with unpredictable order.
- Used `join()` to ensure the main thread waits until all worker threads finish.
