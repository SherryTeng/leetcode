import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.*;
public class NQueens_51 {
    private List<List<String>> res = new ArrayList<>();
    private int size;
    public List<List<String>> solveNQueens(int n) {

        size =n;

        char[][] emptyBoard = new char[n][n];
        for (int i = 0; i<n;i++) {
            for (int j = 0; j< n; j++) {
                emptyBoard[i][j] = '.';
            }
        }

        backtrack(0, new HashSet<>(), new HashSet<>(),new HashSet<>(),emptyBoard);
        return res;
    }
    private void backtrack(int row, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiagonals, char[][] state) {
        if (row == size) {
            res.add(createBoard(state));
            return;
        }

        for (int col = 0; col < size; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;
            if (cols.contains(col) || diagonals.contains(currDiagonal)||antiDiagonals.contains(currAntiDiagonal)) continue;

            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            state[row][col] = 'Q';

            backtrack(row +1,cols, diagonals, antiDiagonals,  state);

            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
            state[row][col] ='.';
        }

    }

    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<>();
        for (int i=0; i < size; i++) {
            String row= new String(state[i]);
            board.add(row);
        }
        return board;

    }
}
