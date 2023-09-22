import java.util.LinkedList;
import java.util.Queue;

public class WallsandGates_286 {
    public static void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n=rooms[0].length;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j =0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[]{i,j});
                }
            }
        }

        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] d: dirs) {
                int r = curr[0]+d[0];
                int c = curr[1]+d[1];
                if (r < 0||r>=m||c <0|| c>= n|| rooms[r][c] != 2147483647) continue;
                rooms[r][c] = rooms[curr[0]][curr[1]] +1;
                q.add(new int[]{r,c});
            }
        }

    }

    public static void main(String[] args) {
        int[][] test =  new int[][] {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1}};
        wallsAndGates(test);
    }
}
