import java.util.*;

/**
 * 692. Top K Frequent Words
 * Given an array of strings words and an integer k, return the k most frequent strings.
 *
 * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
 *
 * Example 1:
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
 * Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 */
public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> wordFreq = new HashMap<>();

        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }


        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue());
        for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size()>k) {
                minHeap.remove();
            }
        }

        List<String> topK = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            topK.add(0, minHeap.remove().getKey());
        }
//        Collections.reverse(topK);
        return topK;

//        Map<String, Integer> wordFreq = new HashMap<>();

//        for (String word : words) {
//            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
//        }
//
//
//        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a,b) -> a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue()-a.getValue());
//        maxHeap.addAll(wordFreq.entrySet());
//
//        List<String> topK = new ArrayList<>();
//        while(!maxHeap.isEmpty() && k-->0) {
//            topK.add(maxHeap.remove().getKey());
//        }
//        return topK;



    }
}


