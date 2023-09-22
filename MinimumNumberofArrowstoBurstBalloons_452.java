import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumNumberofArrowstoBurstBalloons_452 {
    public int findMinArrowShots(int[][] points) {
        if (points==null || points.length == 0) return 0;
        Arrays.sort(points, (a,b)->Integer.compare(a[1],b[1]));
        int pos = points[0][1];
        int res=1;
        for (int i =1; i < points.length; i++) {
            if (pos >= points[i][0]) continue;
            pos = points[i][1];
            res++;
        }
        return res;

    }
}
