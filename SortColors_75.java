public class SortColors_75 {

    public void sortColors(int[] nums) {


    }

    //quick sort
//    public void sortColors(int[] nums) {
//        int l = 0;
//        int r = nums.length-1;
//        quickSort(nums,l,r);
//
//
//    }
//
//    private void quickSort(int[] nums, int l, int r) {
//        if (l>=r) return;
//        int pivot = partition(nums, l, r);
//        quickSort(nums, l, pivot-1);
//        quickSort(nums, pivot+1, r);
//    }
//
//    private int partition(int[] nums, int l, int r){
//        swap(nums, l, l+(r-l)/2);
//        int base = nums[l];
//        int i = l+1;
//
//        for (int j = l+1; j<=r; j++) {
//            if (nums[j]<base) {
//                swap(nums, i, j);
//                i++;
//            }
//        }
//        swap(nums,l, i-1);
//        return i-1;
//    }
//    private void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j]= temp;
//    }
}
