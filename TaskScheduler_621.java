import java.util.*;

public class TaskScheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c: tasks) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
        q.addAll(map.entrySet());

        int res = 0;

        while(!q.isEmpty()){
            int interval = n+1;
            List<Map.Entry<Character, Integer>> list = new ArrayList<>();

            while (interval > 0 && !q.isEmpty()){
                Map.Entry<Character, Integer> entry = q.poll();

                entry.setValue(entry.getValue()-1);

                list.add(entry);
                interval --;

                res++;
            }

            for (Map.Entry<Character, Integer> entry: list){
                if (entry.getValue()>0) {
                    q.offer(entry);
                }
            }

            if (q.isEmpty()) {
                break;
            }

            res+= interval;
        }

        return res;


    }
}
