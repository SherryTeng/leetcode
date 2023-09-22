import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FindIfPathExistsInGraph {
    public static boolean validPath(int n, int[][] edges, int source, int destination) {


        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n ;i ++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i ++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(source);

        while (!q.isEmpty()) {
            int curr = q.remove();
            visited.add(curr);
            if (curr == destination) return true;
            for (int v : graph[curr]) {
                if (!visited.contains(v)) {
                    q.add(v);
                }
            }
        }

        return false;
    }

    public static void main (String[] args) {
        int[][] edges = {{0,1}, {0,2}, {1,2}};
        boolean test = FindIfPathExistsInGraph.validPath(3, edges, 0, 2);
        System.out.println(test);
    }
}
