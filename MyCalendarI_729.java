import java.util.Map;
import java.util.TreeMap;

public class MyCalendarI_729 {

    TreeMap<Integer, Integer> calendar = new TreeMap<>();

    public MyCalendarI_729(){
        calendar.put(Integer.MAX_VALUE, Integer.MIN_VALUE);

    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> pair = calendar.higherEntry(start);
        boolean res = end <= pair.getValue();
        if (res) calendar.put(end, start);
        return res;
    }
}
