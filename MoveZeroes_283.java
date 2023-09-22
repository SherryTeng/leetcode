public class MoveZeroes_283 {
    //Method1: on my own
//    public void moveZeroes(int[] nums) {
//        if (nums.length == 1) return;
//        int i =0;
//        int j =1;
//
//        while (j < nums.length) {
//            if (nums[i] == 0 && nums[j] != 0) {
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
//                i++;
//                j++;
//            }else if (nums[i] != 0 && nums[j] == 0){
//                i++;
//                j++;
//            }else if (nums[i]!=0 && nums[j]!=0) {
//                i++;
//                j++;
//            }else if (nums[i] == 0 && nums[j] == 0) {
//                j++;
//            }
//        }
//
//    }
    //Method2: snowballs
    public void moveZeroes(int[] nums) {
        int snowballsize =0;
        for (int i =0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowballsize ++;
            }else if (snowballsize > 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[i-snowballsize] =temp;
            }
        }

    }
}
