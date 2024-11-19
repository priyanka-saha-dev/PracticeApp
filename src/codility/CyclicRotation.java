package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*# CyclicRotation

An array A consisting of N integers is given. Rotation of the array means that
each element is shifted right by one index, and the last element of the array
is moved to the first place.

        For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]
        (elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be
shifted to the right K times.

Write a function:

class Solution { public int[] solution(int[] A, int K); }

that, given an array A consisting of N integers and an integer K,
returns the array A rotated K times.

        For example, given
A = [3, 8, 9, 7, 6]
K = 3

the function should return [9, 7, 6, 3, 8]. Three rotations were made:
        [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
        [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
        [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]

For another example, given
A = [0, 0, 0]
K = 1

the function should return [0, 0, 0]

Given
A = [1, 2, 3, 4]
K = 4

the function should return [1, 2, 3, 4]

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].

In your solution, focus on correctness. The performance of your solution will
not be the focus of the assessment.

        Copyright 2009–2022 by Codility Limited. All Rights Reserved.
        Unauthorized copying, publication or disclosure prohibited.*/
public class CyclicRotation {

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        int[] rotate = rotate(A, 6);
        Arrays.stream(rotate).forEach(System.out::print);
    }


    private static int[] rotate(int[] A, int K) {

        if(A.length == 0) return new int[0];
        if(A.length == 1 || K == 0) return A;

        int N = A.length;
        int[] result = new int[N];

        int limit = K < N ? K : K - N;
        return copyElements(A, result, N, limit);

    }

    private static int[] copyElements(int[] A, int[] result, int N, int limit) {
        System.arraycopy(A, N-limit, result, 0, limit);
        System.arraycopy(A, 0, result, limit, N-limit);
        return result;
    }

}
