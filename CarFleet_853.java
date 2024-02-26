import java.util.Map;
import java.util.TreeMap;

public class CarFleet_853 {
    public int carFleet(int target, int[] position, int[] speed) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < position.length; i++){
            map.put(target-position[i], speed[i]);
        }

        int count = 0;
        double r = -0.1;

        for (Map.Entry<Integer, Integer> entry: map.entrySet() ){
            int distance = entry.getKey();
            int s = entry.getValue();
            double time = 1.0*distance/s;

            if (time > r) {
                count++;
                r = time;
            }
        }

        return count;



    }
}
