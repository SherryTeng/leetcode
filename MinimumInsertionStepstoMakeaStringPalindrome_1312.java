public class MinimumInsertionStepstoMakeaStringPalindrome_1312 {
    public int minInsertions(String s) {
        int n = s.length();

        //dp[i][j] means the length of longest common sequence between
        //i first letters in s1 and j first letters in s2.
        int[][] dp = new int[n+1][n+1];


        for (int i =0; i <n; i++) {
            for (int j = 0; j < n; j++) {
               if (s.charAt(i) == s.charAt(n-1-j)) {
                   dp[i+1][j+1] =dp[i][j]+1;
               }else {
                   dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
               }
            }

        }

        return n - dp[n][n];
    }
}
