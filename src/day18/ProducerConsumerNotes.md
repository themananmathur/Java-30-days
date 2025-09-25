# Day 18 – Multithreading Basics (Continued)

## Learnings
- Practiced the Producer-Consumer problem using `BlockingQueue`.
- Understood how `ArrayBlockingQueue` handles synchronization internally:
    - `put()` blocks when the queue is full.
    - `take()` blocks when the queue is empty.
- Learned about the **Poison Pill** strategy to gracefully signal consumers to stop.
- Observed that thread output is interleaved because scheduling is non-deterministic.
- Confirmed that each produced item is consumed exactly once, even though logs appear out of order.

## Hands-on Task
- Implemented `ProducerConsumer.java`:
    - Producer thread inserts numbers 1-10 into a bounded queue.
    - After finishing, producer inserts poison pills to stop consumers.
    - Two consumer threads take items from the queue and process them until they receive the poison pill.
- Verified execution:
    - Both consumers consumed all numbers without duplication or loss.
    - Consumers terminated cleanly upon receiving the poison pill.
