import java.util.*;

public class EqualRowandColumnPairs_2352 {
    public static int equalPairs(int[][] grid) {

        Map<String, Integer> map = new HashMap<>();

        int n = grid.length;

        int pairs = 0;

        for (int[] row: grid){
            String s = Arrays.toString(row);
            map.put(s, map.getOrDefault(s, 0)+1);
        }

        for (int c = 0; c < n; c++){
            int[] col = new int[n];

            for (int r = 0; r < n; r++) {
                col[r] = grid[r][c];
            }

            pairs += map.getOrDefault(Arrays.toString(col),0);


        }
        return pairs;

    }

    public static void main(String[] args){
        int[][] grid = {{3,2,1},{1,7,6},{2,7,7}};
        equalPairs(grid);

    }
}
