public class LongestPalindromicSubsequence_516 {
    public static int longestPalindromeSubseq(String s) {

        int n = s.length();
        //dp[i][j] denotes the longest palindromic subsequence's length of substring(i, j), here i, j represent left, right indexes in the string
        int[][] dp = new int[n][n];

        for (int i =n-1 ; i >=0 ; i--) {
            dp[i][i]=1;
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2+ dp[i+1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }

            }
        }

        return dp[0][n-1];
    }
    public static void main(String[] args) {
        String test = "bbacb";
        longestPalindromeSubseq(test);
    }
}
