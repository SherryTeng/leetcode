import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GetMaxNumber {
    public static long getMaximumPower(List<Integer> power) {
        // Write your code here
        int n = power.get(0);
        if(n == 1) {
            return power.get(1);
        }
        power = power.subList(1, power.size());
        Collections.sort(power);
        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = power.get(0);
        for(int i=2; i< n +1; i++){
            int current = power.get(i - 1);
            if(power.get(i-2) + 1 != power.get(i - 1)) {
                dp[i] = dp[i-1] + power.get(i -1);
            }else {
                dp[i] = Math.max(dp[i-2] + power.get(i -1), dp[i-1]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(getMaximumPower(Arrays.asList(5,1,2,3,4,5)));
    }
}
