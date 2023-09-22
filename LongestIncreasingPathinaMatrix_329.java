public class LongestIncreasingPathinaMatrix_329 {

    private final int[][] dirs = {{0,-1},{0,1}, {-1,0}, {1,0}};
    int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length ==0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int[][] cache = new int[m][n];


        int res = 0;

        for (int i = 0; i< m; i++) {
            for(int j =0; j < n; j++) {
                int length = dfs(matrix, i, j, cache);
                res = Math.max(length, res);
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x >= 0 && x < m && y>=0 && y < n && matrix[i][j] < matrix[x][y]) {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y, cache));
            }
        }
        return ++cache[i][j];
    }
}
