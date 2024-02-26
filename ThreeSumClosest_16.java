import java.util.*;
public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closestSum = nums[0]+nums[1]+nums[2];

        for (int i = 0; i < nums.length-2; i++) {
            int j = i+1;
            int k = nums.length-1;

            while (j< k) {

                int sum = nums[i] + nums[j]+ nums[k];
                if ( Math.abs(target-sum) < Math.abs(target-closestSum)) {
                    closestSum = sum;

                }else if (sum < target) {

                    j++;


                }else{

                    k--;
                }
            }
        }

        return closestSum;


        /**
         * method thought by myself
         */
//        Arrays.sort(nums);
//
//        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)-> a[0]-b[0]);
//
//        for (int i = 0; i < nums.length-2; i++) {
//            int j = i+1;
//            int k = nums.length-1;
//
//            while (j< k) {
//
//                int sum = nums[i] + nums[j]+ nums[k];
//                if ( sum == target) {
//                    return target;
//
//                }else if (sum < target) {
//                    minHeap.add(new int[]{target-sum, sum});
//                    j++;
//
//
//                }else{
//                    minHeap.add(new int[]{sum-target, sum});
//                    k--;
//                }
//            }
//        }
//
//        int[] res = minHeap.peek();
//
//        return res[1];


    }
}
