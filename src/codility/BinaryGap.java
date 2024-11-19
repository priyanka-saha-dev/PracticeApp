package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*# Binary Gap

A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at
both ends in the binary representation of N.

For example,
The number 9 has binary representation 1001 and contains a binary gap of length 2.
The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3.
The number 20 has binary representation 10100 and contains one binary gap of length 1.
The number 15 has binary representation 1111 and has no binary gaps.
The number 32 has binary representation 100000 and has no binary gaps.

Write a function:

def solution(N)

that, given a positive integer N, returns the length of its longest binary gap.
The function should return 0 if N doesn't contain a binary gap.

        For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its
longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation
 '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].

Copyright 2009–2022 by Codility Limited. All Rights Reserved.
        Unauthorized copying, publication or disclosure prohibited.*/
public class BinaryGap {

    public static void main(String[] args) {
        int num = 32;
        int[] binary = toBinary(num);
        Arrays.stream(binary).forEach(System.out::print);
        int maxConsecutiveZeroes = maxConsecutiveZeroes(binary);
        System.out.println("maxConsecutiveZeroes = " + maxConsecutiveZeroes);
    }


    private static int[] toBinary(int num) {

        List<Integer> binary = new ArrayList<>();

        while (num > 0) {
            int rem = num % 2;
            num = num / 2;
            binary.add(rem);
        }

        Collections.reverse(binary);
        return binary.stream().mapToInt(Integer::intValue).toArray();

    }

    private static int maxConsecutiveZeroes(int[] nums) {
        //100001
        int gap = 0;
        int maxGap = 0;
        for (int n : nums) {
            if(n == 0) {
                gap++;
            } else if( n == 1) {
                maxGap = Math.max(maxGap, gap);
                gap = 0;

            }
        }

        return maxGap;

    }
}
