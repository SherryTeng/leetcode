public class NumberofEnclaves_1020 {
    private int rows;
    private int cols;
    public int numEnclaves(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        for (int i =0; i < rows; i++) {
            for (int j = 0; j< cols; j++) {
                if (i ==0 || i == rows-1 || j == 0 || j == cols-1) {
                    dfs(grid, i, j);
                }
            }
        }
        int res =0;
        for (int i =0; i < rows; i++) {
            for (int j = 0; j< cols; j++) {
                if (grid[i][j]==1) {
                    res++;
                }
                }
            }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i>=0 && i < rows && j >=0 && j < cols && grid[i][j] == 1) {
            grid[i][j] = 0;
            dfs(grid, i+1, j);
            dfs(grid, i-1, j);
            dfs(grid, i, j+1);
            dfs(grid, i, j-1);
        }
    }
}
