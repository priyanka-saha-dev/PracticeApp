package codesignal;

import java.util.Arrays;

public class ArrayManipulation {

    public static void main(String[] args) {
        int[] answer = apply(new int[]{4, 0, 1, -2, 3});
        Arrays.stream(answer).forEach(System.out::println);
    }


    private static int[] apply(int[] nums) {
//        - For each i from 0 to a.length - 1 inclusive, b[i] = a[i - 1] + a[i] + a[i + 1]
//        – If an element in the sum a[i - 1] + a[i] + a[i + 1] does not exist, use 0 in its place
//        – For instance, b[0] = 0 + a[0] + a[1]

        int[] b = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];

            int previousIndex = i-1;
            int previousNumber = previousIndex < 0 ? 0 : nums[previousIndex];

            int nextIndex = i+1;
            int nextNumber = nextIndex >= nums.length ? 0 : nums[i+1];

            b[i] = previousNumber + number + nextNumber;
        }

        return b;

    }
}
