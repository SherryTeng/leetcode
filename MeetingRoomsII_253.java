import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII_253 {
    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[1]-b[1]);

        int res = 0;
        for (int i = 0; i < intervals.length; i++) {
            while (!q.isEmpty() && intervals[i][0] >= q.peek()[1]) {
                q.remove();
            }
            q.offer(intervals[i]);
            res = Math.max(res, q.size());
        }
        return res;
    }
}
