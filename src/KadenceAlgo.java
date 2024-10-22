public class KadenceAlgo {

    // Question :: maximum sum of a contiguous subarray
    // Kadane’s algorithm efficiently finds the maximum sum of a contiguous subarray in an array:
    // Time complexity of Kadane’s Algorithm is O(n) :: The algorithm iterates through the array exactly once, making it linear in time
    // Space complexity of Kadane’s Algorithm is O(1) :: No extra space is needed beyond the input array.

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum sum of contiguous subarray is: " + maxSubArraySum(nums));  // Output: 6
    }

    private static int maxSubArraySum(int[] nums) {

        // Initialize the max sum and current sum
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];

        // Iterate over the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            int total = maxEndingHere + nums[i];

            // Update current sum to include the current element,
            // or reset to the current element if it's greater
            maxEndingHere = Math.max(nums[i], total);

            // Update the maximum sum so far
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;

    }
}
