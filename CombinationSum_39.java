import java.util.*;
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, candidates, target, 0);
        return res;

    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int remain, int start){
        if (remain < 0) return;
        if (remain == 0) {
            res.add(new ArrayList<>(temp));
        }else {
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                backtrack(res, temp, candidates, remain-candidates[i],i);
                temp.remove(temp.size()-1);
            }
        }

    }
}
