import java.util.*;

public class Subsets_78 {
    //    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        Arrays.sort(nums);
//        backtrack(res, new ArrayList<>(), nums,0);
//        return res;
//    }
//
//    private void backtrack(List<List<Integer>> res, List<Integer> subset, int[] nums, int start) {
//        res.add(new ArrayList<>(subset));
//
//        for (int i=start; i< nums.length; i++) {
//            subset.add(nums[i]);
//            backtrack(res, subset, nums, i+1);
//            subset.remove(subset.size()-1);
//        }
//
//    }
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, subset);
        return res;

    }
    //i is the index of the element we are going to visit
    private void backtrack(int[] nums, int i, List<Integer> subset) {
        //base case:
        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        //case1: we pick the element
        subset.add(nums[i]);
        backtrack(nums,i+1, subset);
        //case2: we do not pick the element
        subset.remove(subset.size()-1);
        backtrack(nums,i+1, subset);


    }
}
