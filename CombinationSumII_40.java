import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CombinationSumII_40 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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

        for (int i = start; i < nums.length; i++){
            track.add(nums[i]);
            sum+=nums[i];
            backtrack(nums, track, i+1, sum, target);
            sum-=nums[i];
            track.remove(track.size()-1);
            while (i+1 < nums.length && nums[i] == nums[i+1]){
                i++;
            }


        }


    }



//    List<List<Integer>> res = new ArrayList<>();
//
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//
//        List<Integer> list = new ArrayList<>();
//        Arrays.sort(candidates);
//        backtrack(list, candidates, target, 0);
//        return res;
//
//    }
//
//    private void backtrack(List<Integer> temp, int[] candidates, int remain, int start) {
//        if (remain < 0) return;
//        if (remain == 0) {
//            res.add(new ArrayList<>(temp));
//            return;
//        }
//
//        for (int i = start; i < candidates.length; i++) {
//            temp.add(candidates[i]);
//            backtrack(temp, candidates, remain - candidates[i], i + 1);
//            temp.remove(temp.size() - 1);
//            while (i+1 < candidates.length && candidates[i]==candidates[i+1]) {
//                i = i+1;
//            }
//        }
//
//
//    }
}
