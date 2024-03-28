import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight_1046 {
    public int lastStoneWeight(int[] stones) {

        /**
         * data structure:  maxheap
         * algo: 1. we put every stone into a heap
         */

        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone: stones){
            maxheap.add(stone);
        }

        while (maxheap.size()>=2){
            int y = maxheap.remove();
            int x = maxheap.remove();

            if (x != y){
                int z = y-x;
                maxheap.add(z);
            }

        }

        if (maxheap.size() == 1) {
            return maxheap.peek();
        }

        return 0;


    }
}
