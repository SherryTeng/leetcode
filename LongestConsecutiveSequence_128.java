import java.util.*;

public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num: nums) {
            set.add(num);
        }

        int res = 0;
        for (int num: nums) {
            if (!set.contains(num-1)) {
                int k = 1;
                int currNum = num;

                while (set.contains(currNum+1)) {
                    currNum+=1;
                    k++;
                }

                res = Math.max(res, k);

            }
        }

        return res;

    }
}
