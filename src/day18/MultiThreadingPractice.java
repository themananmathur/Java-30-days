package day18;

import javax.print.attribute.standard.RequestingUserName;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

import static java.lang.Thread.sleep;

public class MultiThreadingPractice {

    //thread lifecycle
    static void LifeCycle() throws InterruptedException {
        Thread t = new Thread(() -> {
            try{
                System.out.println("state= " + Thread.currentThread().getState());
                sleep(200);
            } catch(InterruptedException ignored){}
        }, "LifeCycle Thread");

        System.out.println("New LifeCycle: " + t.getState());
        t.start();
        //thread now runnable
        sleep(50);
        System.out.println("After starting LifeCycle: " + t.getState());

        t.join();
        System.out.println("After joining LifeCycle: " + t.getState());
    }

    //race condition resolved using Atomic
    static void Race() throws InterruptedException {
        class Counter{
            int count = 0;
            void increment(){count++;}
            synchronized int get() {return count;}
        }
        Counter unsafe = new Counter();
        AtomicInteger safe = new AtomicInteger(0);

        Runnable rUnsafe = () -> {for (int i=0; i<50000; i++) unsafe.increment();};
        Runnable rSafe = () -> {for (int i=0; i<50000; i++) safe.incrementAndGet();};

        Thread a1 = new Thread(rUnsafe), a2 = new Thread(rUnsafe);
        a1.start(); a2.start();
        a1.join(); a2.join();
        System.out.println("Unsafe final count (expected=100000): " + unsafe.get());

        Thread b1 = new Thread(rSafe), b2 = new Thread(rSafe);
        b1.start(); b2.start();
        b1.join(); b2.join();
        System.out.println("Safe final count (expected=100000): " + safe.get());

    }

    // deadlock
    static void Deadlock() throws InterruptedException {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("t1 locks lock1");
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("t1 locks lock2");
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("t2 locks lock2");
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized(lock1) {
                    System.out.println("t2 locks lock1");
                }
            }
        }, "t2");

        System.out.println("Deadlock starting...");
        t1.start(); t2.start();

        sleep(100);
        System.out.println("Program deadlocked");

        //tryLock with ReentrantLock and timeout
        Lock L1 = new ReentrantLock();
        Lock L2 = new ReentrantLock();

        Runnable safeA = () -> {
            try{
                if(L1.tryLock(300, TimeUnit.MILLISECONDS)){
                    try{
                        System.out.println("safeA got L1");
                        sleep(100);
                        if(L2.tryLock(300, TimeUnit.MILLISECONDS)){
                            try {System.out.println("safeA got L2");}
                            finally { L2.unlock(); }
                        } else System.out.println("safeA could not get L2");
                    } finally { L1.unlock(); }
                } else  System.out.println("safeA could not get L1");
            } catch(InterruptedException ignored){}
        };

        Runnable safeB = () -> {
            try{
                if(L2.tryLock(300, TimeUnit.MILLISECONDS)){
                    try{
                        System.out.println("safeB got L2");
                        sleep(100);
                        if(L1.tryLock(300, TimeUnit.MILLISECONDS)){
                            try {System.out.println("safeB got L1");}
                            finally { L1.unlock(); }
                        } else System.out.println("safeB could not get L1");
                    } finally { L2.unlock(); }
                } else  System.out.println("safeB could not get L2");
            } catch(InterruptedException ignored){}
        };

        Thread sA = new Thread(safeA), sB = new Thread(safeB);
        sA.start(); sB.start();
        sA.join(); sB.join();
        System.out.println("Deadlock prevented using tryLock and timeout");
    }

    // ExecutorService and future
    static void Executor() throws Exception{
        ExecutorService pool = Executors.newFixedThreadPool(3);
        List<Future<Integer>> futures = new ArrayList<>();
        for(int i=1; i<=6; i++){
            final int n=i;
            futures.add(pool.submit(() -> {
                sleep(100 + n*50);
                System.out.println("Computed" + n + "->" + (n*n));
                return n*n;
            }));
        }
        System.out.println("Collecting results: ");
        for(Future<Integer> f : futures){
            System.out.println("Result: " + f.get());
        }
        pool.shutdown();
    }

    // completableFuture
    static void Completable() throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(120);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("cf1 supply 10");
            return 10;
        }, pool);

        CompletableFuture<Integer> cf2 = cf1.thenApplyAsync(x -> {
            System.out.println("cf1 thenApply x*2 = " + (x*2));
            return x*2;
        }, pool).thenComposeAsync(x -> CompletableFuture.supplyAsync(() -> {
            try {
                sleep(80);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thenCompose add 5");
            return x + 5;
        }, pool), pool);

        System.out.println("Final result: " + cf2.get());
        pool.shutdown();
    }

public static void main(String[] args) throws Exception {
    String demo = (args.length==0) ? "help" : args[0].toLowerCase(Locale.ROOT);
    switch (demo) {
        case "lifecycle": LifeCycle(); break;
        case "race": Race(); break;
        case "deadlock": Deadlock(); break;
        case "executor": Executor(); break;
        case "cf": case "completable": Completable(); break;
        default:
            System.out.println("Usage: java MultithreadingPractice <demo>");
            System.out.println("demos: lifecycle | race | deadlock | executor | completable");
    }
}
}