import java.util.ArrayList;
import java.util.List;

public class combinations_77 {
    static List<List<Integer>>  res = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> combo = new ArrayList<>();
        backtrack(n, k, 1, combo);

        return res;

    }

    private static void backtrack(int n, int k, int start, List<Integer> combo) {
        if (combo.size() >= k) {
            res.add(new ArrayList<>(combo));
            return;
        }

        for (int i = start; i <=n; i++) {
            combo.add(i);
            backtrack(n,k,i+1, combo);
            combo.remove(combo.size()-1);
        }

    }

    public static void main(String[] args) {
        combine(4,2);
    }
}
