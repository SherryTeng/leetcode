public class BestTimetoBuyandSellStockwithCooldown_309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] dp = new int[n+2];
        dp[n] = 0;

        for (int i = n-1; i >=0; i--) {
            int c1 = 0;
            for (int k = i+1; k <n; k++) {
                int profit = prices[k]-prices[i]+dp[k+2];
                c1 = Math.max(profit, c1);
            }
            int c2 = dp[i+1];

            dp[i] = Math.max(c1,c2);
        }
        return dp[0];


    }
}
