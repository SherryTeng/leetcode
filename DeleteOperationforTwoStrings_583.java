public class DeleteOperationforTwoStrings_583 {
    public int minDistance(String word1, String word2) {
        //throught process:  find longest common subsequence and then subtract it from whole length
        int m = word1.length(), n = word2.length();


        int[][] dp = new int[m+1][n+1];

        for (int i=0; i <=m; i++) {
            dp[m][0] = 0;
        }

        for (int i=0; i <=n; i++) {
            dp[0][n] = 0;
        }

        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n ; j ++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        int common =  dp[m][n];
        return m-common+n-common;

    }
}
