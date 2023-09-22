public class MaximumAverageSubarrayI_643 {
    public static double findMaxAverage(int[] nums, int k) {


        long sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

       long  maxSum =sum;

        for (int i = 1; i <= nums.length-k; i++) {
            long potentialMax = sum - nums[i-1] + nums[i+k-1];
            sum = potentialMax;

            maxSum = Math.max(maxSum, potentialMax);

        }

//        double ave = maxSum/1.0/k;

        return (double)maxSum/k;

    }

    public static void main(String[] args){

        int[] nums = {0,1,1,3,3};

        findMaxAverage(nums, 4);

        System.out.println(findMaxAverage(nums, 4));

    }
}
