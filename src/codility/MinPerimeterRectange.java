package codility;

/*
MinPerimeterRectangle - Find the minimal perimeter of any rectangle whose area equals N.

An integer N is given, representing the area of some rectangle.
The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).
The goal is to find the minimal perimeter of any rectangle whose area equals N.
The sides of this rectangle should be only integers.

For example, given integer N = 30, rectangles of area 30 are:

        (1, 30), with a perimeter of 62,
        (2, 15), with a perimeter of 34,
        (3, 10), with a perimeter of 26,
        (5, 6), with a perimeter of 22.

Write a function:
    def solution(N)
that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

For example, given an integer N = 30, the function should return 22, as explained above.

Write an efficient algorithm for the following assumptions:
        N is an integer within the range [1..1,000,000,000].

Copyright 2009–2023 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
* */
public class MinPerimeterRectange {

    public static void main(String[] args) {
        int answer = solution(5);
        System.out.println("answer :: " + answer);

//        int[] answer = solution(0, nums);
//        Arrays.stream(answer).forEach(System.out::println);
    }

    private static int solution(int nums) {
        int answer = 0;

        for (int i = 1; i <= nums ; i ++ ) {
            if( nums % i == 0) {
                int A = i;
                int B = nums / i;

                int perimeter = 2 * (A+B);
                answer = answer == 0 ? perimeter : Math.min(answer, perimeter);
            }
        }

        return answer;
    }
}
