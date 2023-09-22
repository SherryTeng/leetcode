import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int k = n;
        while(k!=1) {
            k = getNext(k);
            if (set.contains(k)) return false;
            set.add(k);

        }

        return true;

    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n/10;
            sum += d*d;
        }
        return sum;
    }
}
