package codility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*# PermMissingElem
Find the missing element in a given permutation.

An array A consisting of N different integers is given.
The array contains integers in the range [1..(N + 1)],
which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

def solution(A)

that, given an array A, returns the value of the missing element.

        For example, given array A such that:
A[0] = 2
A[1] = 3
A[2] = 1
A[3] = 5

the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].

Copyright 2009–2022 by Codility Limited. All Rights Reserved.
        Unauthorized copying, publication or disclosure prohibited.*/
public class PermMissingElem {

    public static void main(String[] args) {
        int[] nums = {2,3,4,1,-1};
        int answer = solution2(nums);
        System.out.println("answer :: " + answer);
    }


    private static int solution(int[] nums) { // Low performance for big arrays
        List<Integer> numbers = Arrays.stream(nums).boxed()
                .sorted().toList();
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


    private static int solution2(int[] nums) {// Low performance for big arrays
        List<Integer> numbers = Arrays.stream(nums).boxed().filter(n -> n > 0).sorted().toList();

        int sumOfNums = numbers.stream().reduce(0, Integer::sum);
        int sumOfAll = IntStream.rangeClosed(1, nums.length + 1).sum();

        return Math.abs(Math.subtractExact(sumOfAll, sumOfNums));

    }

    private static int solution3(int[] nums) {// Best Performance
        int sumOfNums = 0;
        for (int n : nums) {
            sumOfNums += n;
        }
        int sumOfAll = IntStream.rangeClosed(1, nums.length + 1).sum();

        return Math.abs(Math.subtractExact(sumOfAll, sumOfNums));

    }
}
