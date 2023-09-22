import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingPuzzle_773 {
    public int slidingPuzzle(int[][] board) {

        String target = "123450";
        String start = "";

        for (int i = 0; i< board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j];
            }
        }

        int[][] dirs = new int[][] {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};

        int res = 0;
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(start);
        visited.add(start);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i =0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(target)) return res;

                int indexZero = curr.indexOf('0');

                for(int dir : dirs[indexZero]) {
                    String next = swap(curr, indexZero, dir);
                    if (visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    q.add(next);
                }
            }
            res++;

        }
        return -1;
    }

    private String swap(String curr, int i, int j) {
        StringBuilder sb = new StringBuilder(curr);
        sb.setCharAt(i, curr.charAt(j));
        sb.setCharAt(j, curr.charAt(i));
        return sb.toString();

    }
}
