import java.util.*;
public class Triangle_120 {
    /*
     bottom up solution
     dp[i][j] =Math.min(dp[i+1][j], do[i+1][j+1])+ nums[i][j]
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

//        int[][] dp = new int[n+1][n+1];
//
//        for (int i = n-1; i >= 0; i--) {
//            for (int j = 0; j < triangle.get(i).size(); j++) {
//
//                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
//
//            }
//        }
//
//        return dp[0][0];

        int[] dp = new int[n+1];

        for (int i = n-1; i >=0; i--){
            for (int j =0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1])+triangle.get(i).get(j);
            }
        }

        return dp[0];



    }
}
