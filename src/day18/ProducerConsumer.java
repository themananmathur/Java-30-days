package day18;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.sleep;

public class ProducerConsumer {

    private static final int POISON_PILL = -1;

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // producer
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    queue.put(i); //blocks if queue is full
                    System.out.println("Producer produced= " + i);
                    sleep(100);
                }
                // 1 poison pill per consumer inserted
                queue.put(POISON_PILL);
                queue.put(POISON_PILL);
                System.out.println("Producer inserts poison pill");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Producer");

        // consumer
        Runnable consumer = () -> {
            try {
                while (true) {
                    int item = queue.take(); // blocks if queue is empty
                    if(item == POISON_PILL) {
                        queue.put(POISON_PILL);
                        System.out.println("[" + Thread.currentThread().getName() + "] recieved POISON PILL. Exiting...");
                        break;
                    }
                    System.out.println("[" + Thread.currentThread().getName() + "]  consumed " + item);
                    sleep(150);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread consumer1 = new Thread(consumer, "Consumer1");
        Thread consumer2 = new Thread(consumer1, "Consumer2");

        consumer1.start();
        consumer2.start();
        producer.start();

        producer.join();
        consumer1.join();
        consumer2.join();

        System.out.println("Completed");
    }

    private  static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
