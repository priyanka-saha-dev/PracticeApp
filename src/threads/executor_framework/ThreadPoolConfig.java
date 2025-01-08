package threads.executor_framework;

import java.util.concurrent.*;

public class ThreadPoolConfig {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolConfig threadPoolConfig = new ThreadPoolConfig();
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
                //threadPoolConfig.createThreadPool();

        Future<?> futureRunnable = threadPool.submit(() -> System.out.println("Runnable Task1")); //Runnable
        Future<String> futureCallable = threadPool.submit(() -> "Callable Task1"); //Callable

        System.out.println("Result: " + futureRunnable.get()); // null because Callable doesnt return anything
        System.out.println("Result: " + futureCallable.get());

        threadPool.shutdownNow();
    }



    public ExecutorService createThreadPool() {
        int corePoolSize = 10; // Number of consistently concurrent tasks
        int maxPoolSize = 50;  // Max threads based on expected workload
        long keepAliveTime = 30; // Threads above corePoolSize idle for 30 seconds

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(100); // Bounded queue

        return new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                workQueue,
                new ThreadPoolExecutor.CallerRunsPolicy() // Slow down producers when full
        );
    }
}
