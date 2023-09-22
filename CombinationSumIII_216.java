import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 *               k=9, n=45
 *        1, 2, 3, 4
 *
 *
 */
public class CombinationSumIII_216 {
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> comb = new ArrayList<>();
        backtrack(1, 0, comb, k, n);
        return res;

    }
    private static void backtrack(int start, int currSum, List<Integer> comb, int k, int n){

        if (currSum > n) return;
        if (k == 0 && currSum == n) {
            res.add(new ArrayList<>(comb));
            backtrack(start+1, 0, new ArrayList<>(), k,n);
            return;
        }
        if(start > 9) return;

        for (int i = start; i <= 9; i++) {
            comb.add(i);
            currSum += i;

            backtrack(i+1,currSum, comb, k-1,n);
            comb.remove(comb.size()-1);
            currSum -= i;
        }

    }
    public static void main(String[] args) {
        combinationSum3(3, 9);
    }
}
