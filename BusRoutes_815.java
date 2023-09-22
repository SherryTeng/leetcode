import java.util.*;
public class BusRoutes_815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {


        int m = routes.length;
        Map<Integer,List<Integer>> g = new HashMap<>();
        for(int i=0; i < m; i++) {
            for (int j = 0; j < routes[i].length; j++) {
//                List<Integer> buses = g.getOrDefault(routes[i][j], new ArrayList<>());
//                buses.add(i);
//                g.put(routes[i][j], buses);
                if (!g.containsKey(routes[i][j])) {
                    List<Integer> buses = new ArrayList<>();
                    buses.add(i);
                    g.put(routes[i][j], buses);
                }
                g.get(routes[i][j]).add(i);
            }
        }

        if (source==target) return 0;
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(source);
        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            for (int i = 0; i < size; i++) {
                int curr = q.remove();
                List<Integer> buses = g.get(curr);
                for (int bus: buses) {
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for (int stop: routes[bus]) {
                        if (stop == target) return res;
                        q.add(stop);
                    }

                }
            }
        }
        return -1;

    }
}
