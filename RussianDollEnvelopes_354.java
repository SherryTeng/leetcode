import java.util.Arrays;

public class RussianDollEnvelopes_354 {

    //Method 1:
    public int maxEnvelopes(int[][] envelopes) {
        //edge case
        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length !=2) return 0;

        //1. sort envelops based on width, if width is same, sort height in descending order
        Arrays.sort(envelopes, (a,b)-> a[0]==b[0]? b[1]-a[1]:a[0]-b[0]);

// binary search solution: O(nlogn)
// width is increasing, but if two widths are the same, the height is decreasing
// after sorting, all envolopes are valid 'based on width', so we just binary search based on 'heights'
// to choose 'some of them' to meet the requirement
// Ex. after sorting: (1,3), (3,5), (6,8), (6,7), (8,4), (9,5)
// transform to question find LIS: [3,5,8,7,4,5] => like '300. Longest Increasing Subsequence'
        int[] dp = new int[envelopes.length];
        int size = 0;
        for (int[] envelop : envelopes) {
            int left =0, right = size;
            while (left < right) {
                int middle = left + (right-left)/2;
                if (dp[middle] < envelop[1]) {
                    left = middle+1;
                }else {
                    right = middle;
                }
            }
            dp[left] = envelop[1];
            if (left == size) {
                size++;
            }
        }
        return size;
    }


//    //Method 2: dynamic programming (time limited exceeding)
//    public int maxEnvelopes(int[][] envelopes) {
//        //edge case
//        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelops[0].length !=2) return 0;
//
//        //1. sort envelops based on width, if width is same, sort height
//        Arrays.sort(envelopes, (a,b)-> (a[0]-b[0]));
//
//        //2. dp[i] denotes the max when i is the end
//        int n = envelopes.length;
//        int[] dp = new int[n];
//
//
//
//        int max =1;
//        for (int i =0; i < n; i++) {
//            dp[i] =1;
//            for (int j = 0; j < i; j++) {
//                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1]> envelopes[j][1]) {
//                    dp[i] = Math.max(dp[i], dp[j]+1);
//                }
//            }
//
//            max = Math.max(max, dp[i]);
//        }
//
//
//        return max;
//    }
}
