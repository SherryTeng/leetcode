//public class SurroundedRegions_130 {
//    public static void solve(char[][] board) {
//        int m = board.length, n=board[0].length;
//        if (m <=2 || n <= 2) return;
//
//        for (int i =0; i < m ;i++) {
//            if (board[i][0]=='O') dfs(board, i, 0);
//            if (board[i][n-1] == 'O') dfs(board, i, n-1);
//        }
//
//        for (int j = 0; j < n; j++) {
//            if (board[0][j] == 'O') dfs(board, 0, j);
//            if (board[m-1][j] == 'O') dfs(board, m-1, j);
//        }
//
//        for (int i =0; i < m; i++) {
//            for (int j =0; j< n; j++) {
//                if (board[i][j] == 'O') board[i][j] = 'X';
//                if (board[i][j] == '*') board[i][j] = 'O';
//            }
//        }
//
//    }
//
//    private void dfs(char[][] board, int r, int c) {
//        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O') return;
//        board[r][c] = '*';
//        dfs(board, r+1, c);
//        dfs(board, r-1, c);
//        dfs(board, r, c+1);
//        dfs(board, r, c-1);
//
////        int m = board.length;
////        int n = board[0].length;
////
////        for (int i = 0; i < m; i++){
////            if (board[i][0] == '0') {
////                board[i][0] = '#';
////
////            }
////
////            if (board[i][n-1] == '0') {
////                board[i][n-1] = '#';
////
////            }
////        }
////
////        for (int i = 0; i < n; i++){
////            if (board[0][i] == '0') {
////                board[0][i] = '#';
////
////            }
////
////            if (board[m-1][i] == '0') {
////                board[m-1][i] = '#';
////
////            }
////        }
////
////        for (int i = 0; i < m; i++){
////            for (int j = 0; j < n; j++){
////                if (board[i][j] == '#'){
////                    dfs1(board, i, j, m, n);
////                }
////            }
////        }
////
////        for (int i = 0; i < m; i++){
////            for (int j = 0; j < n; j++){
////                if (board[i][j] == '0'){
////                    dfs2(board, i, j, m, n);
////                }
////            }
////        }
////
////        for (int i = 0; i < m; i++){
////            for (int j = 0; j < n; j++){
////                if (board[i][j] == '#'){
////                    board[i][j] = '0';
////
////                }
////            }
////        }
////
//    }
//
////    private static void dfs1(char[][] board, int i, int j, int m, int n){
////
////        if (i <0 || i >= m || j < 0|| j >=n || board[i][j] == 'X'|| board[i][j] == '#') return;
////        board[i][j] = '#';
////
////        dfs1(board, i+1, j, m,n);
////        dfs1(board, i-1, j, m,n);
////        dfs1(board, i, j+1, m,n);
////        dfs1(board, i, j-1, m,n);
////
////
////    }
////
////    private static void dfs2(char[][] board, int i, int j, int m, int n){
////
////        if (i <0 || i >= m || j < 0|| j >=n || board[i][j] != '0') return;
////        board[i][j] = 'X';
////
////        dfs2(board, i+1, j, m,n);
////        dfs2(board, i-1, j, m,n);
////        dfs2(board, i, j+1, m,n);
////        dfs2(board, i, j-1, m,n);
////
////
////    }
//
//    public static void main(String[] args){
//
//        char[][] board = new char[][]{{'X','X','X','X'},{'X','0','0','X'},{'X','X','0','X'},{'X','0','X','X'}};
//        solve(board);
//
//
//    }
//
//
//}
