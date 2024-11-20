package threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Create a thread pool with 5 threads
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        // Submit tasks to the thread pool
        for (int i = 1; i <= 10; i++) {
            int taskNumber = i;
            threadPool.submit(() ->
                    System.out.println("Task " + taskNumber + " is running by " + Thread.currentThread().getName()));
        }

        // Shutdown the thread pool after tasks are completed
        threadPool.shutdown();         // Graceful shutdown
//        threadPool.shutdownNow();  // Immediate shutdown
    }

}
