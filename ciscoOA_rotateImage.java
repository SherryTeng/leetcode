public class ciscoOA_rotateImage {
    /*
    Given an image representing by an N*M matrix, where each pixel in the image is 4 bytes. Write an algorithm to rotate the image by 90 degrees right.
Input: the first line of the input consists of two space-separated integers- matrix_rows and matrix_cols, representing the number of rows of the matrix(N) and the number of columns of the matrix(M); The next N lines consist of M space-separated integers, representing the pixel of the matrix.
Output:
Print M lines consist of N space-separated integers representing the rotated images by 90 degrees.
     */

    public static int[][] rotateImage(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        int[][] rotated = new int[numCols][numRows];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                rotated[j][numRows - 1 - i] = matrix[i][j];
            }
        }

        return rotated;
    }

    public static void main (String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        int[][] rotated = rotateImage(matrix);

        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated[0].length; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }

    }
}
