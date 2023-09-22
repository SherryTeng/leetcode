import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {


    public int shortestPathBinaryMatrix(int[][] grid) {

        int res = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        if (grid[0][0] == 1 || grid[rowLen-1][colLen-1] == 1) return -1;
        int[][] dir = new int[][] {{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1},{0,-1}, {-1,-1}};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        boolean[][] visited = new boolean[rowLen][colLen];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            for (int i =0; i<size; i++) {
                int[] curr = q.remove();
                if (curr[0] == rowLen-1 && curr[1] == colLen-1) {
                    return res;
                }
                for (int[] nei : dir) {
                    int neiRow = curr[0] + nei[0];
                    int neiCol = curr[1] + nei[1];
                    if (neiRow < 0 || neiRow >= rowLen || neiCol < 0 || neiCol >= colLen|| visited[neiRow][neiCol] || grid[neiRow][neiCol] ==1) continue;
                    visited[neiRow][neiCol] = true;
                    q.add(new int[] {neiRow, neiCol});
                }
            }

            }
        return -1;

    }
}

//class Solution {
//
//
//    public int shortestPathBinaryMatrix(int[][] grid) {
//        if(grid[0][0] != 0){
//            return -1;
//        }
//
//        int[][] dir = new int[][]{{1,1},{1,0},{0,1},{-1,0},{0,-1},{1,-1},{-1,1},{-1,-1}};
//
//        int n = grid.length;
//        boolean[][] visited = new boolean[n][n];
//        Queue<int[]> q = new LinkedList<>();
//        q.add(new int[]{0, 0, 0});
//        visited[0][0] = true;
//
//        while(!q.isEmpty()){
//            int[] curr = q.remove();
//            if(curr[0] == n -1 && curr[1] == n - 1) return curr[2] + 1;
//
//            for(int i = 0; i < dir.length; i++){
//                int x = curr[0] + dir[i][0];
//                int y = curr[1] + dir[i][1];
//                if(isCorrectDirection(grid, x, y) && !visited[x][y]){
//                    visited[x][y] = true;
//                    q.add(new int[]{x, y, curr[2] + 1});
//                }
//            }
//        }
//
//        return -1;
//    }
//
//    private boolean isCorrectDirection(int[][] grid, int i, int j){
//        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid.length - 1){
//            return false;
//        }
//        if(grid[i][j] != 0){
//            return false;
//        }
//        return true;
//    }
//}
