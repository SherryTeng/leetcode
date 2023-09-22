import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res =  new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                int j = map.get(target-nums[i]);
                res[0] = i;
                res[1] = j;
                break;
            }else {
                map.put(nums[i], i);
            }
        }

        return res;
    }

}
