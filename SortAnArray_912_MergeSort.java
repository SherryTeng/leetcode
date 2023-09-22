public class SortAnArray_912_MergeSort {
    public int[] sortArray(int[] nums) {
        if (nums==null || nums.length == 0) return nums;
        megerSort(nums, 0, nums.length-1);
        return nums;

    }

    public void megerSort(int[] nums, int l, int r){
        if (l>=r) return;
        int mid = (l+r)/2;
        megerSort(nums, l, mid);
        megerSort(nums, mid+1, r);
        mergeTwoSortedList(nums, l, r);
    }

    public void mergeTwoSortedList(int[] nums, int l, int r) {
        int[] temp = new int[r-l+1];

        int mid = (l+r)/2;
        int i = l;
        int j= (l+r)/2+1;
        int k =0;

        while (i<=mid &&j<=r) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                k++;
                i++;
            }else {
                temp[k] = nums[j];
                k++;
                j++;

            }

        }

        while (i<=mid) {
            temp[k++] = nums[i++];
        }

        while (j<=r) {
            temp[k++] = nums[j++];
        }

        for (int p = l; p <= r; p++) {
            nums[p] = temp[p-l];

        }




    }
}
