import java.util.Arrays;
import java.util.List;

public class SlidingWindowNumbersAlgorithm {

    public static void main(String[] args) {

        int findMaximumSubArraySizeK = findMaximumSubArraySizeK(new int[]{1, 2, 1, 4}, 3);
        System.out.println("findMaximumSubArraySizeK : " + findMaximumSubArraySizeK);

        int findLengthOfSmallestSubArrayForAGivenSum = findLengthOfSmallestSubArrayForAGivenSum(new int[]{1, 2, 1, 4}, 7);
        System.out.println("findLengthOfSmallestSubArrayForAGivenSum : " + findLengthOfSmallestSubArrayForAGivenSum);

        int[] findSmallestSubArrayForAGivenSum = findSmallestSubArrayForAGivenSum(new int[]{1, 2, 1, 4}, 7);
        System.out.println("findSmallestSubArrayForAGivenSum : " + Arrays.toString(findSmallestSubArrayForAGivenSum));
    }

    private static int[] findSmallestSubArrayForAGivenSum(int[] nums, int sum) {
        // 1,2,1,4
        // 12 = 3
        // 21 = 3
        // 14 = 5
        // 121 = 4
        // 214 = 7 // Result
        int windowwSum = 0;
        int minLength = Integer.MAX_VALUE; // Initialize minLength to a large value
        int start = 0;

        int resultI = -1, resultJ = -1;

        for (int end = 0; end <nums.length; end++) {
            windowwSum += nums[end];
            // Shrink the window as small as possible while the window's sum is larger than or equal to Sum
            while (windowwSum >= sum) {

                if(end - start + 1 < minLength) {
                    int windowSize = end - start + 1;
                    minLength = Math.min(minLength, windowSize);
                    resultI = start;
                    resultJ = end;
                }

                windowwSum -= nums[start];
                start++;
            }
        }

        if(resultI == -1 || resultJ == -1) {
            return new int[]{};
        }
        int windowSize = resultJ - resultI + 1;
        int[] result = new int[windowSize];
        for (int i = 0; i < nums.length; i++) {
            result[i - resultI] = nums[i];
        }

        return result;
    }

    private static int findLengthOfSmallestSubArrayForAGivenSum(int[] nums, int sum) {
        // 1,2,1,4
        // 12 = 3
        // 21 = 3
        // 14 = 5
        // 121 = 4
        // 214 = 7 // Result
        int windowwSum = 0;
        int minLength = Integer.MAX_VALUE; // Initialize minLength to a large value
        int start = 0;

        for (int end = 0; end <nums.length; end++) {
            windowwSum += nums[end];
            // Shrink the window as small as possible while the window's sum is larger than or equal to S
            while (windowwSum >= sum) {
                int windowSize = end - start + 1;
                minLength = Math.min(minLength, windowSize);
                windowwSum -= nums[start];
                start++;
            }
        }
        return minLength;
    }

    private static int findMaximumSubArraySizeK(int[] nums, int k) {
        // 1,2,1,4
        // 121 = 4
        // 214 = 7 // Result

        int maxSum = 0;

        for (int start = 0; start < nums.length; start++) {
            int sum = sumOfSubArray(nums, start, k);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;

    }

    private static int sumOfSubArray(int[] nums, int start, int k) {
        List<Integer> subList = extractSubArray(nums, start, k);
        if(subList.size() == k) {
            return subList
                    .stream()
                    .reduce(Math::addExact)
                    .orElse(0);
        } else {
            return 0;
        }
    }

    private static List<Integer> extractSubArray(int[] nums, int start, int k) {
        int end = Math.min(start + k, nums.length);
        return Arrays.stream(nums)
                .boxed()
                .toList()
                .subList(start, end);
    }
}
