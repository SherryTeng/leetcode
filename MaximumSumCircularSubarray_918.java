public class MaximumSumCircularSubarray_918 {
    public int maxSubarraySumCircular(int[] nums) {

        int n = nums.length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            total+= nums[i];
        }

        int currMax = nums[0];
        int globalMax = nums[0];
        int currMin = nums[0];
        int globalMin =nums[0];

        for (int i = 1; i < n; i++) {
            currMax = Math.max(currMax+nums[i], nums[i]);
            globalMax = Math.max(currMax, globalMax);
            currMin = Math.min(currMin+nums[i], nums[i]);
            globalMin = Math.min(currMin, globalMin);
        }

        if (globalMax < 0) return globalMax;

        return Math.max(globalMax, total-globalMin);



    }
}
