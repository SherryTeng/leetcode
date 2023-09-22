public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        //Method 1
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n-1; i++) {
            farthest = Math.max(farthest, i+nums[i]);
            //[0,2,3]
            if (farthest <= i) return false;
        }

        return farthest>=n-1;

        //Method 2
//        int n = nums.length;
//        int lastPos = n-1;
//        for (int i = n-1; i >=0; i--) {
//            if (i+nums[i] >= lastPos) {
//                lastPos = i;
//            }
//        }
//        return lastPos == 0;
    }
}
