public class CountSubIslands_1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        int m = grid1.length, n= grid1[0].length;
        for (int i =0; i < m; i++) {
            for (int j =0; j< n; j++) {
                if (grid2[i][j] ==1 && isSubIsland(grid1, grid2, i, j, m, n)) {
                    res++;
                }
            }
        }
        return res;
    }
    private boolean isSubIsland(int[][] grid1, int[][] grid2, int i, int j, int m, int n) {

        if (i >=0 && i < m && j>=0 && j < n && grid2[i][j] ==1) {
            if (grid1[i][j] == 0) return false;
            grid2[i][j] = -1;
            boolean left = isSubIsland(grid1,grid2, i, j-1, m,n);
            boolean right = isSubIsland(grid1,grid2, i, j+1, m,n);
            boolean up = isSubIsland(grid1,grid2, i-1, j, m,n);
            boolean down = isSubIsland(grid1,grid2, i+1, j, m,n);
            if (!left || !right ||!up || !down) return false;
        }

        return true;


    }
}
