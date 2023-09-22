import java.util.Arrays;
import java.util.Collections;

public class MinimumFallingPathSum_931 {
    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;

        for (int i =1; i < n; i++) {
            for (int j = 0; j<n; j++) {
                matrix[i][j] +=  Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][Math.max(0, j - 1)], matrix[i - 1][Math.min(matrix.length - 1, j + 1)]));
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, matrix[n-1][i]);
        }
        return res;

    }
}
