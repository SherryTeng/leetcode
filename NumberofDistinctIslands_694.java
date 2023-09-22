import java.util.*;

public class NumberofDistinctIslands_694 {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length ==0) return 0;
        Set<String> set = new HashSet<>();

        int rows = grid.length, cols = grid[0].length;
        for (int i =0; i < rows; i++) {
            for (int j=0; j < cols; j++) {
                if (grid[i][j]==1) {
                    String path = dfs(grid, i, j, rows, cols, "x");
                    set.add(path);
                }
            }
        }

        return set.size();

    }

    private String dfs(int[][] grid, int i, int j, int rows, int cols, String dir) {
        if(i <0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0) return "O";
        grid[i][j]=0;
        String up = dfs(grid, i-1, j, rows, cols, "u");
        String right = dfs(grid, i, j+1, rows, cols, "r");
        String down = dfs(grid, i+1, j, rows, cols, "d");
        String left = dfs(grid, i, j-1, rows, cols, "l");

        return dir+up+right+down+left;

    }
    //https://www.youtube.com/watch?v=MnD8KhBHgRo&ab_channel=MichaelMuinos
}
