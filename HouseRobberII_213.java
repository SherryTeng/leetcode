public class HouseRobberII_213 {
    public int rob(int[] nums) {

        int n = nums.length;
        if (n==1) return nums[0];
        if (n==2) return Math.max(nums[0], nums[1]);

        int withFirstHouse = helper(nums, 0, n-2);
        int withLastHouse = helper(nums, 1, n-1);

        return Math.max(withFirstHouse, withLastHouse);

    }

    private int helper(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start+1], nums[start]);
        for (int i = start+2; i <= end; i++) {
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[end];
    }
//    public static void main(String[] args) {
//        int[] test = new int[]{200,3,140,20,10};
//        rob(test);
//    }
}
