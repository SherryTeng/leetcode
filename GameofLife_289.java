public class GameofLife_289 {
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1},{-1,1},{-1,-1},{1,-1},{1,1}};
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j =0; j < n; j++) {

                int live = 0;
                for (int[] dir: dirs) {
                    int row = dir[0] + i;
                    int col = dir[1]+j;

                    if (row <0 || col < 0|| row >=m ||col >=n) {
                        continue;
                    }

                    if (board[row][col] == 1||board[row][col] == 2) {
                        live ++;
                    }
                }

                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 2;
                }


            }
        }

        for (int i = 0; i< m; i++){
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 3 || board[i][j] == 2) {
                    board[i][j] = board[i][j] %2;
                }
            }
        }

    }
}
