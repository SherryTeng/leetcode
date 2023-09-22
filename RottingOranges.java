import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {

        int time = -1;
        int fresh = 0;
        int[][] dirs = new int[][] {{-1,0}, {1,0}, {0, -1}, {0,1}};

        //find the position of rotten oranges and add to the q
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] {i,j});
                }else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;
        if (q.size() == 0) return -1;

        while (!q.isEmpty()) {
            int size = q.size();
            time ++;
            for (int i = 0; i < size; i++) {
                int[] curr = q.remove();
                for (int[] nei : dirs) {
                    int neiRow = curr[0] + nei[0];
                    int neiCol = curr[1] + nei[1];
                    if (neiRow < 0 || neiRow >= grid.length|| neiCol < 0 || neiCol >= grid[0].length||grid[neiRow][neiCol]!=1) continue;
                    if (grid[neiRow][neiCol]==1) {
                        grid[neiRow][neiCol]=2;
                        q.add(new int[] {neiRow, neiCol});
                        fresh--;
                    }
                }
            }
        }

        if (fresh != 0) {
            return -1;
        } else {
            return time;
        }

    }
}
