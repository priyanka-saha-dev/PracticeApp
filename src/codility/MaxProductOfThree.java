package codility;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/*
* */
public class MaxProductOfThree {

    public static void main(String[] args) {
        int[] nums = {-10, -10, -3, 0, 1};
        int answer = solution(nums);
        System.out.println("answer :: " + answer);

//        int[] answer = solution(0, nums);
//        Arrays.stream(answer).forEach(System.out::println);
    }

    private static int solution(int[] nums) {
        int maxProduct = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            int product = nums[i];
            if(i+1 < nums.length) {
                product *= nums[i+1];
            }
            if(i+2 < nums.length) {
                product *= nums[i+2];
            }

            maxProduct = Math.max(maxProduct, product);
        }

        return maxProduct;
    }

}
