import java.util.*;
public class CombinationSum_39 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> track = new ArrayList<>();
        int sum = 0;
        backtrack(candidates, track, 0, 0, target);
        return res;

    }

    private void backtrack(int[] nums, List<Integer> track, int start, int sum, int target){
        if (sum == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        if (start >= nums.length || sum > target) return;

        track.add(nums[start]);
        sum += nums[start];
        backtrack(nums, track, start, sum, target);
        sum -= nums[start];
        track.remove(track.size()-1);
        backtrack(nums, track, start+1, sum, target);


    }




//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        backtrack(res, list, candidates, target, 0);
//        return res;
//
//    }
//
//    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int remain, int start){
//        if (remain < 0) return;
//        if (remain == 0) {
//            res.add(new ArrayList<>(temp));
//        }else {
//            for (int i = start; i < candidates.length; i++) {
//                temp.add(candidates[i]);
//                backtrack(res, temp, candidates, remain-candidates[i],i);
//                temp.remove(temp.size()-1);
//            }
//        }
//
//    }
}
