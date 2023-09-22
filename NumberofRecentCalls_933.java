import java.util.*;

public class NumberofRecentCalls_933 {

    Queue<Integer> q;
    public NumberofRecentCalls_933() {
        q = new LinkedList<>();

    }

    public int ping(int t) {
        q.offer(t);

        while(q.peek() < t-3000){
            q.poll();
        }

        return q.size();

    }
}
