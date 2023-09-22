public class EditDistance_72 {
//  base case : 1.word1: "abc"
//                word2: ""       3
//              2.word1: ""
//                word2: "abc"    3


// W1:   a b d
//         i
// W2:   a c d
//         j

//    if (W1[i] == W2[j])  (i+1, j+1)
//    else:

//    1. insert (i,j+1)
//    2. delete  (i+1, j)
//    3. replace (i+1, j+1)






    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        //dp[i][j]
        int[][] dp = new int[m+1][n+1];
        //base case
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j];
                }else {
                    dp[i+1][j+1] = Math.min(dp[i][j+1]+1, Math.min(dp[i+1][j]+1, dp[i][j]+1));

                }
            }
        }
        return dp[m][n];


    }
}
