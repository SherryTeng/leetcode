public class SuperEggDrop_887 {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];

        for (int i = 1; i <= n; i++) {
            dp[1][i] = i;
        }

        for (int i =2; i <=k; i++) {
            for (int j =1; j <=n; j++) {
                int min = Integer.MAX_VALUE;

                int l = 1, r = j;
                while (l <=r) {
                    int mid  = l + (r-l)/2;
                    int a = dp[i-1][mid-1];
                    int b = dp[i][j-mid];
                    min = Math.min(min, Math.max(a,b)+1);
                    if (a==b) {
                        break;
                    }else if (a < b) {
                        l = mid+1;
                    }else {
                        r = mid-1;
                    }
                }
                dp[i][j] = min;
            }
        }
        return dp[k][n];

    }
}
