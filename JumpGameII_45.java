public class JumpGameII_45 {
    public int jump(int[] nums) {

        //This is an implicit bfs solution. i == curEnd means you visited all the items on the current level.
        // Incrementing jumps++ is like incrementing the level you are on.
        // And curEnd = curFarthest is like getting the queue size (level size) for the next level you are traversing.
        int res = 0,currEnd = 0, currFarthest = 0;
        int n = nums.length;
        for (int i = 0; i < n-1; i++) {
            currFarthest = Math.max(currFarthest, i+nums[i]);
            if (i == currEnd) {
                res++;
                currEnd = currFarthest;
            }
        }
        return res;
    }
}
