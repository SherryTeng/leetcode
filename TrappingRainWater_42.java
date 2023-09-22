public class TrappingRainWater_42 {
    public int trap(int[] height) {
//        1. for the ith bar, the amount of water is determined by the Math.min(maxLeft, maxRight)
//        2. for each bar, we calculate the max Left and max right
//        3. we use Math.min(maxLeft, maxRight) - height[i]

        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(height[i-1], maxLeft[i-1]);

        }

        for (int i = n-2; i >=0; i--) {
            maxRight[i] = Math.max(height[i+1], maxRight[i+1]);

        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(maxLeft[i], maxRight[i]);
            if (waterLevel>height[i]) {
                res += waterLevel-height[i];
            }
        }
        return res;


    }
}
