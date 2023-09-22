import java.lang.reflect.Array;
import java.util.Arrays;

public class NonOverlappingIntervals_435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[1],b[1]));
        int res = 0;
        int currEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= currEnd) {
                currEnd = intervals[i][1];
            } else {
                res++;
            }

        }

        return res;
    }
    public static void main(String[] args) {
        int[][] test = new int[][] {{1,2},{1,2},{1,2}};
        eraseOverlapIntervals(test);
    }
}
