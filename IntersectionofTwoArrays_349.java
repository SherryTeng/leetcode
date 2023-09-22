import java.util.*;

public class IntersectionofTwoArrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        Set<Integer> interset = new HashSet<>();
        for (int i =0; i < nums2.length; i++){
            if (set.contains(nums2[i])) {
                interset.add(nums2[i]);
            }
        }
        int[] res = new int[interset.size()];
        int i = 0;
        for (int num: interset){
            res[i++] = num;
        }
        return res;

    }
}
