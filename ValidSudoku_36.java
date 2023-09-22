import java.util.*;

public class ValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {

//        check each row
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j< 9; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                if (set.contains(board[i][j])) {
                    return false;
                }else {
                    set.add(board[i][j]);
                }
            }
        }

//        check each column
        for (int j = 0; j < 9; j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i< 9; i++) {

                if (board[i][j] == '.') {
                    continue;
                }

                if (set.contains(board[i][j])) {
                    return false;
                }else {
                    set.add(board[i][j]);
                }
            }
        }

//        check each square

//        for (int i = 0; i < 9; i+=3) {
//
//            for (int j = 0; j< 9; j+=3) {
//                Set<Character> set = new HashSet<>();
//
//                for (int k = 0; k <9; k++) {
//                    int row = i + k/3;
//                    int col = j + k%3;
//                    if (board[row][col] == '.') {
//                        continue;
//                    }
//
//                    if (set.contains(board[row][col])) {
//                        return false;
//                    }else {
//                        set.add(board[row][col]);
//                    }
//                }
//            }
//        }

        for (int i = 0; i <9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {

                int rowIndex = 3*(i/3);
                int colIndex = 3*(i%3);

                if (board[rowIndex+j/3][colIndex+j%3] == '.') {
                    continue;
                }

                if (set.contains(board[rowIndex+j/3][colIndex+j%3])) {
                    return false;
                }else {
                    set.add(board[rowIndex+j/3][colIndex+j%3]);
                }
            }

        }

        return true;

    }
}
