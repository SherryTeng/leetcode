package SlidingWindow;

public class LongestSubarrayof1sAfterDeletingOneElement_1493 {
    public int longestSubarray(int[] nums) {
        if (nums.length == 1) return 0;

        int zeroCount = 0;

        int i = 0;

        int len =0;

        for (int j = 0; j < nums.length; j++){
            if (nums[j] == 0){
                zeroCount++;
            }

            while (zeroCount >1) {
                if (nums[i] == 0){
                    zeroCount--;
                }
                i++;

            }

            len = Math.max(len, j-i);

        }

        return len;

    }
}
