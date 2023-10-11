import java.util.PriorityQueue;

public class KthLargestElementinaStream_703 {
    PriorityQueue<Integer> q = new PriorityQueue<>();
    int k;

    public KthLargestElementinaStream_703(int k, int[] nums) {
        this.k = k;
        for (int num: nums){
            q.add(num);
            if (q.size()>k) {
                q.remove();
            }
        }

    }

    public int add(int val) {
        q.add(val);
        if (q.size()>k){
            q.remove();
        }
        return q.peek();

    }
}
