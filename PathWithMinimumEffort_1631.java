import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort_1631 {


    public static int minimumEffortPath(int[][] heights) {

        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        int rows = heights.length, cols = heights[0].length;

        int[][] efforts = new int[rows][cols];
        for (int[] effort: efforts) {
            Arrays.fill(effort, Integer.MAX_VALUE);
        }

        efforts[0][0] = 0;
        Queue<int[]> q = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        q.offer(new int[] {0,0,0});
        while(!q.isEmpty()) {
            int[] curr = q.remove();
            int effort = curr[0];
            int x = curr[1];
            int y = curr[2];
            if (x == rows-1 && y==cols-1) return effort;
            for (int[] dir: dirs) {
                int nextx = x + dir[0];
                int nexty = y + dir[1];
                if (nextx >=0 && nextx< rows && nexty >=0 && nexty< cols) {
                    int nextEffort = Math.max(effort, Math.abs(heights[x][y]-heights[nextx][nexty]));
                    if (efforts[nextx][nexty] > nextEffort) {
                        efforts[nextx][nexty] = nextEffort;
                        q.add(new int[]{nextEffort, nextx,nexty});
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] heights = new int[][] {{1,2,2},{3,8,2},{5,3,5}};
        minimumEffortPath(heights);

    }
}
