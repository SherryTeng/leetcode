public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int k = n-2;

        while (k>=0) {
            if (nums[k] < nums[k+1]){
                break;
            }
            k--;

        }

        if (k < 0) {
            reverse(nums, 0, n-1);
        }else {

            int j = n-1;
            while(j >= k){
                if (nums[k] < nums[j]){
                    break;
                }
                j--;
            }

            swap(nums, k, j);
            reverse(nums,k+1, n-1);
        }
    }

    private void reverse(int[] nums, int i, int j) {


        while (i <= j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
