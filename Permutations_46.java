import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_46 {
    //Method1
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtrack(res, track , nums);
        return res;
    }
    private static void backtrack(List<List<Integer>> res, List<Integer> track, int[] nums) {
        if (track.size()== nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i =0; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            backtrack(res, track, nums);
            track.remove(track.size()-1);
        }
    }
//    //Method2
//    List<List<Integer>> res = new ArrayList<>();
//    public List<List<Integer>> permute(int[] nums) {
//        ArrayList<Integer> track = new ArrayList<>();
//        boolean[] used = new boolean[nums.length];
//        backtrack(nums, track, used);
//        return res;
//    }
//
//    private void backtrack(int[] nums, ArrayList<Integer> track, boolean[] used) {
//        if (track.size() == nums.length) {
//            res.add(new ArrayList<>(track));
//        }
//        for (int i = 0; i< nums.length; i++) {
//            if (used[i]) continue;
//            track.add(nums[i]);
//            used[i] = true;
//            backtrack(nums, track, used);
//            used[i] = false;
//            track.remove(track.size()-1);
//
//        }
//    }



    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        permute(nums);
    }
}
