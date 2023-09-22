public class NumberofClosedIslands_1254 {
    public int closedIsland(int[][] grid) {
        if (grid==null || grid.length ==0) return 0;
        int rows = grid.length, cols = grid[0].length;
        int res =0;
        for (int i = 1; i< rows-1; i++ ) {
            for (int j = 1; j < cols-1; j++) {
                if (grid[i][j] ==0) {
                    if (isClosedIsland(grid, i, j, rows, cols)){
                        res++;

                }


                }
            }
        }
        return res;
    }

    private boolean isClosedIsland(int[][] grid, int i, int j, int rows, int cols) {
        if (grid[i][j] == 1|| grid[i][j] == -1) return true;
        // we know we have a land(0)
        if (i==0|| i == rows-1||j==0 || j== cols-1) return false;

        grid[i][j]=-1;

        boolean left = isClosedIsland(grid, i, j-1, rows, cols);
        boolean right = isClosedIsland(grid, i, j+1, rows, cols);
        boolean up = isClosedIsland(grid, i-1, j, rows, cols);
        boolean down = isClosedIsland(grid, i+1, j, rows, cols);
        return left&&right&&up&&down;

    }
}
