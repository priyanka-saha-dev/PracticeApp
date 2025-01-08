package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerExample {

//    public static void main(String[] args) {
//        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
//        Thread producer = new Thread(new Producer(queue), "Producer Thread");
//        Thread consumer = new Thread(new Consumer(queue), "Consumer Thread");
//
//        producer.start();
//        consumer.start();
//    }

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Thread producer = new Thread(() -> {
            System.out.println("Producer start");
            try {
                for (int i = 0; i < 10; i++) {
                    int random = (int) (Math.random() * 100);
                    System.out.println("Produced : " + random);
                    queue.add(random);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer Interrupted");
            }
        }, "Producer Thread");


        Thread consumer = new Thread(() -> {
            System.out.println("Consumer start");
            try {
                for (int i = 0; i < 10; i++) {
                    int consumed = queue.take();
                    System.out.println("Consumed : " + consumed);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer Interrupted");
            }
        }, "Consumer Thread");

        producer.start();
        consumer.start();
    }
}

class Producer implements Runnable {

    private final BlockingQueue<Integer> queue;

    Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Producer start");
        try {
            for (int i = 0; i < 10; i++) {
                int random = (int) (Math.random() * 100);
                System.out.println("Produced : " + random);
                queue.add(random);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Producer Interrupted");
        }
    }
}

class Consumer implements Runnable {

    private final BlockingQueue<Integer> queue;

    Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("Consumer start");
        try {
            for (int i = 0; i < 10; i++) {
                int consumed = queue.take();
                System.out.println("Consumed : " + consumed);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consumer Interrupted");
        }
    }
}