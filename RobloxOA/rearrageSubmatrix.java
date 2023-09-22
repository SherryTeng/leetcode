package RobloxOA;

import java.util.*;

public class rearrageSubmatrix {

    public static int[][] rearrange(int[][] matrix) {
        int n = matrix[0].length/2;

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[4]-b[4]);
        int[][] res = new int[2][2*n];

        for(int i =0; i < n; i++) {
            int[] sub = new int[5];
            sub[0] = matrix[0][2*i];
            sub[1] = matrix[0][2*i+1];
            sub[2] = matrix[1][2*i];
            sub[3] = matrix[1][2*i+1];
            sub[4] = lowestInt(new int[]{sub[0], sub[1],sub[2],sub[3]});
            q.add(sub);

        }

        int k = 0;
        while (!q.isEmpty()) {
            int[] sub = q.remove();
            res[0][2*k] = sub[0];
            res[0][2*k+1] = sub[1];
            res[1][2*k] = sub[2];
            res[1][2*k+1] = sub[3];
            k++;
        }

        return res;
    }

    private static int lowestInt(int[] sub) {
        int lowest = 1;

        Set<Integer> set = new HashSet<>();
        for (int num: sub) {
            set.add(num);
        }

        while (true){
            if (!set.contains(lowest)){
                break;
            }else {
                lowest++;
            }
        }
        return lowest;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,1,2,1,1,2,3},
                {3,4,4,5,2,4,4,5}
        };

        int[][] res = rearrange(matrix);
        for (int i = 0; i < res.length; i++) {
            // Iterate through the columns
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            // Print a newline after each row
            System.out.println();
        }

    }
}
