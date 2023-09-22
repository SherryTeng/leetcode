public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length-1;

        while (lo <=hi) {
            int mid = (lo+hi)/2;
            if (target == nums[mid]) return mid;
            if (target < nums[mid]) {
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return lo;

    }
}
