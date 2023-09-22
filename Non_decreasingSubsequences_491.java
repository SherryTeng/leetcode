import java.util.*;

public class Non_decreasingSubsequences_491 {
    Set<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
//        if (nums.length < 2) return res;
        List<Integer> sub = new ArrayList<>();
        backtrack(0, sub, nums);
        List result = new ArrayList(res);
        return result;

    }
    private void backtrack(int start, List<Integer> sub, int[] nums) {
        if (sub.size() >= 2) {
            res.add(new ArrayList<>(sub));

        }
        if (start >= nums.length) return;


        for (int i = start; i< nums.length; i++) {
            if (sub.size() == 0 || nums[i] >= sub.get(sub.size()-1)) {
                sub.add(nums[i]);
                backtrack(i+1, sub, nums);
                sub.remove(sub.size()-1);

            }

        }
    }
}
