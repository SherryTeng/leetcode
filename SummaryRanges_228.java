import java.util.*;
public class SummaryRanges_228 {
    public static List<String> summaryRanges(int[] nums) {
        int n = nums.length;

        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        if (n == 1) {
            res.add(nums[0]+"");
            return res;
        }

        for (int i =0; i< nums.length;i++) {
            int start = nums[i];

            while(i+1< nums.length && nums[i+1] == nums[i]+1) {
                i++;
            }

            if (start == nums[i]) {
                res.add(start+"");
            }else{
                res.add(start+"->"+nums[i]);
            }

        }
        return res;




    }
    public static void main(String[] args) {
        int[] nums = new int[] {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }
}


