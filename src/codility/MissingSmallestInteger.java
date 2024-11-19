package codility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*# Missing Integer
Find the smallest positive integer that does not occur in a given sequence.

Write a function:

    def solution(A)

that, given an array A of N integers, returns the smallest positive integer
(greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [−1,000,000..1,000,000].

Copyright 2009–2022 by Codility Limited. All Rights Reserved.
Unauthorized copying, publication or disclosure prohibited.*/
public class MissingSmallestInteger {

    public static void main(String[] args) {
        int[] nums = {-1, -3};
        int answer = solution(nums);
        System.out.println("answer :: " + answer);
    }


    private static int solution(int[] nums) {
        List<Integer> numbers = Arrays.stream(nums).boxed().sorted().toList();

        int num = 1;

        for (int n : numbers) {
            if(numbers.contains(num)) {
                num++;
            } else{
                break;
            }
        }

        return num;

    }

    private static int solution2(int[] nums) {
        List<Integer> numbers = Arrays.stream(nums).boxed().sorted().toList();

        int sumOfNums = Arrays.stream(nums).sum();
        int sumOfAll = IntStream.rangeClosed(1, nums.length + 1).sum();

        return Math.abs(Math.subtractExact(sumOfAll, sumOfNums));

    }
}
