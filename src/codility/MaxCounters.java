package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
* # MaxCounters

Calculate the values of counters after applying all alternating operations:
increase counter by 1; set value of all counters to current maximum.

You are given N counters, initially set to 0, and you have two possible
operations on them:

    * increase(X) - counter X is increased by 1,
    * max counter - all counters are set to the maximum value of any counter.

A non-empty array A of M integers is given.
This array represents consecutive operations:

    * if A[K] = X, such that 1 <= X <=  N, then operation K is increase(X),
    * if A[K] = N + 1 then operation K is max counter.

For example, given integer N = 5 and array A such that:
    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4

the values of the counters after each consecutive operation will be:
    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)

The goal is to calculate the value of every counter after all operations.

Write a function:

    def solution(N, A)

that, given an integer N and a non-empty array A consisting of M integers,
returns a sequence of integers representing the values of the counters.

Result array should be returned as an array of integers.

For example, given:
    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4

the function should return [3, 2, 2, 4, 2], as explained above.

Write an efficient algorithm for the following assumptions:

        N and M are integers within the range [1..100,000];
        each element of array A is an integer within the range [1..N + 1].

Copyright 2009–2022 by Codility Limited. All Rights Reserved.
Unauthorized copying, publication or disclosure prohibited.*/
public class MaxCounters {

    public static void main(String[] args) {
        int[] nums = {3,4,4,6,1,4,4};
        int[] answer = solution(5, nums);
        Arrays.stream(answer).forEach(System.out::println);
    }

    private static int[] solution(int N, int[] A) {
        int answer = 0;

        List<Integer> counters = Stream.generate(() -> 0).limit(N).collect(Collectors.toList());

        for(int i=0; i<A.length;i++) {
            int x = A[i];
            if ( x <= N ) {
                //* increase(X) - counter X is increased by 1,
                int pos = Math.max(0, x-1);
                counters.set(pos, counters.get(pos) + 1);
            } else {

                //* max counter - all counters are set to the maximum value of any counter.
                int max = counters.stream().max(Integer::compareTo).get();
                Collections.fill(counters, max);
            }
        }

        return counters.stream().mapToInt(Integer::intValue).toArray();
    }
}
