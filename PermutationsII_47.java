import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class PermutationsII_47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        if (nums == null || nums.length==0) return res;
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, used);
        return res;
    }
    private static void backtrack(List<List<Integer>> res, List<Integer> track, int[] nums, boolean[] used) {
        if (track.size()==nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        for(int i = 0; i< nums.length; i++) {
            if (used[i]) continue;
            //if the previous number is used, then used this number
            if (i>0 && nums[i-1]==nums[i]&& !used[i-1]) continue;
            used[i] = true;
            track.add(nums[i]);
            backtrack(res, track, nums, used);
            used[i]= false;
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,1,2};
        permuteUnique(nums);
    }
}
