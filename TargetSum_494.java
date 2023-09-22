public class TargetSum_494 {
    public int findTargetSumWays(int[] nums, int target) {

        //sum(A)-sum(B) = target
        //sum(A) = sum(B) +target
        //sum(A) + sum(A) = sum(A) + sum(B) +target = sum+target
        //sum(A) = (sum+target)/2
        //把原问题转化成：nums 中存在几个子集 A，使得 A 中元素的和为 (target + sum(nums)) / 2
        int sum =0;
        for (int num: nums) {
            sum+=num;
        }
        int sumTarget = (sum+target)/2;
        //有一个背包，容量为 sumTarget，现在给你 N 个物品，第 i 个物品的重量为 nums[i - 1]（注意 1 <= i <= N），每个物品只有一个，请问你有几种不同的方法能够恰好装满这个背包？

        if (sum < Math.abs(target) || (sum+target) %2 ==1) return 0;
        int n = nums.length;


        int[][] dp = new int[n+1][sumTarget+1];
        dp[0][0]=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <=sumTarget; j++) {
                if (j>=nums[i-1]) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sumTarget];
    }
}
