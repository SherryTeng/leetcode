public class DungeonGame_174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n= dungeon[0].length;

        int[][] dp = new int[m][n];

        // base case
        if (dungeon[m-1][n-1] >= 0) {
            dp[m-1][n-1] = 1;
        }else {
            dp[m-1][n-1] = -dungeon[m-1][n-1] +1;
        }
        //rightmost column
        for (int i = m-2; i >= 0; i--) {
            dp[i][n-1] = -dungeon[i][n-1]+dp[i+1][n-1];
            if (dp[i][n-1] <=0) dp[i][n-1]=1;
            //dp[i][n-1] = Math.max(1, -dungeon[i][n-1]+dp[i+1][n-1]);
        }
        //bottom row
        for (int j = n-2; j >=0; j--) {
            dp[m-1][j] = -dungeon[m-1][j]+dp[m-1][j+1];
            if (dp[m-1][j] <=0) dp[m-1][j] =1;
            //dp[m-1][j] = Math.max(1, -dungeon[m-1][j]+dp[m-1][j+1]);
        }
        //transformative state
        for (int i = m-2; i >=0; i--) {
            for (int j = n-2; j >= 0; j--) {
                dp[i][j] = Math.min(-dungeon[i][j]+dp[i+1][j], -dungeon[i][j]+dp[i][j+1]);
                if (dp[i][j] <=0) dp[i][j] =1;
                //dp[i][j] = Math.min(Math.max(1, -dungeon[i][j]+dp[i+1][j]), Math.max(1,-dungeon[i][j]+dp[i][j+1]));
            }
        }

        return dp[0][0];

    }
}
