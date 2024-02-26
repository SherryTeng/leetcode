import java.util.*;
public class NextGreaterElementI_496 {
    public static  int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i =0; i < nums2.length; i++){
            map.put(nums2[i],i);

        }

        for (int i = 0; i < nums1.length; i++){
            int index = map.get(nums1[i]);

            while(index+1  < nums2.length) {
                if (nums2[index+1] > nums1[i]) {
                    res[i] = nums2[index+1];
                    break;

                }
                index++;
            }

            if (index == nums2.length-1) res[i] = -1;


        }

        return res;


    }

    public static void main(String[] args){
        nextGreaterElement(new int[] {4,1,2}, new int[] {1,3,4,2});

    }
}
