package threads;

import java.util.concurrent.*;

public class ConcurrentSum {
    public static int parallelSum(int[] array) throws InterruptedException, ExecutionException {
        int mid = array.length / 2;
        Callable<Integer> task1 = () -> sum(array, 0, mid);
        Callable<Integer> task2 = () -> sum(array, mid, array.length);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executor.submit(task1);
        Future<Integer> future2 = executor.submit(task2);

        int result = future1.get() + future2.get();
        executor.shutdown();
        return result;
    }

    private static int sum(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(parallelSum(array)); // Output: 55
    }
}