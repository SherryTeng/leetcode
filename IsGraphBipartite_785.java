import java.util.*;

public class IsGraphBipartite_785 {

//    //BFS
//    public static boolean isBipartite(int[][] graph) {
//        int len = graph.length;
//        int[] colors = new int[len];
//
//        for (int i = 0; i < len; i++) {
//            if (colors[i] != 0) continue;
//            Queue<Integer> q = new LinkedList<>();
//            q.add(i);
//            colors[i] = 1;
//
//            while (!q.isEmpty()) {
//                int curr = q.remove();
//                for (int next : graph[curr]) {
//                    if (colors[next] == 0) {
//                        colors[next] = -colors[curr];
//                        q.add(next);
//                    } else if (colors[next] == colors[curr]) {
//                        return false;
//                    }
//                }
//            }
//        }
//
//        return true;



//    }
    //DFS

    private boolean[] visited;
    private boolean[] colors;
    private boolean ok = true;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        colors = new boolean[n];
        visited = new boolean[n];

        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                traverse(graph, v);
            }
        }

        return ok;

    }

    private void traverse(int[][] graph, int v) {
        if (!ok) return;

        visited[v] = true;
        for (int w: graph[v]) {
            if (!visited[w]) {
                colors[w] = !colors[v];
                traverse(graph, w);
            }else{
                if (colors[w] == colors[v]) {
                    ok=false;
                    return;
                }
            }
        }


    }

}
