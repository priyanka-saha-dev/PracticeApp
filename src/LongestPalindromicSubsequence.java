import java.util.stream.IntStream;

public class LongestPalindromicSubsequence {

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // All substrings with a single character are palindromes of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Build the table. The outer loop is for substrings of length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2; // Characters match
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]); // Characters don't match
                }
            }
        }

        // The length of the longest palindromic subsequence is in dp[0][n-1]
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        int result = longestPalindromeSubseq(s);
        System.out.println("The length of the longest palindromic subsequence is: " + result);
    }
}
