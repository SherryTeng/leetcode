import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence_300 {
    //Method 1: binary search
    public static int lengthOfLIS(int[] nums) {
        //dp: an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
        int[] dp = new int[nums.length];
        int size =0;
        for (int n : nums) {
            int left = 0, right =size;
            while (left < right) {
                int middle = (left+right)/2;
                if (dp[middle] < n) {
                    left = middle+1;
                }else{
                    right = middle;
                }
            }
            dp[left] = n;
            if (left == size) size++;
        }
        return size;

    }
    public static void main(String[] args) {
        int[] test = new int[] {10,9,2,5,3,101,18};
        lengthOfLIS(test);

    }
//    public int lengthOfLIS(int[] nums) {
//        ArrayList<Integer> sub = new ArrayList<>();
//        sub.add(nums[0]);
//        for(int i =1; i< nums.length; i++) {
//            int num = nums[i];
//            if (num > sub.get(sub.size()-1)) {
//                sub.add(num);
//            }else{
//                int j = binarySearch(sub, num);
//                sub.set(j,num);
//            }
//        }
//        return sub.size();
//
//    }
//
//    private int binarySearch(ArrayList<Integer> sub, int num) {
//        int l = 0;
//        int r = sub.size()-1;
//        while (l<=r) {
//            int mid = l+(r-l)/2;
//            if (sub.get(mid) == num){
//                return mid;
//            }
//            if (num > sub.get(mid) ) {
//                l = mid+1;
//            }else{
//                r = mid-1;
//            }
//
//        }
//        return l;
//    }


//    //Method 2: dynamic programming O(n^2)
//
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        //dp[i] denotes length of the LIS ends with nums[i]
//        int[] dp = new int[n];
//        Arrays.fill(dp, 1);
//        for (int i = 0; i < nums.length; i++) {
//            for (int j =0; j<i; j++) {
//                if (nums[i] > nums[j]) {
//                    dp[i] = Math.max(dp[i], dp[j]+1);
//                }
//            }
//
//        }
//        int len = dp[0];
//        for (int i = 0; i < n; i++) {
//            if (dp[i]>len){
//                len = dp[i];
//            }
//        }
//        return len;
//
//    }


}
