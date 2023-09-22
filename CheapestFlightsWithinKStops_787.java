import java.util.*;

public class CheapestFlightsWithinKStops_787 {
    //Method 1: BFS, Dijkstra's algo
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        //1.form graph
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            if (!graph.containsKey(flight[0])) {
                graph.put(flight[0], new HashMap<>());
            }
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        //2. PriorityQ
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        q.add(new int[]{0, src, 0});

        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        while (!q.isEmpty()) {
            int[] curr = q.remove();
            int cost = curr[0];
            int currStop = curr[1];
            int stops = curr[2];

            if (currStop == dst) return cost;

            if (stops > k) continue;

            if (visited[currStop] != -1 && visited[currStop] < stops) continue;
            visited[currStop] = stops;

            Map<Integer, Integer> adj = graph.getOrDefault(currStop, new HashMap<>());

            for (int next : adj.keySet()) {
                q.add(new int[]{cost + adj.get(next), next, stops + 1});


            }
        }
        return -1;
    }
}
