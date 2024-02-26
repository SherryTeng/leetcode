import java.util.*;

public class PascalsTriangle_118 {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        if (numRows == 0) return res;
        if (numRows == 1) {
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            res.add(firstRow);
            return res;
        }

        res = generate(numRows-1);

        List<Integer> prevRow = res.get(numRows-2);

        List<Integer> currRow = new ArrayList<>();

        currRow.add(1);

        for (int i = 1; i < numRows-1; i++) {
            currRow.add(prevRow.get(i-1)+ prevRow.get(i));
        }

        currRow.add(1);

        res.add(currRow);
        return res;


    }
}
