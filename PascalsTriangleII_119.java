import java.util.*;
import java.util.jar.Attributes;

public class PascalsTriangleII_119 {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> res = new ArrayList<>();

        if (rowIndex == 0) {
            res.add(1);
            return res;
        }

        List<Integer> prev = getRow(rowIndex-1);

        res.add(1);

        for (int i =1; i < rowIndex; i++) {
            res.add(prev.get(i-1)+prev.get(i));
        }

        res.add(1);
        return res;






    }
}
