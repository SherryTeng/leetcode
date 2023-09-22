import java.util.*;

public class UniqueNumberofOccurrences_1207 {
    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num: arr) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        Set<Integer> set = new HashSet<>();

        for (Map.Entry<Integer, Integer> entryset: map.entrySet()) {
            if (set.contains(entryset.getValue())) {
                return false;
            }

            set.add(entryset.getValue());
        }

        return true;

    }
}
