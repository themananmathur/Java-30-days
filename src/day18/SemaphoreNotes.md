# Day 18 – Multithreading Basics (Semaphore Practice)

## Learnings
- Explored the use of `Semaphore` to manage limited resources.
- A semaphore maintains a set number of permits. Threads must acquire a permit before proceeding and release it afterward.
- If no permit is available, a thread is blocked until one becomes free.
- Useful for controlling access to fixed resources like connection pools, parking slots, or printers.
- Understood difference from locks:
    - Locks protect shared data (mutual exclusion).
    - Semaphores control concurrency limits (permits).

## Hands-on Task
- Implemented `ParkingLot.java` using a `Semaphore` with 3 permits to represent 3 parking spots.
- Simulated 6 cars arriving concurrently:
    - Only 3 cars could park at a time.
    - Other cars waited until a spot was free.
- Each car occupied the spot for 2 seconds (`Thread.sleep`), then released the permit.
- Verified that cars parked and left in batches of 3, demonstrating controlled access with semaphores.
