import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        List<Integer> res = new ArrayList<>();

        while(top <= bottom && left <= right) {

//            traverse right
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

//            traverse down
            for (int i = top ; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;

//            traverse left: check if the row still exists
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
            }
            bottom--;

//            traverse up: check if the column still esists
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;

        }
        return res;
    }
}
