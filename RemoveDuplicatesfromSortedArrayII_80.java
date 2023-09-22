public class RemoveDuplicatesfromSortedArrayII_80 {
    public int removeDuplicates(int[] nums) {
        int k = 1;
        int flag = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                if (flag < 2) {
                    nums[k] = nums[i];
                    k++;
                }
                flag++;
            }else {
                flag = 1;
                nums[k] = nums[i];
                k++;
            }
        }
        return k;

    }
}
