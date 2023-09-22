import java.util.*;

public class PossibleBipartition_886 {
    public boolean possibleBipartition(int n, int[][] dislikes) {

        List<Integer>[] graph = new ArrayList[n];
        for (int i =0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i =0; i < dislikes.length; i++) {
            graph[dislikes[i][0]-1].add(dislikes[i][1]-1);
            graph[dislikes[i][1]-1].add(dislikes[i][0]-1);
        }

        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) continue;

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            colors[i] = 1;


            if (graph[i] == null) continue;

            while (!q.isEmpty()) {

                int curr = q.remove();

                for(int next : graph[curr]) {
                    if (colors[next] == 0) {
                        colors[next] = -colors[curr];
                        q.add(next);
                    }else if (colors[next] == colors[curr]) return false;
                }

            }

        }

        return true;
    }
}
