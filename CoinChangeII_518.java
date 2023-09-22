public class CoinChangeII_518 {
    public int change(int amount, int[] coins) {
        //0-1 knapsack problem
        //dp[i][j] : the number of combinations to make up amount j by using the first i types of coins
        int n = coins.length;
        int[][] dp = new int[n+1][amount + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] =1;
        }
        for (int i=1; i <=n; i++) {
            for (int j = 1; j <= amount; j++) {
                //skip ith coin
                dp[i][j] = dp[i-1][j];
                //use ith coin
                if (j >=coins[i-1]) {
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[n][amount];
    }
//    public int change(int amount, int[] coins) {
//        int[] dp = new int[amount + 1];
//        dp[0] = 1;
//        for (int coin : coins) {
//            for (int i = coin; i <= amount; i++) {
//                dp[i] += dp[i-coin];
//            }
//
//        }
//        return dp[amount];
//
//    }
}
