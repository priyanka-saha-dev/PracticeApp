package codility.agilitypr;

public class AgilityPRSolution1 {

    public int solution(int[] A) {
        if (A.length == 1) return 1;

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < A.length; i++) {
            if (i > 1 && A[i] == A[i - 2]) {
                currentLength++;
            } else {
                currentLength = 2;
            }
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        AgilityPRSolution1 solution = new AgilityPRSolution1();

        System.out.println(solution.solution(new int[]{3, 2, 3, 2, 3})); // Output: 5
        System.out.println(solution.solution(new int[]{7, 4, -2, 4, -2, -9})); // Output: 4
        System.out.println(solution.solution(new int[]{7, -5, -5, -5, 7, -1, 7})); // Output: 3
        System.out.println(solution.solution(new int[]{4})); // Output: 1
        System.out.println(solution.solution(new int[]{4,2})); // Output: 1
    }
}
