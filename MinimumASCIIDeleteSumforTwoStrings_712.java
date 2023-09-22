public class MinimumASCIIDeleteSumforTwoStrings_712 {
    public int minimumDeleteSum(String s1, String s2) {

        int m = s1.length(), n= s2.length();

        int[][] dp = new int[m+1][n+1];
        //base case 1. s2 is empty
        for (int i = 1; i <=m; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }
        //base case 2. s1 is empty
        for (int j = 1; j <=n; j++) {
            dp[0][j] = dp[0][j-1]+s2.charAt(j-1);
        }

        for (int i  = 1; i <=m;i++) {
            for(int j =1; j <=n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];

                    //if the last characters are different then its one of the two situations:
                    //drop s1's last character (ASCII(s1's last) + dp[i-1][j])
                    //drop s2's last character (ASCII(s2's last) + dp[i][j-1])

                }else {
                    dp[i][j] = Math.min(s1.charAt(i-1)+dp[i-1][j], s2.charAt(j-1)+dp[i][j-1]) ;
                }
            }
        }
        return dp[m][n];
    }

}
