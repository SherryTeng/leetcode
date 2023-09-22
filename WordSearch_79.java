public class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j] && helper(board, word, m, n, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int m, int n, int i, int j, int start) {
        if (start == word.length()) return true;

        if (i < 0|| j < 0 || i >= m || j >=n || board[i][j] == '0' || board[i][j] != word.charAt(start)) return false;

        char tmp = board[i][j];
        board[i][j] = '0';

        if (helper(board, word, m, n, i+1, j, start+1) ||
                helper(board, word, m, n, i-1, j, start+1) ||
                helper(board, word, m, n, i, j+1, start+1) ||
                helper(board, word, m, n, i, j-1, start+1)
        ) return true;

        board[i][j] = tmp;
        return false;

    }


}
