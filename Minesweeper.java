public class Minesweeper {
    private static final int[][] dirs = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 },  { -1, 1 } };
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        dfs(board, click[0], click[1]);
        return board;

    }
    private void dfs(char[][] board, int i, int j) {
        if (i<0 || i >= board.length|| j < 0|| j >= board[0].length || board[i][j] != 'E') return;

        board[i][j] = '0';
        for (int[] nei : dirs) {
            int neiRow = i + nei[0];
            int neiCol = j + nei[1];
            if (neiRow < 0 || neiRow >= board.length || neiCol < 0 || neiCol >= board[0].length) continue;
            if (board[neiRow][neiCol] == 'M');
            board[i][j]++;
        }

        if (board[i][j] != '0') return;

        board[i][j] = 'B';
        for (int[] nei : dirs) {
            dfs(board, i+nei[0], j+nei[1]);
        }

    }
}
