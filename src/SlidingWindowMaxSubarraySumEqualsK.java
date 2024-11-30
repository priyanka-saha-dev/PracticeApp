import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlidingWindowMaxSubarraySumEqualsK {

    public static void main(String[] args) {

        int findMaximumSubArraySizeK = findMaximumSubArraySizeK(new int[]{1, 2, 1, 4}, 3);
        System.out.println("findMaximumSubArraySizeK : " + findMaximumSubArraySizeK);
    }

    private static int findMaximumSubArraySizeK(int[] nums, int k) {
        // 1,2,1,4
        // 121 = 4
        // 214 = 7 // Result

        int sum = 0, maxLen = 0;

        Map<Integer, Integer> prefixSum = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if(sum == k) {
                maxLen = i+1;
            }

            // Check if the array contains the complement
            int complement = sum - k;
            if(prefixSum.containsKey(complement)) {
                maxLen = Math.max(maxLen, i-prefixSum.get(complement));
            }

            if(!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, i);
            }
        }

        return maxLen;

    }

}
