import java.util.Arrays;

public class MaxNumberofKSumPairs_1679 {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length-1;

        int res = 0;

        while (i < j) {
            if (nums[i]+ nums[j] == k){
                i++;
                j--;
                res++;
            }else if (nums[i]+ nums[j] > k){
                j--;
            }else {
                i++;
            }

        }

        return res;

    }
}
