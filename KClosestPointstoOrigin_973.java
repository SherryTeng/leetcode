import java.util.Comparator;
import java.util.PriorityQueue;

import static java.lang.Math.sqrt;

public class KClosestPointstoOrigin_973 {

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> q =new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double diff = sqrt(o1[1]*o1[1]+o1[0]*o1[0]) - sqrt(o2[1]*o2[1]+o2[0]*o2[0]);
                if (diff <0 ) {
                    return -1;
                }else if (diff >0 ) {
                    return 1;
                } else return 0;
            }
        });

        for (int[] point: points) {
            q.add(point);
        }

        int[][] res = new int[k][];
        for (int i = 0; i <k; i++) {
            if (!q.isEmpty()) {
                res[i] = q.poll();
            }

        }

        return res;


    }

}
