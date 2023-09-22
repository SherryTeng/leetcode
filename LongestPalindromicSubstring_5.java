public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
//        dp(i, j) represents whether s(i ... j) can form a palindromic substring,
//        dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic substring.
//        When we found a palindrome, check if it's the longest one.
//        Time complexity O(n^2).
        int n = s.length();
        if (n==1) return s;
        boolean[][] dp = new boolean[n][n];
        String res = "";

        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j-i<3 ||dp[i+1][j-1])) {
                    dp[i][j] = true;
                }

                if (dp[i][j] && res.length() < j-i+1) {
                    res = s.substring(i,j+1);
                }
            }

        }
        return res;

    }
}
