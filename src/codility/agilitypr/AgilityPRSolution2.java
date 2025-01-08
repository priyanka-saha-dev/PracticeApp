package codility.agilitypr;

import java.util.HashMap;
import java.util.Map;

public class AgilityPRSolution2 {

    public int solution(int[] X, int[] Y) {
        Map<String, Integer> count = new HashMap<>();
        int maxCount = 0;
        int length = X.length;

        for (int i = 0; i < length; i++) {
            int numerator = X[i];
            int denominator = Y[i];

            int gcd = divisor(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;

            String key = numerator + "/" + denominator;

            count.put(key, count.getOrDefault(key, 0) + 1);

            maxCount = Math.max(maxCount, count.get(key));
        }

        return maxCount;
    }

    public int solution1(int[] X, int[] Y) {
        Map<Integer, Integer> count = new HashMap<>();
        int maxCount = 0;
        int length = X.length;

        for (int i = 0; i < length; i++) {
            int numerator = X[i];
            int denominator = Y[i];

            int div = numerator / denominator;

            count.put(div, count.getOrDefault(div, 0) + 1);

            maxCount = Math.max(maxCount, count.get(div));
        }

        return maxCount;
    }

    private int divisor(int a, int b) {
        if (b == 0) return a;
        return divisor(b, a % b);
    }

    public static void main(String[] args) {
        AgilityPRSolution2 solution = new AgilityPRSolution2();

        int[] X1 = {1, 2, 3, 4, 0};
        int[] Y1 = {2, 3, 6, 8, 4};
        System.out.println(solution.solution(X1, Y1)); // Output: 3

        int[] X2 = {3, 3, 4};
        int[] Y2 = {5, 4, 3};
        System.out.println(solution.solution(X2, Y2)); // Output: 1

        int[] X3 = {4, 4, 7, 1, 2};
        int[] Y3 = {4, 4, 8, 1, 2};
        System.out.println(solution.solution(X3, Y3)); // Output: 4

        int[] X4 = {1, 2, 3, 1, 2};
        int[] Y4 = {2, 4, 6, 5, 10};
        System.out.println(solution.solution(X4, Y4)); // Output: 3
    }
}
