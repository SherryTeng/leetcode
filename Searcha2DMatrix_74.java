public class Searcha2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n =matrix[0].length;

        int lo = 0;
        int hi = m-1;

        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (matrix[mid][n-1] == target) {
                return true;

            }else if (target < matrix[mid][n-1]){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }

        if (lo >= m) return false;

        int left = 0;
        int right = n-1;

        while (left <= right) {
            int mid = left + (right-left)/2;
            if (matrix[lo][mid] == target) {
                return true;

            }else if (target < matrix[mid][n-1]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;

    }
}
