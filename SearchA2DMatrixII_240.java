public class SearchA2DMatrixII_240 {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length < 1 || matrix[0].length <1 ) return false;

        int col = matrix[0].length-1;
        int row = 0;

        while (col >= 0 && row <= matrix.length-1) {
            if (target  == matrix[col][row]) return true;
            if (target <  matrix[col][row] ) {
                col--;
            } else row ++;
        }

        return false;


    }
}
