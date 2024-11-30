package threads.executor_framework;

import java.util.concurrent.*;

public class CompletableFutureWithExecutorExample {
    public static void main(String[] args) {
        // Create a custom thread pool
        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("Submitting task to CompletableFuture...");

        // Create a CompletableFuture and execute it with a custom executor
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task is running on thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000); // Simulate a long-running task
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return 42; // Computed result
        }, executor);

        // Attach a non-blocking callback to process the result
        future.thenApply(result -> {
            System.out.println("Transforming result on thread: " + Thread.currentThread().getName());
            return result * 2; // Transform the result
        }).thenAccept(finalResult -> {
            System.out.println("Final Result: " + finalResult);
        });

        // Continue doing other work while the task runs
        System.out.println("Main thread continues to execute other tasks...");

        // Shut down the executor
        executor.shutdown();
    }
}
