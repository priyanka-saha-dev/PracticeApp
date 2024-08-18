import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {

    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(5); // Buffer with a capacity of 5 items

        Thread producerThread = new Thread(new Producer(buffer, 10));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }
}

class SharedBuffer {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(Integer val) throws InterruptedException {

        while (buffer.size() == this.capacity) {
            System.out.println("Buffer full @ : " + buffer.size());
            wait();
        }

        buffer.add(val);
        System.out.println("Produced : " + val);
        notify();
    }

    public synchronized Integer consume() throws InterruptedException {

        while (buffer.isEmpty()) {
            System.out.println("Buffer empty");
            wait();
        }

        Integer val = buffer.poll();
        System.out.println("Consumed : " + val);
        notify();

        return val;
    }

}

class Producer implements Runnable {

    private final SharedBuffer buffer;
    private final Integer limit;

    public Producer(SharedBuffer buffer, Integer limit) {
        this.buffer = buffer;
        this.limit = limit;
    }

    @Override
    public void run() {
        int val = 0;
        try {
            while (val < limit) {
                buffer.produce(val++);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {

    private final SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {

        try {
            while (true) {
                buffer.consume();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
