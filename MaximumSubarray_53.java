public class MaximumSubarray_53 {
//    public int maxSubArray(int[] nums) {
//        int currSum = nums[0];
//        int maxSum = nums[0];
//
//        for (int i = 1; i < nums.length;i++){
//            currSum = Math.max(currSum+nums[i], nums[i]);
//            maxSum = Math.max(currSum, maxSum);
//        }
//
//        return maxSum;
//
//    }

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        //dp[i] denotes 以nums[i]为结尾的subarray的最大值
        dp[0]= nums[0];
        for (int i =1; i < n ; i++) {
            dp[i] = Math.max(nums[i], nums[i]+dp[i-1]);
        }
        int sum = nums[0];
        for (int i =1; i < n; i++) {
            sum = Math.max(sum, dp[i]);
        }
        return sum;
    }

}
