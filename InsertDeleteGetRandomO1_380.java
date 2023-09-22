import java.util.ArrayList;
import java.util.*;

public class InsertDeleteGetRandomO1_380 {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> map;
    java.util.Random rand;

    public InsertDeleteGetRandomO1_380() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, nums.size());
        nums.add(val);
        return true;

    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int location = map.get(val);

        if (location != nums.size()-1) {
            int last = nums.get(nums.size()-1);
            nums.set(location, last);
            map.put(last, location);
        }

        map.remove(val);
        nums.remove(nums.size()-1);
        return true;

    }

    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));

    }
}
