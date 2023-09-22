import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> minHeap =  new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {

        this.k = k;
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
    }

    public int add(int val) {

        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.remove();
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

        KthLargest kthLargest = new KthLargest(3, new int[]{4});
        System.out.println(kthLargest.add(3));    // return 4
//        kthLargest.add(5);   // return 5
//        kthLargest.add(10);  // return 5
//        kthLargest.add(9);   // return 8
//        kthLargest.add(4);   // return 8
    }
}

