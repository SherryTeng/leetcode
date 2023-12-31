import java.util.Arrays;

public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);

        dp[0]=0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin: coins) {
                if (i>= coin) {
                    dp[i] = Math.min(dp[i-coin]+1, dp[i]);
                }
            }
        }
        if (dp[amount]>amount) return -1;
        return dp[amount];
    }
}
