import java.util.*;

public class FindMedianfromDataStream_295 {
    PriorityQueue<Integer> small = new PriorityQueue<>((a,b)->b-a);
    PriorityQueue<Integer> large = new PriorityQueue<>();

    public FindMedianfromDataStream_295() {

    }

    public void addNum(int num) {
        small.add(num);
        large.add(small.poll());

        if (small.size() < large.size()){
            small.add(large.poll());
        }

    }

    public double findMedian() {
        if (small.size() == large.size()){
            return (double)(small.peek()+large.peek())/2;
        }else {
            return small.peek();
        }

    }
}
