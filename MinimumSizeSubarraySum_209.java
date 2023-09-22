public class MinimumSizeSubarraySum_209 {
    public static int minSubArrayLen(int target, int[] nums) {

        int totalSum = 0;

        for (int num: nums) {
            totalSum += num;
        }

        if (totalSum < target) return 0;


        int n = nums.length;
        int res = n+1;
        int i = 0;
        int sum = 0;

        for (int j = 0; j < n; j++) {
            sum+= nums[j];
            while (sum >= target) {
                res = Math.min(res, j-i+1);
                sum -= nums[i];
                i++;
            }
        }

        if (res == n+1) {
            return 0;
        }
        return res;






    }

    public static void  main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        minSubArrayLen(7, nums);

    }
}
