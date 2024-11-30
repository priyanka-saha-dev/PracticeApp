package threads.executor_framework;

import java.util.concurrent.*;

public class CompletableFutureMultipleThreadsExample {
    public static void main(String[] args) {
        // Create a custom thread pool
        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("Submitting multiple tasks to CompletableFuture...");

        // Task 1: Simulate fetching user data
        CompletableFuture<String> fetchUserData = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching user data on thread: " + Thread.currentThread().getName());
            sleep(2000); // Simulate delay
            return "User123";
        }, executor);

        // Task 2: Simulate fetching account data
        CompletableFuture<Integer> fetchAccountData = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching account data on thread: " + Thread.currentThread().getName());
            sleep(1500); // Simulate delay
            return 1000; // Account balance
        }, executor);

        // Combine results of Task 1 and Task 2
        CompletableFuture<String> combinedResult = fetchUserData.thenCombine(fetchAccountData, (user, balance) -> {
            System.out.println("Combining results on thread: " + Thread.currentThread().getName());
            return "User: " + user + ", Balance: $" + balance;
        });

        // Attach a final callback to process the combined result
        combinedResult.thenAccept(result -> {
            System.out.println("Final Result: " + result);
        });

        // Main thread continues to execute other tasks
        System.out.println("Main thread continues to execute other tasks...");

        // Wait for all tasks to complete
        combinedResult.join();

        // Shut down the executor
        executor.shutdown();
    }

    // Utility method to simulate delay
    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
