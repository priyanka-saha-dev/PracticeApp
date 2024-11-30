package threads.executor_framework;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Submit a task to the executor
        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(2000); // Simulate long-running task
            return 42;          // Return a result
        });

        // Do some other work while the task is running
        System.out.println("Task submitted. Doing other work...");

        try {
            // Wait for the result
            Integer result = future.get(); // Blocks until the task is complete
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Task failed: " + e.getMessage());
        }

        // Shutdown the executor
        executor.shutdown();
    }
}
