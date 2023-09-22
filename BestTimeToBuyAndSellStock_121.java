public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int b = 0;
        for (int s = 1; s< prices.length; s++) {
            if (prices[b] > prices[s]) {
                b = s;

            }
            profit = Math.max(profit, prices[s]-prices[b]);
        }

        return profit;


    }
}
