
import java.util.*;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        int size = nums.length;

        for (int i=0; i< size -2; i++) {
            int l = i+1;
            int r = size-1;

            while (l<r) {
                int sum = nums[i] + nums[l]+nums[r];
                if (sum ==0) {
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                }else if (sum < 0) {
                    l++;
                }else{
                    r--;
                }
            }
        }

        return new ArrayList<>(res);

    }
}
