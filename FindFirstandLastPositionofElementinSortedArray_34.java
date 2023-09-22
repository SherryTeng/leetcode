public class FindFirstandLastPositionofElementinSortedArray_34 {
    public static int[] searchRange(int[] nums, int target) {

        int l = 0, r = nums.length-1;
        while (l <= r) {
            int mid = l+(r-l)/2;
            if (nums[mid] == target) {
                int lowIndex = mid;
                int highIndex = mid;
                while (lowIndex>=l && nums[lowIndex] == target ) {
                    lowIndex--;
                }
                while (highIndex <=r && nums[highIndex] == target){
                    highIndex++;
                }

                return new int[] {lowIndex+1, highIndex-1};
            }else if (target > nums[mid]) {
                l = mid+1;
            }else{
                r = mid-1;
            }

        }
        return new int[]{-1,-1};


    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        searchRange(nums, 6);

    }
}
