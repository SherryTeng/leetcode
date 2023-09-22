import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairswithSmallestSums {
    /**
     * 347
     *You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
     *
     * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
     *
     * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
     *
     *
     *
     * Example 1:
     *
     * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
     * Output: [[1,2],[1,4],[1,6]]
     * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
     */
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {


        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]+a[1]-b[0]-b[1]);

        List<List<Integer>> res = new ArrayList<>();


        for (int i = 0; i < nums1.length || i < k; i++) {
            minHeap.add(new int[] {nums1[i], nums2[0], 0});
        }


        while (!minHeap.isEmpty() && k-- > 0) {
            int[] curr = minHeap.remove();
            res.add(Arrays.asList(curr[0], curr[1]));
            if (curr[2] == nums2.length-1) continue;
            minHeap.add(new int[]{curr[0], nums2[curr[2]+1], curr[2]+1});

        }
        return res;

    }


    public static void main(String[] args) {
        List<List<Integer>> res = FindKPairswithSmallestSums.kSmallestPairs(new int[] {1,7,11}, new int[] {2,4,6}, 3);
        for (List<Integer> pair : res) {
            System.out.println(pair.toString());
        }


    }



}
