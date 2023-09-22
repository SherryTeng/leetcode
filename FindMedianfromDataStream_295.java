//import java.util.*;
//
//public class FindMedianfromDataStream_295 {
//    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//
//    public MedianFinder() {
//
//    }
//
//    public void addNum(int num) {
//        maxHeap.add(num);
//        minHeap.add(maxHeap.poll());
//        if (maxHeap.size() < minHeap.size()) {
//            maxHeap.add(minHeap.poll());
//        }
//
//    }
//
//    public double findMedian() {
//        if (maxHeap.size()> minHeap.size()) return maxHeap.peek();
//        return (double)(minHeap.peek()+maxHeap.peek())/2;
//
//    }
//}
