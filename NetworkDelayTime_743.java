import java.util.*;
public class NetworkDelayTime_743 {
    public int networkDelayTime(int[][] times, int n, int k) {

        if (times==null ||times.length==0|| k < 1 || k > n) return -1;

        //form graph
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }
        if (!graph.containsKey(k)) return -1;

        Queue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        q.add(new int[]{0,k});

        int res=0;
        boolean[] visited = new boolean[n+1];

        while(!q.isEmpty()) {
            int[] curr = q.remove();
            int currNode = curr[1];
            int currDist = curr[0];
            if (visited[currNode]) continue;
            visited[currNode] = true;
            res = currDist;
            n--;
            if (n==0) return res;
            if (graph.containsKey(currNode)) {
                for (int next : graph.get(currNode).keySet()) {
                    q.add(new int[] {currDist+graph.get(currNode).get(next), next});
                }
            }
        }

        if (n!=0) return -1;
        return res;
    }
}
