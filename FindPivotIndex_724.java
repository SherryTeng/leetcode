public class FindPivotIndex_724 {
    public int pivotIndex(int[] nums) {

        int leftSum = 0;

        int rightSum = 0;

        int sum = 0;

        for (int num: nums) {
            sum+= num;
        }

        if (sum - nums[0] == 0) return 0;

        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i-1];
            rightSum = sum- leftSum-nums[i];

            if (leftSum == rightSum){
                return i;
            }

        }

        return -1;

    }
}
