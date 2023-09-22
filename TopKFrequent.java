import java.util.*;

public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {

        // construct hashmap (num: frequency)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) +1);
        }

        //PQ
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry.getValue());
        }

        ArrayList<Integer> elements = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int freq = maxHeap.remove();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

                if (entry.getValue() == freq) {
                    int element = entry.getKey();
                    elements.add(element);
                    map.remove(element);
                    break;
                }
            }
        }
        int[] topK = elements.stream().mapToInt(i -> i).toArray();

        return topK;
    }


}
