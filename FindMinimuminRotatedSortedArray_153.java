public class FindMinimuminRotatedSortedArray_153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        if (nums[0] <= nums[nums.length-1]) return nums[0];

        while (left < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] < nums[right]) {

                right = mid;


            }else {
                left = mid+1;
            }
        }

        return nums[left];

    }
}
