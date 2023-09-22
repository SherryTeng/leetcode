public class BestTimetoBuyAndSellStockIII_123 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[3][n];

        for (int k = 1; k <3;k++) {
            int min = prices[0];
            for (int i = 1; i < n; i++) {
                min = Math.min(min, prices[i] - dp[k-1][i-1]);
                dp[k][i] = Math.max(dp[k][i-1], prices[i]-min);
            }



        }
        return dp[2][n-1];

    }

}
