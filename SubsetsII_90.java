import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII_90 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, subset);
        return res;

    }
    private void backtrack(int[] nums, int i, List<Integer> subset) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(nums, i+1, subset);

        subset.remove(subset.size()-1);
        while (i+1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }
        backtrack(nums, i+1, subset);
    }
}
