public class MaxAreaofIsland_695 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid==null || grid.length == 0) return 0;
        int m = grid.length, n= grid[0].length;
        int max = 0;

        for (int i =0; i <m; i++) {
            for (int j =0; j<n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs (grid, i, j, m,n);
                    if (area > max) {
                        max = area;
                    }
                }
            }
        }

        return max;
    }

    private int dfs (int[][] grid, int i, int j, int m, int n) {
        int area =1;
        if (i < 0 || i >= m || j <0 || j>= n|| grid[i][j] ==0) return 0;
        grid[i][j] =0;
        int up = dfs(grid, i-1,j, m,n);
        int right = dfs(grid, i,j+1, m,n);
        int down = dfs(grid, i+1,j, m,n);
        int left = dfs(grid, i,j-1, m,n);
        area+= up+right+down+left;
        return area;
    }
}
