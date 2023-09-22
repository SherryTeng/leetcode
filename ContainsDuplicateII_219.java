import java.util.*;

public class ContainsDuplicateII_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }else {
                int j = map.get(nums[i]);

                if (Math.abs(j-i) <= k) {
                    return true;
                }else {
                    map.put(nums[j], j);
                }
            }
        }

        return false;

    }
}
