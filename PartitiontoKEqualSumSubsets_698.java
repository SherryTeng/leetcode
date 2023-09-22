public class PartitiontoKEqualSumSubsets_698 {
//    public boolean canPartitionKSubsets(int[] nums, int k) {
//
//        int sum = 0;
//        for (int num: nums) {
//            sum+=num;
//        }
//
//        if (k<0 || k> nums.length || sum%k !=0) return false;
//
//        int target = sum/k;
//
//        boolean[] visited = new boolean[nums.length];
//        return backtrack(0, nums, visited, k, 0, target);
//
//    }
//
//    private boolean backtrack(int startIndex, int[] nums, boolean[] visited,  int k, int currSum, int target){
//        if (k==1) return true;
//        if (currSum==target) return backtrack(0, nums, visited, k-1,0, target);
//        for (int i = startIndex; i < nums.length; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                if(backtrack(i+1,nums, visited, k, currSum+nums[i],target)) return true;
//                visited[i] = false;
//            }
//        }
//
//        return false;
//    }


    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;
        for (int num: nums) {
            sum+=num;
        }

        if (k<0 || k> nums.length || sum%k !=0) return false;

        int target = sum/k;

        boolean[] visited = new boolean[nums.length];
        return backtrack(k, 0, nums, 0, visited, target);

    }

    //k: how many partitions are we left that we still need to build
    //start: what index are we at in nums array currently
    //currSum:
    private boolean backtrack(int k, int currSum, int[] nums, int start, boolean[] visited, int target){
        //ultimate base case:
        // if k is equal to zero, meaning we do not have to do any subsets anymore. we already built k subsets
        if (k==0) return true;
        //one other base case:
        if (currSum==target) return backtrack(k-1,0, nums,0, visited, target);
        //main logic function:
        for (int i = start; i < nums.length; i++) {
            if (visited[i]) continue;
            if (nums[i]+currSum > target) continue;
            visited[i] = true;
            currSum += nums[i];
            if(backtrack(k, currSum,nums,i+1,visited, target)) return true;
            //we reverse our decision
            visited[i] = false;
            currSum-= nums[i];

        }

        return false;
    }
}
