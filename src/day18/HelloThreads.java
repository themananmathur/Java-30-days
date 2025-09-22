package day18;

import LMS.MemberNotFoundException;

public class HelloThreads {
    static class MyThread extends Thread {
        private String name;
        MyThread(String name) {this.name = name;}
        public void run() {
            for (int i = 1; i < 5; i++) {
                System.out.println(this.name + " - iteration - " + i);
                try { Thread.sleep(200); } catch (InterruptedException e) {}
            }
        }
    }
    static class MyRunnable implements Runnable {
        private String name;
        MyRunnable(String name) {this.name = name;}
        public void run() {
            for (int i = 1; i < 5; i++) {
                System.out.println(this.name + " - iteration - " + i);
                try { Thread.sleep(250); } catch (InterruptedException e) {}
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread t1 = new MyThread("Thread-1");
        Thread t2 = new MyThread("Thread-2");
        Thread r1 = new Thread(new MyRunnable("Runnable-1"));
        Thread r2 = new Thread(new MyRunnable("Runnable-2"));

        t1.start(); t2.start(); r1.start(); r2.start();
        t1.join(); t2.join(); r1.join(); r2.join();

        System.out.println("All threads finished");
    }
}
